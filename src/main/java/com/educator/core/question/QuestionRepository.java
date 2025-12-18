package com.educator.core.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findBySubjectId(Long subjectId);

    boolean existsBySubjectIdAndDisplayName(Long subjectId, String displayName);

    int countBySubjectId(Long subjectId);
}

