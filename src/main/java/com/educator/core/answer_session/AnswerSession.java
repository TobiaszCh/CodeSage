package com.educator.core.answer_session;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_session_sequence")
    @SequenceGenerator(name = "answer_session_sequence", sequenceName = "answer_session_sequence", allocationSize = 1)
    private Long id;

    private int allAnswers;

    private int correctAnswers;

    @Enumerated(value = EnumType.STRING)
    private StatusAnswerSession statusAnswerSession;

    @OneToOne
    private User users;

    @ManyToOne
    private Subject subject;

    public AnswerSession(Long id, User users, Subject subject, StatusAnswerSession statusAnswerSession) {
        this.id = id;
        this.users = users;
        this.subject = subject;
        this.statusAnswerSession = statusAnswerSession;
    }
}
