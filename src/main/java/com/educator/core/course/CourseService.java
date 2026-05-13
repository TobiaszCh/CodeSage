package com.educator.core.course;

import com.educator.auth.AuthService;
import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.DisplayNameCourseDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.s3.S3Service;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    private final AuthService authService;

    private final S3Service s3Service;

    public CourseDto getCourseById(Long id) {
        return courseMapper.mapToDtoCourse(courseRepository.findById(id)
                .orElseThrow(() -> new CodeSageRuntimeException("This course doesn't exist")));
    }

    public List<DisplayNameCourseDto> getAllMyCourses() {
        User loggedUser = authService.getLoggedUser();
        return courseMapper.mapToListDtoDisplayNameCourse(courseRepository.findAllByUsersContainsOrderByIdAsc(loggedUser));
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Transactional
    public Long createMyCourse(CourseDto courseDto, MultipartFile file) {
        User loggedUser = authService.getLoggedUser();
        courseDto.setDisplayName(courseDto.getDisplayName().trim());
        Course course = courseRepository.save(courseMapper.mapToCourse(courseDto, List.of(loggedUser)));
        course.setImageUrl(s3Service.uploadFile(course.getId(), file));
        return course.getId();
    }

    public void updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CodeSageRuntimeException("This course doesn't exist"));
        course.setDisplayName(courseDto.getDisplayName().trim());
        courseRepository.save(course);
    }

}
