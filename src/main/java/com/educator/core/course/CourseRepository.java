package com.educator.core.course;

import com.educator.core.course.dto.CourseSummaryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT new com.educator.core.course.dto.CourseSummaryDto(c.id, c.displayName, c.imageUrl, c.visibility, c.owner, COUNT(s)) " +
            "FROM Course c " +
            "LEFT JOIN Subject s ON s.course.id = c.id " +
            "WHERE c.owner.id = :userId " +
            "OR c.visibility = 'PUBLIC' " +
            "GROUP BY c.id " +
            "ORDER BY c.visibility ASC")
    List<CourseSummaryDto> findOwnedOrPublicCourses(@Param("userId") Long userId);

}
