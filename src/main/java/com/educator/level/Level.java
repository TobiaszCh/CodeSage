package com.educator.level;
import com.educator.task.Task;
import com.educator.subject.Subject;
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
    private Subject subject;
    @OneToMany
    private List<Task> tasks;
}
