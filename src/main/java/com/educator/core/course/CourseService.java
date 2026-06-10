package com.educator.core.course;

import com.educator.auth.AuthService;
import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.DisplayNameCourseDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.outbox_event.OutboxEventService;
import com.educator.core.outbox_event.OutboxEventType;
import com.educator.core.s3.S3Service;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        User ownerCourse = authService.getLoggedUser();
        Course course = Optional.ofNullable(id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + id + " doesn't exist"));
        return courseMapper.mapToDtoCourse(course, canModify(course, ownerCourse));
    }

    public List<DisplayNameCourseDto> getAllCourses() {
        User ownerCourse = authService.getLoggedUser();
        List<Course> course = courseRepository.findAvailableCourses(ownerCourse.getId());
        return course.stream()
                .map(result -> courseMapper.mapToDtoDisplayNameCourse(
                        result, canModify(result, ownerCourse)
                ))
                .collect(Collectors.toList());
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public Long createCourse(CourseDto courseDto, MultipartFile file) {
        User ownerCourse = authService.getLoggedUser();
        courseValidator.validateCourseDetailsInCreate(courseDto, file);
        Course course = courseRepository.save(courseMapper.mapToCourse(courseDto, ownerCourse));
        course.setImageUrl(s3Service.uploadFile(course.getId(), file));
        return course.getId();
    }

    @Transactional
    public Long updateCourse(Long id, CourseDto courseDto, MultipartFile file) {
        courseValidator.validateCourseDetailsInUpdate(courseDto, file);
        Course course = Optional.ofNullable(id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + id + " doesn't exist"));
        course.setDisplayName(courseDto.getDisplayName());
        course.setDescription(courseDto.getDescription());
        course.setVisibility(courseDto.getVisibility());
        if (!file.isEmpty()) {
            String oldImageUrl = course.getImageUrl();
            course.setImageUrl(s3Service.uploadFile(id, file));
            outboxEventService.createOutboxEvent(oldImageUrl, OutboxEventType.OLD_IMAGE_URL);
        }
        return course.getId();
    }

    private boolean canModify(Course course, User user) {
        if (course == null) {
            throw new CodeSageRuntimeException("Course is null");
        }
        if (user == null) {
            throw new CodeSageRuntimeException("User is null");
        }
        if (course.getOwner() == null) {
            throw new CodeSageRuntimeException("Course doesn't have own owner");
        }
        return course.getOwner().getId().equals(user.getId());
    }

}
