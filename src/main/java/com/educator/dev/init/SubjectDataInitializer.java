package com.educator.dev.init;
import com.educator.core.course.CourseRepository;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("development")
@DependsOn("courseDataInitializer")
public class SubjectDataInitializer {

    private final SubjectRepository subjectRepository;

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeSubjectData () {

        //Kurs Java
        subjectRepository.save(new Subject(-9L, "Klasy", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-10L, "Klasy abstrakcyjne", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-11L, "Interfejsy", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-12L, "Enumy", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-13L, "Atrybuty/Pola", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-14L, "Metody", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-15L, "Adnotacje", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-16L, "Kolekcje", courseRepository.getById(-1L)));
        subjectRepository.save(new Subject(-17L, "Funkcje", courseRepository.getById(-1L)));

        //Kurs Python
        subjectRepository.save(new Subject(-120L, "Podstawy Pythona", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-121L, "Kontrola przepływu", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-122L, "Funkcje i moduły", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-123L, "Obsługa wyjątków", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-124L, "Praca z plikami", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-125L, "Obiektowość", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-126L, "Biblioteki", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-127L, "Analiza danych", courseRepository.getById(-3L)));
        subjectRepository.save(new Subject(-128L, "Sieci", courseRepository.getById(-3L)));

        //Kurs TypeScript
        subjectRepository.save(new Subject(-129L, "Wprowadzenie do TypeScript", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-130L, "Typy", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-131L, "Funkcje w TypeScript", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-132L, "Klasy i interfejsy", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-133L, "Moduły i przestrzenie nazw", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-134L, "Dekoratory", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-135L, "Programowanie generyczne", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-136L, "Zaawansowane typy i techniki", courseRepository.getById(-2L)));
        subjectRepository.save(new Subject(-137L, "Integracja z JavaScript", courseRepository.getById(-2L)));

        //Kurs JavaScript
        subjectRepository.save(new Subject(-138L, "Podstawy JavaScript", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-139L, "Funkcje i zakres zmiennych", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-140L, "Obsługa wyjątków i błędów", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-141L, "Praca z DOM i BOM", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-142L, "Asynchroniczność w JavaScript", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-143L, "Zdarzenia i ich obsługa", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-144L, "Programowanie obiektowe w JavaScript", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-145L, "Nowoczesne API i interfejsy Webowe", courseRepository.getById(-4L)));
        subjectRepository.save(new Subject(-146L, "Frameworki i biblioteki JavaScript", courseRepository.getById(-4L)));

        //Kurs React
        subjectRepository.save(new Subject(-147L, "Wprowadzenie do React i JSX", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-148L, "Komponenty w React: Klasy vs. Funkcje", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-149L, "Stan i cykl życia komponentów", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-150L, "Obsługa zdarzeń i formularzy", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-151L, "Routing w React z React Router", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-152L, "Zarządzanie stanem z Redux i Context API", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-153L, "Haki (Hooks) w React", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-154L, "Testowanie komponentów React", courseRepository.getById(-5L)));
        subjectRepository.save(new Subject(-155L, "Optmalizacja wydajności, Lazy Loading", courseRepository.getById(-5L)));

        //Kurs Kotlin
        subjectRepository.save(new Subject(-156L, "Podstawy Kotlin", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-157L, "Kontrola przepływu i kolekcje", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-158L, "Funkcje i Lambdy", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-159L, "Klasy, obiekty i dziedziczenie", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-160L, "Bezpieczeństwo typów i nullability", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-161L, "Programowanie funkcyjne w Kotlin", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-162L, "Delegaty i properties", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-163L, "Korutyny i współbieżność", courseRepository.getById(-6L)));
        subjectRepository.save(new Subject(-164L, "Zaawansowane funkcje języka Kotlin", courseRepository.getById(-6L)));

        // Kurs C++
        subjectRepository.save(new Subject(-165L, "Podstawy C++", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-166L, "Obiekty i klasy w C++", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-167L, "Dziedziczenie i polimorfizm", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-168L, "Szablony i metaprogramowanie", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-169L, "Zarządzanie pamięcią", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-170L, "Wyjątki i obsługa błędów", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-171L, "Standardowa biblioteka szablonów (STL)", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-172L, "Współbieżność i wielowątkowość", courseRepository.getById(-7L)));
        subjectRepository.save(new Subject(-173L, "Nowości w C++20", courseRepository.getById(-7L)));

        // Kurs PHP
        subjectRepository.save(new Subject(-174L, "Podstawy PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-175L, "Obsługa formularzy w PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-176L, "Praca z bazami danych w PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-177L, "Bezpieczeństwo aplikacji PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-178L, "Zarządzanie sesjami i ciasteczkami", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-179L, "Wyjątki i obsługa błędów w PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-180L, "Wykorzystanie szablonów i PHP", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-181L, "Frameworki dla PHP (Laravel, Symfony)", courseRepository.getById(-8L)));
        subjectRepository.save(new Subject(-182L, "Nowości w PHP 8", courseRepository.getById(-8L)));

        // Kurs Ruby
        subjectRepository.save(new Subject(-184L, "Podstawy Ruby", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-185L, "Obiekty i metody w Ruby", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-186L, "Klasy i dziedziczenie", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-187L, "Moduły i mieszanki (Mixins)", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-188L, "Zarządzanie wyjątkami", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-189L, "Praca z plikami i serializacja", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-190L, "Metaprogramowanie w Ruby", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-191L, "Testowanie i narzędzia deweloperskie", courseRepository.getById(-183L)));
        subjectRepository.save(new Subject(-192L, "Ruby on Rails", courseRepository.getById(-183L)));


    }
}
