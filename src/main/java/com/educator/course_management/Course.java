package com.educator.course_management;
import com.educator.variable_management.Variable;
import com.educator.user_management.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

    @OneToOne
    private User user;

    @OneToMany
    private List<Variable> variables;

}
