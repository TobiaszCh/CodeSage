package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class CourseValidator {
    private static final int IMAGE_SIZE = 5 * 1024 * 1024;
    private static final List<String> KIND_OF_FILES = List.of("image/jpg", "image/jpeg", "image/png", "image/webp");

    public void validateCourseDetailsInCreate(CourseDto courseDto, MultipartFile file) {
        assertNotNullAndEmptyInCreate(courseDto, file);
        validateImageInCreate(file);
        courseDto.setDisplayName(courseDto.getDisplayName().trim());
        courseDto.setDescription(courseDto.getDescription().trim());
    }

    public void validateCourseDetailsInUpdate(CourseDto courseDto, MultipartFile file) {
        assertNotNullAndEmptyInUpdate(courseDto, file);
        validateImageInUpdate(file);
        courseDto.setDisplayName(courseDto.getDisplayName().trim());
        courseDto.setDescription(courseDto.getDescription().trim());
    }

    private void validateImageInUpdate(MultipartFile file) {
        if (!file.isEmpty()) {
            validateImageInCreate(file);
        }
    }

    private void validateImageInCreate(MultipartFile file) {
        if (file.getSize() > IMAGE_SIZE) {
            throw CodeSageUserException.withUserMessage("Rozmiar obrazu przekracza 5MB");
        }
        if (!KIND_OF_FILES.contains(file.getContentType())) {
            throw CodeSageUserException.withUserMessage("Niepoprawny format obrazu", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void assertNotNullAndEmptyInCreate(CourseDto courseDto, MultipartFile file) {
        assertNotNullAndEmptyInUpdate(courseDto, file);
        if (file.isEmpty()) {
            throw CodeSageUserException.withUserMessage("Obraz musi zostać dodany");
        }
    }

    private void assertNotNullAndEmptyInUpdate(CourseDto courseDto, MultipartFile file) {
        if (courseDto == null) {
            throw new CodeSageRuntimeException("CourseDto is null");
        }
        if (file == null) {
            throw new CodeSageRuntimeException("MultipartFile is null");
        }
    }

}
