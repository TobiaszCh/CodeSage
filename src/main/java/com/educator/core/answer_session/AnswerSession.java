package com.educator.core.answer_session;
import com.educator.core.subject.Subject;
import com.educator.core.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSession {

    @Id
    @GeneratedValue(generator = "course_sequence")
    private Long id;

    private Long userPoints;

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
