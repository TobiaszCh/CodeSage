package com.educator.core.question;
import com.educator.core.answer.Answer;
import com.educator.core.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq_generator")
    @SequenceGenerator(name = "question_seq_generator", sequenceName = "question_seq", allocationSize = 1)
    private Long id;

    private String displayName;

    @ManyToOne
    private Subject subject;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

}
