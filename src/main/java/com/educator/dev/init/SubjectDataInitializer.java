package com.educator.dev.init;
import com.educator.core.course.CourseRepository;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@DependsOn("courseDataInitializer")
@ConditionalOnProperty(prefix = "dev", name = "data.init", havingValue = "true")
public class SubjectDataInitializer {

    private final SubjectRepository subjectRepository;

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeSubjectData () {
        // Kurs Java
        subjectRepository.save(Subject.builder().id(-9L).displayName("Klasy").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-10L).displayName("Klasy abstrakcyjne").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-11L).displayName("Interfejsy").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-12L).displayName("Enumy").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-13L).displayName("Atrybuty/Pola").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-14L).displayName("Metody").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-15L).displayName("Adnotacje").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-16L).displayName("Kolekcje").course(courseRepository.getById(-1L)).build());
        subjectRepository.save(Subject.builder().id(-17L).displayName("Funkcje").course(courseRepository.getById(-1L)).build());

        // Kurs Python
        subjectRepository.save(Subject.builder().id(-120L).displayName("Podstawy Pythona").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-121L).displayName("Kontrola przepływu").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-122L).displayName("Funkcje i moduły").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-123L).displayName("Obsługa wyjątków").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-124L).displayName("Praca z plikami").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-125L).displayName("Obiektowość").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-126L).displayName("Biblioteki").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-127L).displayName("Analiza danych").course(courseRepository.getById(-3L)).build());
        subjectRepository.save(Subject.builder().id(-128L).displayName("Sieci").course(courseRepository.getById(-3L)).build());

        // Kurs TypeScript
        subjectRepository.save(Subject.builder().id(-129L).displayName("Wprowadzenie do TypeScript").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-130L).displayName("Typy").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-131L).displayName("Funkcje w TypeScript").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-132L).displayName("Klasy i interfejsy").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-133L).displayName("Moduły i przestrzenie nazw").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-134L).displayName("Dekoratory").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-135L).displayName("Programowanie generyczne").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-136L).displayName("Zaawansowane typy i techniki").course(courseRepository.getById(-2L)).build());
        subjectRepository.save(Subject.builder().id(-137L).displayName("Integracja z JavaScript").course(courseRepository.getById(-2L)).build());

        // Kurs JavaScript
        subjectRepository.save(Subject.builder().id(-138L).displayName("Podstawy JavaScript").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-139L).displayName("Funkcje i zakres zmiennych").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-140L).displayName("Obsługa wyjątków i błędów").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-141L).displayName("Praca z DOM i BOM").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-142L).displayName("Asynchroniczność w JavaScript").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-143L).displayName("Zdarzenia i ich obsługa").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-144L).displayName("Programowanie obiektowe w JavaScript").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-145L).displayName("Nowoczesne API i interfejsy Webowe").course(courseRepository.getById(-4L)).build());
        subjectRepository.save(Subject.builder().id(-146L).displayName("Frameworki i biblioteki JavaScript").course(courseRepository.getById(-4L)).build());

        // Kurs React
        subjectRepository.save(Subject.builder().id(-147L).displayName("Wprowadzenie do React i JSX").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-148L).displayName("Komponenty w React: Klasy vs. Funkcje").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-149L).displayName("Stan i cykl życia komponentów").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-150L).displayName("Obsługa zdarzeń i formularzy").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-151L).displayName("Routing w React z React Router").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-152L).displayName("Zarządzanie stanem z Redux i Context API").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-153L).displayName("Haki (Hooks) w React").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-154L).displayName("Testowanie komponentów React").course(courseRepository.getById(-5L)).build());
        subjectRepository.save(Subject.builder().id(-155L).displayName("Optmalizacja wydajności, Lazy Loading").course(courseRepository.getById(-5L)).build());

        // Kurs Kotlin
        subjectRepository.save(Subject.builder().id(-156L).displayName("Podstawy Kotlin").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-157L).displayName("Kontrola przepływu i kolekcje").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-158L).displayName("Funkcje i Lambdy").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-159L).displayName("Klasy, obiekty i dziedziczenie").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-160L).displayName("Bezpieczeństwo typów i nullability").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-161L).displayName("Programowanie funkcyjne w Kotlin").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-162L).displayName("Delegaty i properties").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-163L).displayName("Korutyny i współbieżność").course(courseRepository.getById(-6L)).build());
        subjectRepository.save(Subject.builder().id(-164L).displayName("Zaawansowane funkcje języka Kotlin").course(courseRepository.getById(-6L)).build());

        // Kurs C++
        subjectRepository.save(Subject.builder().id(-165L).displayName("Podstawy C++").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-166L).displayName("Obiekty i klasy w C++").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-167L).displayName("Dziedziczenie i polimorfizm").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-168L).displayName("Szablony i metaprogramowanie").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-169L).displayName("Zarządzanie pamięcią").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-170L).displayName("Wyjątki i obsługa błędów").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-171L).displayName("Standardowa biblioteka szablonów (STL)").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-172L).displayName("Współbieżność i wielowątkowość").course(courseRepository.getById(-7L)).build());
        subjectRepository.save(Subject.builder().id(-173L).displayName("Nowości w C++20").course(courseRepository.getById(-7L)).build());

        // Kurs PHP
        subjectRepository.save(Subject.builder().id(-174L).displayName("Podstawy PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-175L).displayName("Obsługa formularzy w PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-176L).displayName("Praca z bazami danych w PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-177L).displayName("Bezpieczeństwo aplikacji PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-178L).displayName("Zarządzanie sesjami i ciasteczkami").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-179L).displayName("Wyjątki i obsługa błędów w PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-180L).displayName("Wykorzystanie szablonów i PHP").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-181L).displayName("Frameworki dla PHP (Laravel, Symfony)").course(courseRepository.getById(-8L)).build());
        subjectRepository.save(Subject.builder().id(-182L).displayName("Nowości w PHP 8").course(courseRepository.getById(-8L)).build());

        // Kurs Ruby
        subjectRepository.save(Subject.builder().id(-184L).displayName("Podstawy Ruby").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-185L).displayName("Obiekty i metody w Ruby").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-186L).displayName("Klasy i dziedziczenie").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-187L).displayName("Moduły i mieszanki (Mixins)").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-188L).displayName("Zarządzanie wyjątkami").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-189L).displayName("Praca z plikami i serializacja").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-190L).displayName("Metaprogramowanie w Ruby").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-191L).displayName("Testowanie i narzędzia deweloperskie").course(courseRepository.getById(-183L)).build());
        subjectRepository.save(Subject.builder().id(-192L).displayName("Ruby on Rails").course(courseRepository.getById(-183L)).build());
    }
}
