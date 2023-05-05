package com.educator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Basic {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Course course;

    @OneToMany
    private List<Task> tasks;

}
