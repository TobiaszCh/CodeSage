package com.educator.core.course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    //@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    private Long id;

    private String displayName;

}


