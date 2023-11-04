package com.educator.course;
import com.educator.subject.Subject;
import com.educator.user.User;
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
    //@OneToOne
    //private User user;
    //@OneToMany
    //private List<Subject> subjects;
}
