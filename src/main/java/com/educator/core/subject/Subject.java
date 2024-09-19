package com.educator.core.subject;
import com.educator.core.course.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_sequence")
    //@SequenceGenerator(name = "subject_sequence", sequenceName = "subject_sequence", allocationSize = 1)
    private Long id;

    private String displayName;

    @ManyToOne
    private Course course;
}
