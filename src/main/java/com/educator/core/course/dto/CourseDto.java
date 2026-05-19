package com.educator.core.course.dto;

import com.educator.core.course.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank(message = "Kurs musi zawierać wartość")
    @Size(max = 25)
    private String displayName;

    @NotBlank
    @Size(max = 700)
    private String description;

    private String imageUrl;

    private Visibility visibility;

}
