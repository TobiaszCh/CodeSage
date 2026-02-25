package com.educator.core.course;

import com.educator.core.common.BaseStatusEntity;
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
@Where(clause = "status <> 'DELETED'")
@SQLDelete(sql = "UPDATE course SET status = 'DELETED' WHERE id = ?")
public class Course extends BaseStatusEntity {

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

}


