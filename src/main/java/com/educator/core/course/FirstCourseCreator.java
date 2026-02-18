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
        createThreeSubjects(course1);
    }

    private void createThreeSubjects(Course course) {
        Subject subject1 = subjectRepository.save(Subject.builder().displayName("Klasy").course(course).build());
        Subject subject2 = subjectRepository.save(Subject.builder().displayName("Metody").course(course).build());
        Subject subject3 = subjectRepository.save(Subject.builder().displayName("Kolekcje").course(course).build());
        Subject subject4 = subjectRepository.save(Subject.builder().displayName("Interfejsy").course(course).build());
        Subject subject5 = subjectRepository.save(Subject.builder().displayName("Enumy").course(course).build());
        Subject subject6 = subjectRepository.save(Subject.builder().displayName("Klasy abstrakcyjne").course(course).build());
        Subject subject7 = subjectRepository.save(Subject.builder().displayName("Obiektowość").course(course).build());
        Subject subject8 = subjectRepository.save(Subject.builder().displayName("Dziedziczenie").course(course).build());
        Subject subject9 = subjectRepository.save(Subject.builder().displayName("Zmienne").course(course).build());
        createFirstQuestionsAndAnswers(subject1);
        createSecondQuestionsAndAnswers(subject2);
        createThirdQuestionsAndAnswers(subject3);
        createFourthQuestionsAndAnswers(subject4);
        createFifthQuestionsAndAnswers(subject5);
        createSixthQuestionsAndAnswers(subject6);
        createSeventhQuestionsAndAnswers(subject7);
        createEighthQuestionsAndAnswers(subject8);
        createNinthQuestionsAndAnswers(subject9);
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

    private void createSecondQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest metoda w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe oznacza, że metoda nie zwraca wartości?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Co oznacza przeciążenie metod (method overloading)?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Co oznacza przesłanianie metod (method overriding)?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Jaką adnotacją w Javie oznacza się przesłoniętą metodę?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Który modyfikator dostępu sprawia, że metoda jest widoczna tylko w tej samej klasie?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Czym jest parametr metody?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Co oznacza, że metoda jest statyczna (static)?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Co oznacza słowo kluczowe 'return' w metodzie?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące przekazywania argumentów w Javie jest prawdziwe?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("To specjalny typ zmiennej w klasie.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To blok kodu, który nie może przyjmować parametrów.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To funkcja zdefiniowana w klasie, która może przyjmować parametry i wykonywać określone zadanie.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To instrukcja warunkowa w Javie.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("void").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("none").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("empty").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("null").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Wywołanie metody wiele razy w pętli.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Ukrycie metody, aby nie była widoczna dla innych klas.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Zastąpienie metody z klasy bazowej inną implementacją w klasie potomnej.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Zdefiniowanie metody o tej samej nazwie, ale z inną liczbą lub typami parametrów.").isCorrect(true).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Utworzenie metody, której nie da się wywołać.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Zdefiniowanie metody o tej samej nazwie i parametrach w klasie potomnej, zmieniając jej działanie.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Zamiana metody na pole klasy.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Zdefiniowanie metody o tej samej nazwie, ale z innymi parametrami w tej samej klasie.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("@Replace").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("@Overload").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("@Override").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("@Rewrite").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("protected").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("private").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("public").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("default (brak modyfikatora) zawsze oznacza private").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("To metoda wywoływana automatycznie po uruchomieniu programu.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("To wartość wejściowa metody zadeklarowana w jej nawiasach, np. (int x).").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("To wyjątek zgłaszany przez metodę.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("To zmienna zdefiniowana w metodzie, która przechowuje wynik jej działania.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Jest zawsze prywatna.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie może przyjmować parametrów.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Należy do klasy, można ją wywołać bez tworzenia obiektu.").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Może być wywołana tylko na obiekcie (instancji) klasy.").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Kończy działanie metody i opcjonalnie zwraca wartość.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Służy do zadeklarowania zmiennej lokalnej.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Wymusza wykonanie metody ponownie.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Zatrzymuje działanie całego programu.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Typy prymitywne są przekazywane przez referencję, a obiekty przez wartość.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Java przekazuje argumenty zawsze przez wartość (pass-by-value).").isCorrect(true).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Java przekazuje argumenty zawsze przez referencję (pass-by-reference).").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Słowo kluczowe 'ref' decyduje o sposobie przekazywania argumentów.").isCorrect(false).question(question10).build());
    }

    private void createThirdQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest kolekcja w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Który interfejs jest bazowy dla List, Set i Queue?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Która implementacja List zachowuje kolejność dodawania elementów i pozwala na duplikaty?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Która implementacja Set nie pozwala na duplikaty i nie gwarantuje kolejności?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Która kolekcja przechowuje elementy w postaci par klucz-wartość?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Który typ kolekcji najlepiej nadaje się do szybkiego wyszukiwania po kluczu?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Czym różni się ArrayList od LinkedList?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Która implementacja Map NIE pozwala na null jako klucz?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Do czego służy Iterator w kolekcjach?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące HashSet jest prawdziwe?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("To mechanizm do obsługi wyjątków w Javie.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To struktura danych z biblioteki Java Collections Framework służąca do przechowywania i zarządzania grupą obiektów.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To specjalny typ klasy abstrakcyjnej.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To tablica o stałym rozmiarze, która przechowuje tylko typy prymitywne.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("Map").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Collection").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Stream").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("Iterable").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("PriorityQueue").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("TreeSet").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("HashSet").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("ArrayList").isCorrect(true).question(question3).build());

        answerRepository.save(Answer.builder().displayName("HashSet").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Vector").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("LinkedList").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("ArrayList").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Queue").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("List").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Map").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Set").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Set").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Stack").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Map (np. HashMap)").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("List").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("ArrayList nie pozwala na duplikaty, a LinkedList pozwala.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("ArrayList jest zawsze szybszy od LinkedList w każdej operacji.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("ArrayList ma szybszy dostęp po indeksie, a LinkedList często lepszy przy wstawianiu/usuwaniu w środku.").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("LinkedList nie implementuje List.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("TreeMap").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Hashtable").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("HashMap").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("LinkedHashMap").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Służy tylko do kolekcji Map.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Służy do sortowania kolekcji automatycznie.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Służy do przechodzenia po elementach kolekcji i pozwala bezpiecznie usuwać elementy podczas iteracji.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Służy do dodawania elementów do kolekcji bez ich przechowywania.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("HashSet jest synchroniczny domyślnie.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("HashSet zachowuje kolejność dodawania elementów.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("HashSet pozwala na duplikaty, ale usuwa je po sortowaniu.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("HashSet nie dopuszcza duplikatów i bazuje na hashCode/equals do porównywania elementów.").isCorrect(true).question(question10).build());
    }

    private void createFourthQuestionsAndAnswers (Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest interfejs w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do deklarowania interfejsu w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do implementowania interfejsu przez klasę?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące metod w interfejsie (Java podstawy) jest prawdziwe?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Czy klasa w Javie może implementować więcej niż jeden interfejs?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy interfejs w Javie może posiadać pola (zmienne)?").subject(subject).build());Question question7 = questionRepository.save(Question.builder().displayName("Które stwierdzenie najlepiej opisuje zastosowanie interfejsów?").subject(subject).build());Question question8 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe jest używane do implementacji wielu interfejsów?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Czy interfejs w Javie może posiadać konstruktor?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Który przykład poprawnie pokazuje relację klasy do interfejsu?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("To klasa bazowa, po której inne klasy mogą dziedziczyć.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To zbiór metod, które muszą zostać zaimplementowane przez klasę.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To obiekt tworzony automatycznie przez JVM.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To specjalny rodzaj pakietu w Javie.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("class").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("implements").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("interface").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("extends").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("extends").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("implements").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("interface").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("instanceof").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Metody w interfejsie zawsze muszą mieć implementację.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Metody w interfejsie mogą być tylko prywatne.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Metody w interfejsie (w podstawowej wersji) nie posiadają implementacji.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Metody w interfejsie są zawsze statyczne.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa może implementować dowolną liczbę interfejsów.").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa może implementować tylko jeden interfejs.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko jeśli interfejsy są puste.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli interfejsy są w tym samym pakiecie.").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Nie, interfejs nie może posiadać żadnych pól.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatne.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko jeśli są oznaczone słowem var.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, wszystkie pola w interfejsie są public static final.").isCorrect(true).question(question6).build());

        answerRepository.save(Answer.builder().displayName("Służą głównie do przechowywania danych.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Pozwalają definiować kontrakt, który klasy muszą spełniać.").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Zastępują klasy abstrakcyjne w każdej sytuacji.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Służą wyłącznie do obsługi wyjątków.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("extends").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("implements").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("interface").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("multiple").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Tak, jeśli nie ma parametrów.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko domyślny.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Nie, interfejs nie posiada konstruktora.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatny.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("class Car extends Engine").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("interface Car implements Engine").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("class Car inherits Engine").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("class Car implements Engine").isCorrect(true).question(question10).build());
    }

    private void createFifthQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest enum w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do definiowania enumu w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Który zapis poprawnie definiuje enum z dniami tygodnia?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Czy enum w Javie może posiadać metody?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Jak uzyskać wszystkie wartości enumu?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy enum w Javie może implementować interfejs?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Jak poprawnie odwołać się do konkretnej wartości enumu?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Czy enum w Javie może posiadać konstruktor?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Co zwraca metoda name() wywołana na wartości enumu?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące enumów jest prawdziwe?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("Enum to specjalny typ służący do definiowania stałego zbioru wartości.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Enum to tablica stałych znakowych.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Enum to interfejs z predefiniowanymi metodami.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Enum to klasa, która nie może posiadać metod.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("final").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("enum").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("constant").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("class").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("enum Days { MONDAY; TUESDAY; }").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("enum Days() { MONDAY, TUESDAY }").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("enum Days = { MONDAY, TUESDAY }").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("enum Days { MONDAY, TUESDAY }").isCorrect(true).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Tak, enum może posiadać metody.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Nie, enum nie może mieć metod.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko statyczne.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatne.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Enum.getAll()").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metodą values()").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Enum.list()").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metodą getValues()").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Nie, enum nie może implementować niczego.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko klasy abstrakcyjne.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli enum nie ma wartości.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, enum może implementować interfejs.").isCorrect(true).question(question6).build());

        answerRepository.save(Answer.builder().displayName("new Color.RED").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Color->RED").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Color.RED").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Color(\"RED\")").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Tak, publiczny.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko chroniony.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie, enum nie ma konstruktora.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Tak, enum może posiadać konstruktor (zawsze prywatny).").isCorrect(true).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Nazwę stałej enumu jako String.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Indeks wartości enumu.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Obiekt enumu.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Opis przypisany do enumu.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Enum może dziedziczyć po innej klasie.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Enum może być rozszerzany przez inne klasy.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Enum dziedziczy po java.lang.Enum.").isCorrect(true).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Enum jest zwykłą klasą bez ograniczeń.").isCorrect(false).question(question10).build());
    }

    private void createSixthQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest klasa abstrakcyjna w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do deklarowania klasy abstrakcyjnej w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna w Javie może posiadać metody z implementacją?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Czy można utworzyć instancję klasy abstrakcyjnej?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące metod abstrakcyjnych jest prawdziwe?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna może posiadać konstruktor?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Jak klasa dziedziczy po klasie abstrakcyjnej?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Które stwierdzenie najlepiej opisuje różnicę między interfejsem a klasą abstrakcyjną?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna może posiadać pola (zmienne)?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Kiedy należy użyć klasy abstrakcyjnej zamiast interfejsu?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("To klasa, której nie można bezpośrednio tworzyć obiektów i może zawierać metody abstrakcyjne.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To klasa, która nie może posiadać metod.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To specjalny typ interfejsu.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To klasa przeznaczona wyłącznie do przechowywania danych.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("abstract").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("final").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("extends").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("class").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może mieć implementacji metod.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może mieć metody z implementacją.").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko statyczne.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatne.").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Tak, ale tylko w tej samej klasie.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Nie, nie można tworzyć instancji klasy abstrakcyjnej.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, jeśli klasa nie ma metod abstrakcyjnych.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko przez refleksję.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne muszą posiadać implementację.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne nie posiadają implementacji.").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne są zawsze prywatne.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne mogą być tylko statyczne.").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może posiadać konstruktor.").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może posiadać konstruktora.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatny.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko bezparametrowy.").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego implements.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego inherits.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego extends.").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Nie można dziedziczyć po klasie abstrakcyjnej.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Interfejs nie może mieć metod z implementacją, a klasa abstrakcyjna może.").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Klasa abstrakcyjna nie może posiadać pól, a interfejs może.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Interfejs może mieć konstruktor, a klasa abstrakcyjna nie.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie ma żadnej różnicy między nimi.").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może mieć pól.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko statyczne.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko final.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może posiadać pola.").isCorrect(true).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Gdy chcemy zdefiniować tylko kontrakt bez implementacji.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Zawsze zamiast interfejsu.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Tylko gdy klasa ma jedną metodę.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy chcemy współdzielić kod (implementację) między klasami.").isCorrect(true).question(question10).build());
    }

    private void createSeventhQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Czym jest klasa abstrakcyjna w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do deklarowania klasy abstrakcyjnej w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna w Javie może posiadać metody z implementacją?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Czy można utworzyć instancję klasy abstrakcyjnej?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące metod abstrakcyjnych jest prawdziwe?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna może posiadać konstruktor?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Jak klasa dziedziczy po klasie abstrakcyjnej?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Które stwierdzenie najlepiej opisuje różnicę między interfejsem a klasą abstrakcyjną?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Czy klasa abstrakcyjna może posiadać pola (zmienne)?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Kiedy należy użyć klasy abstrakcyjnej zamiast interfejsu?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("To klasa, której nie można bezpośrednio tworzyć obiektów i może zawierać metody abstrakcyjne.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To klasa, która nie może posiadać metod.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To specjalny typ interfejsu.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("To klasa przeznaczona wyłącznie do przechowywania danych.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("abstract").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("final").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("extends").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("class").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może mieć metody z implementacją.").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może mieć implementacji metod.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko statyczne.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatne.").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Tak, ale tylko w tej samej klasie.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Nie, nie można tworzyć instancji klasy abstrakcyjnej.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, jeśli klasa nie ma metod abstrakcyjnych.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko przez refleksję.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne muszą posiadać implementację.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne nie posiadają implementacji.").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne są zawsze prywatne.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Metody abstrakcyjne mogą być tylko statyczne.").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może posiadać konstruktor.").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może posiadać konstruktora.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko prywatny.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko bezparametrowy.").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego implements.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego inherits.").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Za pomocą słowa kluczowego extends.").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("Nie można dziedziczyć po klasie abstrakcyjnej.").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Interfejs nie może mieć metod z implementacją, a klasa abstrakcyjna może.").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Klasa abstrakcyjna nie może posiadać pól, a interfejs może.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Interfejs może mieć konstruktor, a klasa abstrakcyjna nie.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie ma żadnej różnicy między nimi.").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("Nie, klasa abstrakcyjna nie może mieć pól.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, klasa abstrakcyjna może posiadać pola.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko statyczne.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko final.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Gdy chcemy zdefiniować tylko kontrakt bez implementacji.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy chcemy współdzielić kod (implementację) między klasami.").isCorrect(true).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Zawsze zamiast interfejsu.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Tylko gdy klasa ma jedną metodę.").isCorrect(false).question(question10).build());
    }

    private void createEighthQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Na czym polega dziedziczenie w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do dziedziczenia klas w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Czy klasa w Javie może dziedziczyć po więcej niż jednej klasie?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące dziedziczenia jest prawdziwe?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Czy klasa potomna dziedziczy pola klasy bazowej?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy metoda oznaczona jako final może zostać nadpisana?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Który modyfikator dostępu umożliwia dostęp w klasach potomnych?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Jak wywołać konstruktor klasy bazowej?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Czym jest metoda przesłonięta (overridden)?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Kiedy warto stosować dziedziczenie?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("Polega na przekazywaniu cech i zachowań z klasy bazowej do klasy potomnej.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na kopiowaniu obiektów w pamięci.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na tworzeniu wielu instancji tej samej klasy.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na ukrywaniu danych przed innymi klasami.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("inherits").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("extends").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("implements").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("super").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Tak, Java pozwala na wielokrotne dziedziczenie klas.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko jeśli klasy są abstrakcyjne.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa może dziedziczyć tylko po jednej klasie.").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli używa interfejsów.").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Klasa bazowa dziedziczy po klasie potomnej.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Klasa potomna może używać metod klasy bazowej.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Dziedziczenie działa tylko dla metod statycznych.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Dziedziczenie uniemożliwia używanie polimorfizmu.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa potomna dziedziczy pola klasy bazowej.").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Nie, pola nie są dziedziczone.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tylko pola publiczne są dziedziczone.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tylko pola prywatne są dziedziczone.").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Tak, zawsze można nadpisać metodę final.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko w tej samej klasie.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Nie, metody final nie można nadpisać.").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli metoda jest publiczna.").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("private").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("protected").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("default").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("static").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Przez użycie słowa kluczowego this().").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Przez wywołanie super().").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Automatycznie bez możliwości kontroli.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie można wywołać konstruktora klasy bazowej.").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("To metoda, która została skopiowana z klasy bazowej.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która ma taką samą nazwę i parametry jak w klasie bazowej, ale inną implementację.").isCorrect(true).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która nie może być wywołana.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która zawsze musi być abstrakcyjna.").isCorrect(false).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Zawsze, nawet gdy klasy nie mają wspólnych cech.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Tylko do ponownego użycia kodu.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy chcemy połączyć wiele klas jednocześnie.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy istnieje relacja typu „jest rodzajem” (is-a).").isCorrect(true).question(question10).build());
    }

    private void createNinthQuestionsAndAnswers(Subject subject) {
        Question question1 = questionRepository.save(Question.builder().displayName("Na czym polega dziedziczenie w Javie?").subject(subject).build());
        Question question2 = questionRepository.save(Question.builder().displayName("Które słowo kluczowe służy do dziedziczenia klas w Javie?").subject(subject).build());
        Question question3 = questionRepository.save(Question.builder().displayName("Czy klasa w Javie może dziedziczyć po więcej niż jednej klasie?").subject(subject).build());
        Question question4 = questionRepository.save(Question.builder().displayName("Które stwierdzenie dotyczące dziedziczenia jest prawdziwe?").subject(subject).build());
        Question question5 = questionRepository.save(Question.builder().displayName("Czy klasa potomna dziedziczy pola klasy bazowej?").subject(subject).build());
        Question question6 = questionRepository.save(Question.builder().displayName("Czy metoda oznaczona jako final może zostać nadpisana?").subject(subject).build());
        Question question7 = questionRepository.save(Question.builder().displayName("Który modyfikator dostępu umożliwia dostęp w klasach potomnych?").subject(subject).build());
        Question question8 = questionRepository.save(Question.builder().displayName("Jak wywołać konstruktor klasy bazowej?").subject(subject).build());
        Question question9 = questionRepository.save(Question.builder().displayName("Czym jest metoda przesłonięta (overridden)?").subject(subject).build());
        Question question10 = questionRepository.save(Question.builder().displayName("Kiedy warto stosować dziedziczenie?").subject(subject).build());

        answerRepository.save(Answer.builder().displayName("Polega na przekazywaniu cech i zachowań z klasy bazowej do klasy potomnej.").isCorrect(true).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na kopiowaniu obiektów w pamięci.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na tworzeniu wielu instancji tej samej klasy.").isCorrect(false).question(question1).build());
        answerRepository.save(Answer.builder().displayName("Polega na ukrywaniu danych przed innymi klasami.").isCorrect(false).question(question1).build());

        answerRepository.save(Answer.builder().displayName("inherits").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("extends").isCorrect(true).question(question2).build());
        answerRepository.save(Answer.builder().displayName("implements").isCorrect(false).question(question2).build());
        answerRepository.save(Answer.builder().displayName("super").isCorrect(false).question(question2).build());

        answerRepository.save(Answer.builder().displayName("Tak, Java pozwala na wielokrotne dziedziczenie klas.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko jeśli klasy są abstrakcyjne.").isCorrect(false).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Nie, klasa może dziedziczyć tylko po jednej klasie.").isCorrect(true).question(question3).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli używa interfejsów.").isCorrect(false).question(question3).build());

        answerRepository.save(Answer.builder().displayName("Klasa bazowa dziedziczy po klasie potomnej.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Klasa potomna może używać metod klasy bazowej.").isCorrect(true).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Dziedziczenie działa tylko dla metod statycznych.").isCorrect(false).question(question4).build());
        answerRepository.save(Answer.builder().displayName("Dziedziczenie uniemożliwia używanie polimorfizmu.").isCorrect(false).question(question4).build());

        answerRepository.save(Answer.builder().displayName("Tak, klasa potomna dziedziczy pola klasy bazowej.").isCorrect(true).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Nie, pola nie są dziedziczone.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tylko pola publiczne są dziedziczone.").isCorrect(false).question(question5).build());
        answerRepository.save(Answer.builder().displayName("Tylko pola prywatne są dziedziczone.").isCorrect(false).question(question5).build());

        answerRepository.save(Answer.builder().displayName("Tak, zawsze można nadpisać metodę final.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tak, ale tylko w tej samej klasie.").isCorrect(false).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Nie, metody final nie można nadpisać.").isCorrect(true).question(question6).build());
        answerRepository.save(Answer.builder().displayName("Tylko jeśli metoda jest publiczna.").isCorrect(false).question(question6).build());

        answerRepository.save(Answer.builder().displayName("private").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("protected").isCorrect(true).question(question7).build());
        answerRepository.save(Answer.builder().displayName("default").isCorrect(false).question(question7).build());
        answerRepository.save(Answer.builder().displayName("static").isCorrect(false).question(question7).build());

        answerRepository.save(Answer.builder().displayName("Przez wywołanie super().").isCorrect(true).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Przez użycie słowa kluczowego this().").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Automatycznie bez możliwości kontroli.").isCorrect(false).question(question8).build());
        answerRepository.save(Answer.builder().displayName("Nie można wywołać konstruktora klasy bazowej.").isCorrect(false).question(question8).build());

        answerRepository.save(Answer.builder().displayName("To metoda, która została skopiowana z klasy bazowej.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która nie może być wywołana.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która zawsze musi być abstrakcyjna.").isCorrect(false).question(question9).build());
        answerRepository.save(Answer.builder().displayName("To metoda, która ma taką samą nazwę i parametry jak w klasie bazowej, ale inną implementację.").isCorrect(true).question(question9).build());

        answerRepository.save(Answer.builder().displayName("Zawsze, nawet gdy klasy nie mają wspólnych cech.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy istnieje relacja typu „jest rodzajem” (is-a).").isCorrect(true).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Tylko do ponownego użycia kodu.").isCorrect(false).question(question10).build());
        answerRepository.save(Answer.builder().displayName("Gdy chcemy połączyć wiele klas jednocześnie.").isCorrect(false).question(question10).build());
    }

}
