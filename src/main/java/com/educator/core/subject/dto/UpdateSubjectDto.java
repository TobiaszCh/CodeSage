package com.educator.core.subject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateSubjectDto {

    @NotBlank
    private String displayName;
}
