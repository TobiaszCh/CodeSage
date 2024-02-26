package com.educator.question;
import com.educator.answer.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question(Long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }
}
