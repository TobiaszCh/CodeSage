package com.educator.answer;
import com.educator.question.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Profile("development")
@DependsOn("questionDataInitializer")
@AllArgsConstructor
public class AnswerDataInitializer {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @PostConstruct
    public void initializeAnswerData () {
        answerRepository.save(new Answer(21L, "Zbiór funkcji", false, questionRepository.getById(18L)));
        answerRepository.save(new Answer(22L, "Szablon lub wzorzec", true, questionRepository.getById(18L)));
        answerRepository.save(new Answer(23L, "Zbiór funkcji", false, questionRepository.getById(18L)));
        answerRepository.save(new Answer(24L, "Zbiór funkcji", false, questionRepository.getById(18L)));

        answerRepository.save(new Answer(25L, "Metody zaimplementowane w klasie", false, questionRepository.getById(19L)));
        answerRepository.save(new Answer(26L, "Zmienne zdefiniowane w klasie", true, questionRepository.getById(19L)));
        answerRepository.save(new Answer(27L, "Interfejsy implementowane przez klasę", false, questionRepository.getById(19L)));
        answerRepository.save(new Answer(28L, "Nazwy klas używane w dziedziczeniu", false, questionRepository.getById(19L)));

        answerRepository.save(new Answer(29L, "Metoda wywołania zwrotnego wywoływana po utworzeniu obiektu", true, questionRepository.getById(20L)));
        answerRepository.save(new Answer(30L, "Specjalna metoda, która zwraca wartość", false, questionRepository.getById(20L)));
        answerRepository.save(new Answer(31L, "Metoda do obsługi wyjątków", false, questionRepository.getById(20L)));
        answerRepository.save(new Answer(32L, "Blok kodu wykonujący się przed utworzeniem obiektu", false, questionRepository.getById(20L)));

        answerRepository.save(new Answer(41L, "new", false, questionRepository.getById(34L)));
        answerRepository.save(new Answer(42L, "class", true, questionRepository.getById(34L)));
        answerRepository.save(new Answer(43L, "define", false, questionRepository.getById(34L)));
        answerRepository.save(new Answer(44L, "create", false, questionRepository.getById(34L)));

        answerRepository.save(new Answer(45L, "none", false, questionRepository.getById(35L)));
        answerRepository.save(new Answer(46L, "null", false, questionRepository.getById(35L)));
        answerRepository.save(new Answer(47L, "void", true, questionRepository.getById(35L)));
        answerRepository.save(new Answer(48L, "empty", false, questionRepository.getById(35L)));

        answerRepository.save(new Answer(49L,"Za pomocą operatora ':'", false, questionRepository.getById(36L)));
        answerRepository.save(new Answer(50L,"Za pomocą operatora '='", false, questionRepository.getById(36L)));
        answerRepository.save(new Answer(51L,"Za pomocą operatora 'implements'", false, questionRepository.getById(36L)));
        answerRepository.save(new Answer(52L,"Za pomocą operatora 'extends'", true, questionRepository.getById(36L)));

        answerRepository.save(new Answer(53L,"Umożliwienie dostępu do wszystkich zmiennych instancyjnych z dowolnego miejsca w programie", false, questionRepository.getById(37L)));
        answerRepository.save(new Answer(54L,"Ukrywanie implementacji szczegółów w klasie.", true, questionRepository.getById(37L)));
        answerRepository.save(new Answer(55L,"Tworzenie wielu instancji klasy w programie.", false, questionRepository.getById(37L)));
        answerRepository.save(new Answer(56L,"Rozszerzanie funkcjonalności klasy bazowej.", false, questionRepository.getById(37L)));

        answerRepository.save(new Answer(57L,"prevent", false, questionRepository.getById(38L)));
        answerRepository.save(new Answer(58L,"noextend", false, questionRepository.getById(38L)));
        answerRepository.save(new Answer(59L,"final", true, questionRepository.getById(38L)));
        answerRepository.save(new Answer(60L,"locked", false, questionRepository.getById(38L)));

        answerRepository.save(new Answer(61L,"Możliwość tworzenia kopii obiektów.", false, questionRepository.getById(39L)));
        answerRepository.save(new Answer(62L,"Możliwość jednoczesnego dziedziczenia po wielu klasach.", false, questionRepository.getById(39L)));
        answerRepository.save(new Answer(63L,"Możliwość przesłaniania metod z klasy bazowej w klasie pochodnej.", false, questionRepository.getById(39L)));
        answerRepository.save(new Answer(64L,"Możliwość wywoływania różnych metod na tym samym obiekcie w zależności od jego typu.", true, questionRepository.getById(39L)));

        answerRepository.save(new Answer(65L,"override", true, questionRepository.getById(40L)));
        answerRepository.save(new Answer(66L,"replace", false, questionRepository.getById(40L)));
        answerRepository.save(new Answer(67L,"implement", false, questionRepository.getById(40L)));
        answerRepository.save(new Answer(68L,"extend", false, questionRepository.getById(40L)));



    }
}
