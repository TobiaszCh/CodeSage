package com.educator.core.course;

import com.educator.auth.AuthService;
import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.CourseSummaryDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.outbox_event.OutboxEventService;
import com.educator.core.outbox_event.OutboxEventType;
import com.educator.core.user.User;
import com.educator.s3.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final AuthService authService;
    private final S3Service s3Service;
    private final CourseValidator courseValidator;
    private final OutboxEventService outboxEventService;

    public CourseDto getCourseById(Long id) {
        Course course = Optional.ofNullable(id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + id + " doesn't exist"));
        return courseMapper.mapToDtoCourse(course);
    }

    public List<CourseSummaryDto> getAllCourses() {
        User loggedUser = authService.getLoggedUser();
        List<CourseSummaryDto> courseSummaries = courseRepository.findOwnedOrPublicCourses(loggedUser.getId());
        courseSummaries.forEach(result -> result.setAccessToModifyCourse(canModify(result, loggedUser)));
        return courseSummaries;
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public Long createCourse(CourseDto courseDto, MultipartFile file) {
        User loggedUser = authService.getLoggedUser();
        courseValidator.validateCourseDetailsInCreate(courseDto, file);
        Course course = courseRepository.save(courseMapper.mapToCourse(courseDto, loggedUser));
        course.setImageUrl(s3Service.uploadFile(course.getId(), file));
        return course.getId();
    }

    @Transactional
    public Long updateCourse(Long id, CourseDto courseDto, MultipartFile file) {
        courseValidator.validateCourseDetailsInUpdate(courseDto, file);
        Course course = Optional.ofNullable(id).flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + id + " doesn't exist"));
        course.setDisplayName(courseDto.getDisplayName());
        course.setDescription(courseDto.getDescription());
        course.setVisibility(courseDto.getVisibility());
        if (!file.isEmpty()) {
            String oldImageUrl = course.getImageUrl();
            course.setImageUrl(s3Service.uploadFile(id, file));
            if (oldImageUrl != null && !oldImageUrl.isEmpty()) {
                outboxEventService.createOutboxEvent(oldImageUrl, OutboxEventType.OLD_IMAGE_URL);
            }
        }
        return course.getId();
    }

    private boolean canModify(CourseSummaryDto courseSummaryDto, User user) {
        if (courseSummaryDto == null) {
            throw new CodeSageRuntimeException("Course is null");
        }
        if (user == null) {
            throw new CodeSageRuntimeException("User is null");
        }
        if (courseSummaryDto.getOwner() == null) {
            throw new CodeSageRuntimeException("Course doesn't have own owner");
        }
        return courseSummaryDto.getOwner().getId().equals(user.getId());
    }

}
