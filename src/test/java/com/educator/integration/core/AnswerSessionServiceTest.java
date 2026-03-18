package com.educator.integration.core;

import com.educator.auth.OAuth2LoginSuccessHandler;
import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.question.Question;
import com.educator.core.question.QuestionRepository;
import com.educator.email.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
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

    @MockBean
    private EmailService emailService;

    @MockBean
    private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;


    @Test
    void selectQuestionAnswer() {
        //Given
        Question question1 = Question.builder().displayName("Czym jest klasa w Javie?").build();
        questionRepository.save(question1);
        Answer answer1 = answerRepository.save(new Answer(10002L, "Klasa w Javie to wzorzec projektowy używany do tworzenia obiektów", false, question1));
        Answer answer2 = answerRepository.save(new Answer(10003L, "Klasa w Javie to struktura danych służąca do modelowania rzeczywistości, definiująca stan i zachowania, które mogą posiadać obiekty", true, question1));
        Answer answer3 = answerRepository.save(new Answer(10004L, "Klasa w Javie to specjalny rodzaj funkcji zapewniający wyższą wydajność aplikacji", false, question1));
        AnswerSession answerSession1 = answerSessionRepository.save(AnswerSession.builder().allAnswers(10).correctAnswers(10)
                .sessionStartDate(LocalDate.now()).statusAnswerSession(StatusAnswerSession.COMPLETED).users(null).subject(null).build());

        entityManager.flush();
        entityManager.clear();

        QuestionAnswerSelectDto questionAnswerSelectDto1 = new QuestionAnswerSelectDto(question1.getId(), answer1.getId());
        QuestionAnswerSelectDto questionAnswerSelectDto2 = new QuestionAnswerSelectDto(question1.getId(), answer2.getId());
        QuestionAnswerSelectDto questionAnswerSelectDt3 = new QuestionAnswerSelectDto(question1.getId(), answer3.getId());
        QuestionAnswerSelectDto questionAnswerSelectDt4 = new QuestionAnswerSelectDto(question1.getId(), answer3.getId());
        //When
        Long idResult1 = answerSessionService.selectQuestionAnswer(answerSession1.getId(), questionAnswerSelectDto1);
        Long idResult2 = answerSessionService.selectQuestionAnswer(answerSession1.getId(), questionAnswerSelectDto2);
        Long idResult3 = answerSessionService.selectQuestionAnswer(answerSession1.getId(), questionAnswerSelectDt3);
        Long idResult4 = answerSessionService.selectQuestionAnswer(answerSession1.getId(), questionAnswerSelectDt4);
        //Then
        assertEquals(answer2.getId(), idResult1);
        assertEquals(answer2.getId(), idResult2);
        assertEquals(answer2.getId(), idResult3);
        assertEquals(answer2.getId(), idResult4);

    }
}
