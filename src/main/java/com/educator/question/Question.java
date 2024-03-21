package com.educator.question;
import com.educator.answer.Answer;
import com.educator.level.Level;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String displayName;

    @ManyToOne
    private Level level;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(Long id, String displayName, Level level) {
        this.id = id;
        this.displayName = displayName;
        this.level = level;
    }
}
