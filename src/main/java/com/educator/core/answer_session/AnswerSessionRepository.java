package com.educator.core.answer_session;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AnswerSessionRepository extends JpaRepository<AnswerSession, Long> {

    List<AnswerSession> findByStatusAnswerSession(StatusAnswerSession statusAnswerSession);

    @Query("select a.subject.id from AnswerSession a where a.id= :id")
    Optional<Long> findSubjectIdByAnswerSessionId(@Param("id") Long id);


}
