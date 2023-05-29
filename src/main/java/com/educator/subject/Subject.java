package com.educator.subject;
import com.educator.course.Course;
import com.educator.level.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Course course;
    @OneToMany
    private List<Level> levels;
}
