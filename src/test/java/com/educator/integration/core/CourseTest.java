package com.educator.integration.core;

import com.educator.auth.OAuth2LoginSuccessHandler;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.course.CourseService;
import com.educator.core.common.Status;
import com.educator.email.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
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

    @MockBean
    private EmailService emailService;

    @MockBean
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @Test
    void softDelete() {
        //Given
        Course course = courseRepository.save(Course.builder().displayName("Java").build());

        entityManager.flush();
        entityManager.clear();

        //When
        courseService.deleteCourseById(course.getId());
        Course courseResult = (Course) entityManager.createNativeQuery("SELECT * FROM course WHERE status = 'DELETED'", Course.class).getSingleResult();

        entityManager.clear();

        //Then
        assertTrue(courseRepository.findById(course.getId()).isEmpty());
        assertEquals(Status.DELETED, courseResult.getStatus());

    }

}