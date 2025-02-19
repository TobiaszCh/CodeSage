package com.educator.core.answer;

import com.educator.core.question.Question;
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
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq_generator")
    @SequenceGenerator(name = "answer_seq_generator", sequenceName = "answer_seq", allocationSize = 1)
    private Long id;

    private String displayName;

    private boolean isCorrect;

    @ManyToOne
    private Question question;


}
