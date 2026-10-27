package com.educator.unit.core.answer_session;

import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.SubjectCompletionStatus;
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
    void checkAgeAfterAndBeforeSevenDays(LocalDate localDate, SubjectCompletionStatus expectedResult) {
        //Given
        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                localDate, StatusAnswerSession.COMPLETED, null, null);
        //When
        SubjectCompletionStatus result = answerSession1.getCompletedAge(TODAY);
        //Then
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> providerCheckAgeAfterAndBeforeSevenDays() {
        return Stream.of(
                Arguments.of(LocalDate.of(2025, 4, 26), SubjectCompletionStatus.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 24), SubjectCompletionStatus.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 22), SubjectCompletionStatus.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 19), SubjectCompletionStatus.FRESH),
                Arguments.of(LocalDate.of(2025, 4, 18), SubjectCompletionStatus.OLD),
                Arguments.of(LocalDate.of(2024, 3, 17), SubjectCompletionStatus.OLD),
                Arguments.of(LocalDate.of(2021, 1, 1), SubjectCompletionStatus.OLD),
                Arguments.of(LocalDate.of(2012, 12, 3), SubjectCompletionStatus.OLD));
    }

}