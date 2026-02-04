package com.educator.core.course;

import com.educator.core.course.enums.StatusCourse;
import com.educator.core.user.User;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "status_course <> 'DELETED'")
@SQLDelete(sql = "UPDATE course SET status_course = 'DELETED' WHERE id = ?")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq_generator")
    @SequenceGenerator(name = "course_seq_generator", sequenceName = "course_seq", allocationSize = 1)
    private Long id;

    private String displayName;

    @ManyToMany
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @Enumerated(value = EnumType.STRING)
    private StatusCourse statusCourse;

    @PrePersist
    private void prePersist() {
        if (statusCourse == null) statusCourse = StatusCourse.ACTIVE;
    }

}


