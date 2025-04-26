package com.educator.unit.core.answer_session;

import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.SubjectCompletedAge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerSessionTest {
    private LocalDate today;

    @BeforeEach
    void init() {
        today = LocalDate.now();
    }

    @ParameterizedTest
    @MethodSource("providerAfterSevenDays")
    void afterSevenDays(long days) {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                today.minusDays(days), StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletedAge result = answerSession1.getCompletedAge(today);
        //Then
        assertEquals(SubjectCompletedAge.OLD, result);
    }

    @ParameterizedTest
    @MethodSource("providerBeforeSevenDays")
    void beforeSevenDays(long days) {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                today.minusDays(days), StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletedAge result = answerSession1.getCompletedAge(today);
        //Then
        assertEquals(SubjectCompletedAge.FRESH, result);
    }

    private static Stream<Long> providerAfterSevenDays() {
        return Stream.of(8L, 9L, 10L,10101L, 6666666L);
    }

    private static Stream<Long> providerBeforeSevenDays() {
        return Stream.of(7L, 6L, 5L,1L, 0L);
    }

}