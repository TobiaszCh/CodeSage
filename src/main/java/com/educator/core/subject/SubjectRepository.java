package com.educator.core.subject;

import com.educator.core.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findByCourseId(Long courseId);

    @Query("select s.course.id from Subject s where s.id = :subjectId")
    Optional<Long> findCourseIdBySubjectId(@Param("subjectId") Long subjectId);

}
