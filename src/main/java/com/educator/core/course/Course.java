package com.educator.core.course;

import com.educator.core.course.enums.StatusCourse;
import com.educator.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
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

    @ManyToOne
    private User users;

    @Enumerated(value = EnumType.STRING)
    private StatusCourse statusCourse;

    @PrePersist
    private void prePersist() {
        if (statusCourse == null) statusCourse = StatusCourse.ACTIVE;
    }

}


