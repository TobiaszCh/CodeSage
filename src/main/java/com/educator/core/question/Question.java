package com.educator.core.question;
import com.educator.core.answer.Answer;
import com.educator.core.subject.Subject;
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
    private Long id;
    private String displayName;
    @ManyToOne
    private Subject subject;
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(Long id, String displayName, Subject subject) {
        this.id = id;
        this.displayName = displayName;
        this.subject = subject;
    }
}
