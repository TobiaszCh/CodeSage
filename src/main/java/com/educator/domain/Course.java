package com.educator.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

}
