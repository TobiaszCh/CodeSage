package com.educator.integration.core;

import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.question.Question;
import com.educator.core.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class AnswerSessionServiceTest {

    @Autowired
    private AnswerSessionService answerSessionService;

    @Autowired
    private AnswerSessionRepository answerSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private EntityManager entityManager;
    @Test
    void selectQuestionAnswer() {
        //Given
        Long id = 10000L;
        Question question = Question.builder().id(10001L).displayName("Czym jest klasa w Javie?").build();
        questionRepository.save(question);
        answerRepository.save(new Answer(10002L, "Klasa w Javie to wzorzec projektowy używany do tworzenia obiektów", false, question));
        answerRepository.save(new Answer(10003L, "Klasa w Javie to struktura danych służąca do modelowania rzeczywistości, definiująca stan i zachowania, które mogą posiadać obiekty", true, question));
        answerRepository.save(new Answer(10004L, "Klasa w Javie to specjalny rodzaj funkcji zapewniający wyższą wydajność aplikacji", false, question));
        answerRepository.save(new Answer(10005L, "Klasa w Javie to narzędzie służące do bezpośredniej manipulacji bazami danych", false, question));
        answerSessionRepository.save(new AnswerSession(id, 10, 10, LocalDate.now(),
                StatusAnswerSession.COMPLETED, null, null));

        entityManager.flush();
        entityManager.clear();

        QuestionAnswerSelectDto questionAnswerSelectDto1 = new QuestionAnswerSelectDto(10001L, 10002L);
        QuestionAnswerSelectDto questionAnswerSelectDto2 = new QuestionAnswerSelectDto(10001L, 10003L);
        QuestionAnswerSelectDto questionAnswerSelectDt3 = new QuestionAnswerSelectDto(10001L, 10004L);
        QuestionAnswerSelectDto questionAnswerSelectDt4 = new QuestionAnswerSelectDto(10001L, 10004L);

        //When
        Long idResult1 = answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDto1);
        Long idResult2 = answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDto2);
        Long idResult3 = answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDt3);
        Long idResult4 = answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDt4);
        //Then
        assertEquals(10003L, idResult1);
        assertEquals(10003L, idResult2);
        assertEquals(10003L, idResult3);
        assertEquals(10003L, idResult4);

    }
}
