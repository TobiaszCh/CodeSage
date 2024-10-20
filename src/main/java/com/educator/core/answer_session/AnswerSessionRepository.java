package com.educator.core.answer_session;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerSessionRepository extends JpaRepository<AnswerSession, Long> {

    List<AnswerSession> findByStatusAnswerSession(StatusAnswerSession statusAnswerSession);

}
