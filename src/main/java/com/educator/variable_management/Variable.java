package com.educator.variable_management;

import com.educator.course_management.Course;
import com.educator.level_management.Level;
import com.educator.task_management.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Variable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Level> levels;

}
