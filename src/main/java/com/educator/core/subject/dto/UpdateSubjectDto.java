package com.educator.core.subject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateSubjectDto {

    @NotBlank
    @Size(max = 50)
    private String displayName;
}
