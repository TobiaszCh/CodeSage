package com.educator.core.subject;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.course.Course;
import com.educator.core.question.Question;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq_generator")
    @SequenceGenerator(name = "subject_seq_generator", sequenceName = "subject_seq", allocationSize = 1)
    private Long id;

    private String displayName;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Question> questions;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<AnswerSession> answerSession;

}
