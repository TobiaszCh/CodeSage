package com.educator.core.course.dto;

import com.educator.core.course.Visibility;
import com.educator.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank(message = "Kurs musi zawierać wartość")
    @Size(max = 100)
    private String displayName;

    @NotBlank(message = "Opis musi zawierać wartość")
    @Size(max = 700)
    private String description;

    private String imageUrl;

    @NotNull(message = "Kurs musi mieć ustawioną widoczność")
    private Visibility visibility;

    private User owner;

    boolean accessToModifyCourseAndSubjectWithQuestions;

    @JsonIgnore
    public User getOwner() {
        return owner;
    }

}
