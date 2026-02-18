package com.educator.core.subject;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.common.BaseStatusEntity;
import com.educator.core.course.Course;
import com.educator.core.question.Question;
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
@SQLDelete(sql = "UPDATE subject SET status = 'DELETED' WHERE id = ?")
public class Subject extends BaseStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq_generator")
    @SequenceGenerator(name = "subject_seq_generator", sequenceName = "subject_seq", allocationSize = 1)
    private Long id;

    private String displayName;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "subject")
    private List<Question> questions;

    @OneToMany(mappedBy = "subject")
    private List<AnswerSession> answerSession;

}
