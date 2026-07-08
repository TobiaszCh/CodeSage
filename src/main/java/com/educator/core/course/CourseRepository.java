package com.educator.core.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM " +
            "Course c " +
            "JOIN FETCH c.owner " +
            "WHERE c.owner.id = :userId " +
            "OR c.visibility = 'PUBLIC'" +
            "ORDER BY c.visibility ASC")
    List<Course> findAvailableCourses(@Param("userId") Long userId);

}
