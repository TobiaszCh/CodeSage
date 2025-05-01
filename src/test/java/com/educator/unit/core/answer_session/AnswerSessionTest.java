package com.educator.unit.core.answer_session;

import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.SubjectCompletedAge;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerSessionTest {

    private static final LocalDate TODAY = LocalDate.of(2025, 4, 26);

    @ParameterizedTest
    @MethodSource("providerCheckAgeAfterAndBeforeSevenDays")
    void checkAgeAfterAndBeforeSevenDays(LocalDate localDate, SubjectCompletedAge expectedResult) {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                localDate, StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletedAge result = answerSession1.getCompletedAge(TODAY);
        //Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> providerCheckAgeAfterAndBeforeSevenDays() {
        return Stream.of(
                Arguments.of(LocalDate.of(2025, 4, 26), SubjectCompletedAge.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 24), SubjectCompletedAge.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 22), SubjectCompletedAge.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 19), SubjectCompletedAge.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 18), SubjectCompletedAge.OLD),
                Arguments.of(LocalDate.of(2024, 3, 17), SubjectCompletedAge.OLD),
                Arguments.of(LocalDate.of(2021, 1, 1), SubjectCompletedAge.OLD),
                Arguments.of(LocalDate.of(2012, 12, 3), SubjectCompletedAge.OLD));
    }

}