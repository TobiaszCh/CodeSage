package com.educator.level_management;

import com.educator.task_management.Task;
import com.educator.variable_management.Variable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Variable variable;

    @OneToMany
    private List<Task> tasks;

}
