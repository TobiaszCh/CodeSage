package com.educator.core.subject;

import com.educator.core.answer_session.AnswerSession;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class SubjectAgeService {

    private static final int BORDER_SEVEN_DAYS = 7;

    private static long getDifferenceInDaysBetweenTheStartedSessionAndToday(AnswerSession answerSessionCompleted) {
        long differenceInDaysBetweenTheStartedSessionAndToday;
        differenceInDaysBetweenTheStartedSessionAndToday = ChronoUnit.DAYS.between(answerSessionCompleted.getSessionStartDate(), LocalDate.now());
        return differenceInDaysBetweenTheStartedSessionAndToday;
    }

    public SubjectCompletedAge informAboutSubjectAge(AnswerSession answerSessionCompleted) {
        return getDifferenceInDaysBetweenTheStartedSessionAndToday(answerSessionCompleted) <= BORDER_SEVEN_DAYS
                ? SubjectCompletedAge.FRESH : SubjectCompletedAge.OLD;
    }
}
