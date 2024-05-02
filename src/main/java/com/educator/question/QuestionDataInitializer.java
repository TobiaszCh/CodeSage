package com.educator.question;
import com.educator.level.LevelRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@Profile("development")
@DependsOn("levelDataInitializer")
@AllArgsConstructor
public class QuestionDataInitializer {

    private final QuestionRepository questionRepository;
    private final LevelRepository levelRepository;
    @PostConstruct
    public void initializeQuestionData () {
        questionRepository.save(new Question(18L, "Czym jest klasa w Javie?", levelRepository.getById(33L)));
        questionRepository.save(new Question(19L, "Jaką funkcję pełnią atrybuty w Klasie?", levelRepository.getById(33L)));
        questionRepository.save(new Question(20L, "Czym jest konstruktor w Javie?", levelRepository.getById(33L)));
        questionRepository.save(new Question(34L, "Które słowo kluczowe służy do definiowania nowej klasy w języku Java?", levelRepository.getById(33L)));
        questionRepository.save(new Question(35L, "Które słowo kluczowe oznacza, że metoda nie zwraca żadnej wartości?", levelRepository.getById(33L)));
        questionRepository.save(new Question(36L, "Jak oznacza się dziedziczenie między klasami w języku Java?", levelRepository.getById(33L)));
        questionRepository.save(new Question(37L, "Które z poniższych jest przykładem enkapsulacji w języku Java?", levelRepository.getById(33L)));
        questionRepository.save(new Question(38L, "Które z poniższych słów kluczowych służy do zapobiegania dziedziczeniu klasy w Javie?", levelRepository.getById(33L)));
        questionRepository.save(new Question(39L, "Co oznacza koncepcja polimorfizmu w programowaniu obiektowym?", levelRepository.getById(33L)));
        questionRepository.save(new Question(40L, "Które słowo kluczowe jest używane do oznaczania metody, która może być zaimplementowana w klasach potomnych?", levelRepository.getById(33L)));
    }
}
