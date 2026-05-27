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
        return courseMapper.mapToDtoCourse(courseRepository.findById(id)
                .orElseThrow(() -> new CodeSageRuntimeException("This course doesn't exist")));
    }

    public List<DisplayNameCourseDto> getAllCourses() {
        User loggedUser = authService.getLoggedUser();
        return courseMapper.mapToListDtoDisplayNameCourse(courseRepository.findAllByUsersContainsOrderByIdAsc(loggedUser));
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public Long createCourse(CourseDto courseDto, MultipartFile file) {
        User loggedUser = authService.getLoggedUser();
        courseValidator.validateCourseDetails(courseDto, file);
        Course course = courseRepository.save(courseMapper.mapToCourse(courseDto, List.of(loggedUser)));
        course.setImageUrl(s3Service.uploadFile(course.getId(), file));
        return course.getId();
    }

    @Transactional
    public Long updateCourse(Long id, CourseDto courseDto, MultipartFile file) {
        courseValidator.validateCourseDetails(courseDto, file);
        Course course = Optional.ofNullable(id)
                .flatMap(courseRepository::findById)
                .orElseThrow(() -> new CodeSageRuntimeException("Entity with id: " + id + " doesn't exist"));
        String oldImageUrl = course.getImageUrl();
        course.setDisplayName(courseDto.getDisplayName());
        course.setDescription(courseDto.getDescription());
        course.setVisibility(courseDto.getVisibility());
        course.setImageUrl(s3Service.uploadFile(id, file));
        outboxEventService.createOutboxEvent(oldImageUrl, OutboxEventType.OLD_IMAGE_URL);
        return course.getId();
    }

}
