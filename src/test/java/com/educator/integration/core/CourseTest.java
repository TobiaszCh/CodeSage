package com.educator.integration.core;

import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.course.CourseService;
import com.educator.core.course.enums.StatusCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class CourseTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CourseService courseService;

    @Test
    void softDelete() {
        //Given
        courseRepository.save(Course.builder().id(-1L).users(null).displayName("Java").build());

        entityManager.flush();
        entityManager.clear();

        //When
        courseService.deleteCourseById(-1L);
        Course course = (Course) entityManager.createNativeQuery("SELECT * FROM course WHERE status_course = 'DELETED'", Course.class).getSingleResult();

        entityManager.clear();
        //Then
        assertTrue(courseRepository.findById(-1L).isEmpty());
        assertEquals(StatusCourse.DELETED, course.getStatusCourse());

    }

}