package com.educator.core.answer_session;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.Subject;
import com.educator.core.user.User;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_session_sequence")
    @SequenceGenerator(name = "answer_session_sequence", sequenceName = "answer_session_sequence", allocationSize = 1)
    private Long id;

    private int allAnswers;

    private int correctAnswers;

    private LocalDate sessionStartDate;

    @Enumerated(value = EnumType.STRING)
    private StatusAnswerSession statusAnswerSession;

    @OneToOne
    private User users;

    @ManyToOne
    private Subject subject;

}
