package com.educator.aspect;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.course.Visibility;
import com.educator.core.course.dto.CourseDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.subject.SubjectRepository;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceAccess {

    public final AuthService authService;
    public final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    private final AnswerSessionService answerSessionService;

    public void checkAccess(Long id, CourseAccess courseAccess) {
        switch (courseAccess.idEntityType()) {
            case COURSE:
                checkAccessByCourseId(id, courseAccess.accessPolicy());
                break;
            case SUBJECT:
                checkAccessBySubjectId(id, courseAccess.accessPolicy());
                break;
            case ANSWER_SESSION:
                checkAccessByAnswerSessionId(id, courseAccess.accessPolicy());
                break;
        }
    }

    private void checkAccessByCourseId(Long courseId, AccessPolicy accessPolicy) {
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessByAnswerSessionId(Long answerSessionId, AccessPolicy accessPolicy) {
        Long courseId = Optional.ofNullable(answerSessionId)
                .map(answerSessionService::getCourseId)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + answerSessionId + " doesn't exist"));
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessBySubjectId(Long subjectId, AccessPolicy accessPolicy) {
        Long courseId = Optional.ofNullable(subjectId)
                .flatMap(subjectRepository::findCourseIdBySubjectId)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + subjectId + " doesn't exist"));
        checkAccessToCourse(courseId, accessPolicy);
    }

    private void checkAccessToCourse(Long Id, AccessPolicy accessPolicy) {
        Course course = Optional.ofNullable(Id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + Id + " doesn't exist"));
        checkAccessPolicy(course, accessPolicy);
    }

    private void checkAccessPolicy(Course course, AccessPolicy accessPolicy) {
        User loggedUser = authService.getLoggedUser();
        boolean isOwner = loggedUser.getId().equals(course.getOwner().getId());
        boolean isPublic = course.getVisibility() == Visibility.PUBLIC;
        switch (accessPolicy) {
            case MANAGE:
                if (!isOwner) {
                    throw new CodeSageRuntimeException("Access denied");
                }
                break;
            case LEARN:
                if (!isOwner && !isPublic) {
                    throw new CodeSageRuntimeException("Access denied");
                }
                break;
        }
    }

    public void checkVisibility(CourseDto courseDto) {
        User loggedUser = authService.getLoggedUser();
        if (loggedUser.getRole() == Role.DEMO && courseDto.getVisibility() == Visibility.PUBLIC) {
            throw new CodeSageRuntimeException("Access denied");
        }
    }

}
