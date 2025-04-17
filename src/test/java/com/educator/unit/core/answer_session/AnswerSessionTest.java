package com.educator.unit.core.answer_session;

import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.SubjectCompletedAge;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerSessionTest {

    @Test
    void afterSevenDays() {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                LocalDate.now().minusDays(8), StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletedAge result = answerSession1.getCompletedAge(LocalDate.now());
        //Then
        assertEquals(result, SubjectCompletedAge.OLD);
    }

    @Test
    void beforeSevenDays() {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                LocalDate.now().minusDays(7), StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletedAge result = answerSession1.getCompletedAge(LocalDate.now());
        //Then
        assertEquals(result, SubjectCompletedAge.FRESH);
    }

}