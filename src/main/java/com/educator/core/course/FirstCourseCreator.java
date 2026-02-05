package com.educator.core.course;

import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.Question;
import com.educator.core.question.QuestionRepository;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import com.educator.core.user.User;
import com.educator.core.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FirstCourseCreator {

    private final CourseRepository courseRepository;

    private final SubjectRepository subjectRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    private final UserRepository userRepository;

    @Transactional
    public void createFirstCourse(String username) {
        if (username == null) throw new CodeSageRuntimeException("Object is null");
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CodeSageRuntimeException("This " + username + " doesn't exist."));
        createFirstCourse(user);
    }

    private void createFirstCourse(User user) {
        Course course1 = courseRepository.save(Course.builder().displayName("Java").users(List.of(user)).build());
        createFirstSubject(course1);
    }

    private void createFirstSubject(Course course) {
        Subject subject1 = subjectRepository.save(Subject.builder().displayName("Klasy").course(course).build());
        createFirstQuestionsAndAnswers(subject1);
    }

    private void createFirstQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest klasa w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Jaką funkcję pełnią atrybuty w Klasie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Czym jest konstruktor w Javie?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do definiowania nowej klasy w języku Java?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe oznacza, że metoda nie zwraca żadnej wartości?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Jak oznacza się dziedziczenie między klasami w języku Java?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Które z poniższych jest przykładem enkapsulacji w języku Java?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Które z poniższych słów kluczowych służy do zapobiegania dziedziczeniu klasy w Javie?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Co oznacza koncepcja polimorfizmu w programowaniu obiektowym?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe jest używane do oznaczania metody, która może być zaimplementowana w klasach potomnych?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("Klasa w Javie to wzorzec projektowy używany do tworzenia obiektów").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Klasa w Javie to struktura danych służąca do modelowania rzeczywistości, definiująca stan i zachowania, które mogą posiadać obiekty").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Klasa w Javie to specjalny rodzaj funkcji zapewniający wyższą wydajność aplikacji").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Klasa w Javie to narzędzie służące do bezpośredniej manipulacji bazami danych").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("Metody zaimplementowane w klasie").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Zmienne zdefiniowane w klasie").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Interfejsy implementowane przez klasę").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Nazwy klas używane w dziedziczeniu").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Metoda wywołania zwrotnego wywoływana po utworzeniu obiektu").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Specjalna metoda, która zwraca wartość").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Metoda do obsługi wyjątków").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Blok kodu wykonujący się przed utworzeniem obiektu").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("new").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("class").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("define").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("create").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("none").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("null").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("void").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("empty").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Za pomocą operatora ':'").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą operatora '='").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą operatora 'implements'").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą operatora 'extends'").isCorrect(true).question(question6).build());

        answerRepository.save(Answer.builder().displayName("Umożliwienie dostępu do wszystkich zmiennych instancyjnych z dowolnego miejsca w programie").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Ukrywanie implementacji szczegółów w klasie.").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Tworzenie wielu instancji klasy w programie.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Rozszerzanie funkcjonalności klasy bazowej.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("prevent").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("noextend").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("final").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("locked").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Możliwość tworzenia kopii obiektów.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Możliwość jednoczesnego dziedziczenia po wielu klasach.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Możliwość przesłaniania metod z klasy bazowej w klasie pochodnej.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Możliwość wywoływania różnych metod na tym samym obiekcie w zależności od jego typu.").isCorrect(true).question(question9).build());

        answerRepository.save(Answer.builder().displayName("override").isCorrect(true).question(question10).build());
        answerRepository.save(Answer.builder().displayName("replace").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("implement").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("extend").isCorrect(false).question(question10).build());
    }

}
