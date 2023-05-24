package com.educator.user_management;

import com.educator.course_management.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String achievements;

    private String statistics;
    @OneToOne
    private Course course;
}
