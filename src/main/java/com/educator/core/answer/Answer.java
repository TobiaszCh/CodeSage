package com.educator.core.answer;
import com.educator.core.question.Question;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_sequence")
    @SequenceGenerator(name = "answer_sequence", sequenceName = "answer_sequence", allocationSize = 1)
    private Long id;

    private String displayName;

    private boolean isCorrect;

    @ManyToOne
    private Question question;

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }
}
