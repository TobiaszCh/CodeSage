package com.educator.answer;
import com.educator.question.Question;
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
    @GeneratedValue
    private Long id;

    private String displayName;

    @ManyToOne
    private Question question;

}
