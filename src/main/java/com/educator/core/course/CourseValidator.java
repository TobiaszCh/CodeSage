package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class CourseValidator {

    private static final int IMAGE_SIZE = 5 * 1024 * 1024;

    private static final List<String> KIND_OF_FILES = List.of("image/jpg", "image/jpeg", "image/png", "image/webp");

    public void validateCourseDetails(CourseDto courseDto, MultipartFile file) {
        assertNotNullAndEmpty(courseDto, file);
        validateImage(file);
        courseDto.setDisplayName(courseDto.getDisplayName().trim());
        courseDto.setDescription(courseDto.getDescription().trim());
    }

    private void validateImage(MultipartFile file) {
        if (file.getSize() > IMAGE_SIZE) {
            throw CodeSageUserException.withUserMessage("Rozmiar obrazu przekracza 5MB");
        }
        if (!KIND_OF_FILES.contains(file.getContentType())) {
            throw CodeSageUserException.withUserMessage("Niepoprawny format obrazu");
        }
    }

    private void assertNotNullAndEmpty(CourseDto courseDto, MultipartFile file) {
        if (courseDto == null) {
            throw new CodeSageRuntimeException("CourseDto is null");
        }
        if (file == null) {
            throw new CodeSageRuntimeException("MultipartFile is null");
        }
        if (file.isEmpty()) {
            throw CodeSageUserException.withUserMessage("Obraz musi zostać dodany");
        }
    }

}
