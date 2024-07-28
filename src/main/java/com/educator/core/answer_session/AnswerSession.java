package com.educator.core.answer_session;
import com.educator.core.question.Question;
import com.educator.core.subject.Subject;
import com.educator.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private int allAnswers;

    private int correctAnswers;

    @OneToOne
    private User users;

    @ManyToOne
    private Subject subject;

    public AnswerSession(Long id, User users, Subject subject) {
        this.id = id;
        this.users = users;
        this.subject = subject;
    }
}
