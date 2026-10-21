package com.educator.core.subject;

import com.educator.core.subject.dto.SubjectDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT NEW com.educator.core.subject.dto.SubjectDto(s.id, " +
            "s.displayName, " +
            "s.course.id, " +
            "COUNT(q)) " +
            "FROM Subject s " +
            "LEFT JOIN Question q ON s.id = q.subject.id " +
            "WHERE s.course.id = :courseId " +
            "GROUP BY s.id " +
            "ORDER BY s.id ASC")
    List<SubjectDto> findByCourseIdOrderByIdAsc(@Param("courseId") Long courseId);

    @Query("SELECT s.course.id FROM Subject s WHERE s.id = :subjectId")
    Optional<Long> findCourseIdBySubjectId(@Param("subjectId") Long subjectId);

}
