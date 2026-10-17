package com.educator.core.course.dto;

import com.educator.core.course.Visibility;
import com.educator.core.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseSummaryDto {

    private Long id;

    private String displayName;

    private String imageUrl;

    private Visibility visibility;

    private User owner;

    private long countOfSubjectsInCourse;

    boolean accessToModifyCourse;

    public CourseSummaryDto(Long id, String displayName, String imageUrl, Visibility visibility, User owner, long countOfSubjectsInCourse) {
        this.id = id;
        this.displayName = displayName;
        this.imageUrl = imageUrl;
        this.visibility = visibility;
        this.owner = owner;
        this.countOfSubjectsInCourse = countOfSubjectsInCourse;
    }

    @JsonIgnore
    public User getOwner() {
        return owner;
    }

    public void setAccessToModifyCourse(boolean accessToModifyCourse) {
        this.accessToModifyCourse = accessToModifyCourse;
    }
}
