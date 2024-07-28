package com.educator.dev.init;
import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.question.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("development")
@DependsOn("questionDataInitializer")
public class AnswerDataInitializer {

    private final AnswerRepository answerRepository;

    private final QuestionRepository questionRepository;

    @PostConstruct
    public void initializeAnswerData() {
        answerRepository.save(new Answer(-21L, "Klasa w Javie to wzorzec projektowy używany do tworzenia obiektów", false, questionRepository.getById(-18L)));
        answerRepository.save(new Answer(-22L, "Klasa w Javie to struktura danych służąca do modelowania rzeczywistości, definiująca stan i zachowania, które mogą posiadać obiekty", true, questionRepository.getById(-18L)));
        answerRepository.save(new Answer(-23L, "Klasa w Javie to specjalny rodzaj funkcji zapewniający wyższą wydajność aplikacji", false, questionRepository.getById(-18L)));
        answerRepository.save(new Answer(-24L, "Klasa w Javie to narzędzie służące do bezpośredniej manipulacji bazami danych", false, questionRepository.getById(-18L)));

        answerRepository.save(new Answer(-25L, "Metody zaimplementowane w klasie", false, questionRepository.getById(-19L)));
        answerRepository.save(new Answer(-26L, "Zmienne zdefiniowane w klasie", true, questionRepository.getById(-19L)));
        answerRepository.save(new Answer(-27L, "Interfejsy implementowane przez klasę", false, questionRepository.getById(-19L)));
        answerRepository.save(new Answer(-28L, "Nazwy klas używane w dziedziczeniu", false, questionRepository.getById(-19L)));

        answerRepository.save(new Answer(-29L, "Metoda wywołania zwrotnego wywoływana po utworzeniu obiektu", true, questionRepository.getById(-20L)));
        answerRepository.save(new Answer(-30L, "Specjalna metoda, która zwraca wartość", false, questionRepository.getById(-20L)));
        answerRepository.save(new Answer(-31L, "Metoda do obsługi wyjątków", false, questionRepository.getById(-20L)));
        answerRepository.save(new Answer(-32L, "Blok kodu wykonujący się przed utworzeniem obiektu", false, questionRepository.getById(-20L)));

        answerRepository.save(new Answer(-41L, "new", false, questionRepository.getById(-34L)));
        answerRepository.save(new Answer(-42L, "class", true, questionRepository.getById(-34L)));
        answerRepository.save(new Answer(-43L, "define", false, questionRepository.getById(-34L)));
        answerRepository.save(new Answer(-44L, "create", false, questionRepository.getById(-34L)));

        answerRepository.save(new Answer(-45L, "none", false, questionRepository.getById(-35L)));
        answerRepository.save(new Answer(-46L, "null", false, questionRepository.getById(-35L)));
        answerRepository.save(new Answer(-47L, "void", true, questionRepository.getById(-35L)));
        answerRepository.save(new Answer(-48L, "empty", false, questionRepository.getById(-35L)));

        answerRepository.save(new Answer(-49L, "Za pomocą operatora ':'", false, questionRepository.getById(-36L)));
        answerRepository.save(new Answer(-50L, "Za pomocą operatora '='", false, questionRepository.getById(-36L)));
        answerRepository.save(new Answer(-51L, "Za pomocą operatora 'implements'", false, questionRepository.getById(-36L)));
        answerRepository.save(new Answer(-52L, "Za pomocą operatora 'extends'", true, questionRepository.getById(-36L)));

        answerRepository.save(new Answer(-53L, "Umożliwienie dostępu do wszystkich zmiennych instancyjnych z dowolnego miejsca w programie", false, questionRepository.getById(-37L)));
        answerRepository.save(new Answer(-54L, "Ukrywanie implementacji szczegółów w klasie.", true, questionRepository.getById(-37L)));
        answerRepository.save(new Answer(-55L, "Tworzenie wielu instancji klasy w programie.", false, questionRepository.getById(-37L)));
        answerRepository.save(new Answer(-56L, "Rozszerzanie funkcjonalności klasy bazowej.", false, questionRepository.getById(-37L)));

        answerRepository.save(new Answer(-57L, "prevent", false, questionRepository.getById(-38L)));
        answerRepository.save(new Answer(-58L, "noextend", false, questionRepository.getById(-38L)));
        answerRepository.save(new Answer(-59L, "final", true, questionRepository.getById(-38L)));
        answerRepository.save(new Answer(-60L, "locked", false, questionRepository.getById(-38L)));

        answerRepository.save(new Answer(-61L, "Możliwość tworzenia kopii obiektów.", false, questionRepository.getById(-39L)));
        answerRepository.save(new Answer(-62L, "Możliwość jednoczesnego dziedziczenia po wielu klasach.", false, questionRepository.getById(-39L)));
        answerRepository.save(new Answer(-63L, "Możliwość przesłaniania metod z klasy bazowej w klasie pochodnej.", false, questionRepository.getById(-39L)));
        answerRepository.save(new Answer(-64L, "Możliwość wywoływania różnych metod na tym samym obiekcie w zależności od jego typu.", true, questionRepository.getById(-39L)));

        answerRepository.save(new Answer(-65L, "override", true, questionRepository.getById(-40L)));
        answerRepository.save(new Answer(-66L, "replace", false, questionRepository.getById(-40L)));
        answerRepository.save(new Answer(-67L, "implement", false, questionRepository.getById(-40L)));
        answerRepository.save(new Answer(-68L, "extend", false, questionRepository.getById(-40L)));

        // Odpowiedzi dla pytania 1: "Co charakteryzuje klasę abstrakcyjną w Javie?"
        answerRepository.save(new Answer(-80L, "Może być instancjonowana za pomocą konstruktora domyślnego", false, questionRepository.getById(-70L)));
        answerRepository.save(new Answer(-81L, "Zawsze zawiera co najmniej jedną metodę abstrakcyjną", false, questionRepository.getById(-70L)));
        answerRepository.save(new Answer(-82L, "Musze implementować wszystkie metody z interfejsów, które implementuje", false, questionRepository.getById(-70L)));
        answerRepository.save(new Answer(-83L, "Nie może być instancjonowana, ale może nie zawierać żadnych metod abstrakcyjnych", true, questionRepository.getById(-70L)));

        // Odpowiedzi dla pytania 2: "Która z poniższych metod jest poprawnym przykładem metody abstrakcyjnej w klasie abstrakcyjnej?"
        answerRepository.save(new Answer(-84L, "public void myMethod();", false, questionRepository.getById(-71L)));
        answerRepository.save(new Answer(-85L, "public abstract void myMethod() {}", false, questionRepository.getById(-71L)));
        answerRepository.save(new Answer(-86L, "private abstract void myMethod();", false, questionRepository.getById(-71L)));
        answerRepository.save(new Answer(-87L, "public abstract void myMethod();", true, questionRepository.getById(-71L)));

        // Odpowiedzi dla pytania 3: "Dlaczego klasy abstrakcyjne są użyteczne w programowaniu obiektowym?"
        answerRepository.save(new Answer(-88L, "Ułatwiają tworzenie aplikacji wielowątkowych", false, questionRepository.getById(-72L)));
        answerRepository.save(new Answer(-89L, "Są niezbędne do stworzenia interfejsów", false, questionRepository.getById(-72L)));
        answerRepository.save(new Answer(-90L, "Umożliwiają tworzenie szczegółowych implementacji wszystkich metod", false, questionRepository.getById(-72L)));
        answerRepository.save(new Answer(-91L, "Pozwalają na stworzenie jednolitego interfejsu dla różnych klas pochodnych", true, questionRepository.getById(-72L)));

        // Odpowiedzi dla pytania 4: "Co się stanie, jeśli klasa dziedziczy po klasie abstrakcyjnej i nie implementuje wszystkich jej metod abstrakcyjnych?"
        answerRepository.save(new Answer(-92L, "Kompilator zgłosi błąd", true, questionRepository.getById(-73L)));
        answerRepository.save(new Answer(-93L, "Klasa będzie normalnie kompilowana", false, questionRepository.getById(-73L)));
        answerRepository.save(new Answer(-94L, "Kompilator zignoruje niezaimplementowane metody", false, questionRepository.getById(-73L)));
        answerRepository.save(new Answer(-95L, "Klasa automatycznie staje się abstrakcyjna", false, questionRepository.getById(-73L)));

        // Odpowiedzi dla pytania 5: "Czy klasa abstrakcyjna może zawierać pola statyczne?"
        answerRepository.save(new Answer(-96L, "Tak, ale tylko pola prywatne", false, questionRepository.getById(-74L)));
        answerRepository.save(new Answer(-97L, "Nie, klasy abstrakcyjne nie mogą zawierać żadnych pól", false, questionRepository.getById(-74L)));
        answerRepository.save(new Answer(-98L, "Tak, ale tylko stałe.", false, questionRepository.getById(-74L)));
        answerRepository.save(new Answer(-99L, "Tak, może zawierać dowolne pola, w tym statyczne", true, questionRepository.getById(-74L)));

        // Odpowiedzi dla pytania 6: "Czy klasa abstrakcyjna może implementować interfejs?"
        answerRepository.save(new Answer(-100L, "Tylko jeśli interfejs zawiera wyłącznie metody statyczne", false, questionRepository.getById(-75L)));
        answerRepository.save(new Answer(-101L, "Tak, i musi dostarczyć implementację wszystkich metod interfejsu", false, questionRepository.getById(-75L)));
        answerRepository.save(new Answer(-102L, "Nie, klasa abstrakcyjna nie może implementować interfejsów", false, questionRepository.getById(-75L)));
        answerRepository.save(new Answer(-103L, "Tak, ale nie musi dostarczać implementacji metod interfejsu", true, questionRepository.getById(-75L)));

        // Odpowiedzi dla pytania 7: "Jaka jest różnica między klasą abstrakcyjną a interfejsem w Javie?"
        answerRepository.save(new Answer(-104L, "Klasa abstrakcyjna może być używana tylko jako superklasa dla innych klas i musi zawierać co najmniej jedną metodę abstrakcyjną", false, questionRepository.getById(-76L)));
        answerRepository.save(new Answer(-105L, "Nie ma żadnej różnicy; oba są używane wymiennie", false, questionRepository.getById(-76L)));
        answerRepository.save(new Answer(-106L, "Klasa abstrakcyjna może zawierać stan (pola) i metody z implementacją, interfejs może zawierać tylko metody abstrakcyjne", false, questionRepository.getById(-76L)));
        answerRepository.save(new Answer(-107L, "Klasa abstrakcyjna może zawierać stan (pola) i metody z implementacją, interfejs od Javy 8 może zawierać metody abstrakcyjne, metody domyślne i statyczne", true, questionRepository.getById(-76L)));

        // Odpowiedzi dla pytania 8: "Czy klasa abstrakcyjna może zawierać metody prywatne?"
        answerRepository.save(new Answer(-108L, "Tak, wszystkie metody w klasie abstrakcyjnej mogą być prywatne", false, questionRepository.getById(-77L)));
        answerRepository.save(new Answer(-109L, "Nie, ponieważ wszystkie metody w klasie abstrakcyjnej muszą być dostępne dla klas dziedziczących", false, questionRepository.getById(-77L)));
        answerRepository.save(new Answer(-110L, "Nie, klasy abstrakcyjne nie mogą zawierać żadnych metod prywatnych", false, questionRepository.getById(-77L)));
        answerRepository.save(new Answer(-111L, "Tak, ale metody prywatne nie mogą być abstrakcyjne", true, questionRepository.getById(-77L)));

        // Odpowiedzi dla pytania 9: "Jakie jest główne zastosowanie klas abstrakcyjnych?"
        answerRepository.save(new Answer(-112L, "Umożliwienie tworzenia ogromnych programów bez błędów", false, questionRepository.getById(-78L)));
        answerRepository.save(new Answer(-113L, "Zastępowanie interfejsów", false, questionRepository.getById(-78L)));
        answerRepository.save(new Answer(-114L, "Dostarczanie kompletnych implementacji", false, questionRepository.getById(-78L)));
        answerRepository.save(new Answer(-115L, "Dziedziczenie implementacji i określanie struktury w klasach potomnych", true, questionRepository.getById(-78L)));

        // Odpowiedzi dla pytania 10: "Czy klasa abstrakcyjna może mieć konstruktory?"
        answerRepository.save(new Answer(-116L, "Tak, ale tylko konstruktory domyślne", false, questionRepository.getById(-79L)));
        answerRepository.save(new Answer(-117L, "Nie, klasy abstrakcyjne nie mogą mieć konstruktorów", false, questionRepository.getById(-79L)));
        answerRepository.save(new Answer(-118L, "Tylko konstruktory prywatne", false, questionRepository.getById(-79L)));
        answerRepository.save(new Answer(-119L, "Tak, klasy abstrakcyjne mogą mieć dowolne konstruktory", true, questionRepository.getById(-79L)));

        // Odpowiedzi dla pytania: "Jak zainstalować Pythona na swoim komputerze?"
        answerRepository.save(new Answer(-203L, "Korzystając z narzędzia 'Python Manager' dostępnego w systemie", false, questionRepository.getById(-193L)));
        answerRepository.save(new Answer(-204L, "Pobierając instalator z oficjalnej strony Pythona i uruchamiając go", true, questionRepository.getById(-193L)));
        answerRepository.save(new Answer(-205L, "Instalując go z App Store", false, questionRepository.getById(-193L)));
        answerRepository.save(new Answer(-206L, "Używając polecenia 'install-python' w terminalu", false, questionRepository.getById(-193L)));

        // Odpowiedzi dla pytania: "Jak uruchomić skrypt Pythona z linii komend?"
        answerRepository.save(new Answer(-207L, "Klikając dwukrotnie na plik skryptu", false, questionRepository.getById(-194L)));
        answerRepository.save(new Answer(-208L, "Wybierając opcję 'Run Script' w menu Start", false, questionRepository.getById(-194L)));
        answerRepository.save(new Answer(-209L, "Używając polecenia 'python nazwa_skryptu.py'", true, questionRepository.getById(-194L)));
        answerRepository.save(new Answer(-210L, "Otwierając go w dowolnym edytorze tekstu i klikając 'Run'", false, questionRepository.getById(-194L)));

        // Odpowiedzi dla pytania: "Co to jest zmienna w Pythonie i jak ją zdefiniować?"
        answerRepository.save(new Answer(-212L, "Zmienna to kontener na dane, definiujemy ją przypisując wartość do nazwy np. x = 5", true, questionRepository.getById(-195L)));
        answerRepository.save(new Answer(-211L, "Zmienna to specjalny rodzaj modułu, który importujemy do skryptu", false, questionRepository.getById(-195L)));
        answerRepository.save(new Answer(-213L, "Zmienna to typ danych, który możemy tworzyć za pomocą 'create'", false, questionRepository.getById(-195L)));
        answerRepository.save(new Answer(-214L, "Zmienna to typ funkcji, definiujemy ją używając słowa kluczowego 'def'", false, questionRepository.getById(-195L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe typy danych w Pythonie?"
        answerRepository.save(new Answer(-215L, "Podstawowe typy danych to integer, decimal, string, boolean", false, questionRepository.getById(-196L)));
        answerRepository.save(new Answer(-217L, "Podstawowe typy danych to number, text, true/false", false, questionRepository.getById(-196L)));
        answerRepository.save(new Answer(-218L, "Podstawowe typy danych to num, text, bool", false, questionRepository.getById(-196L)));
        answerRepository.save(new Answer(-216L, "Podstawowe typy danych to int, float, str, bool", true, questionRepository.getById(-196L)));

        // Odpowiedzi dla pytania: "Jak stworzyć listę w Pythonie i jak dodawać do niej elementy?"
        answerRepository.save(new Answer(-219L, "Listę tworzymy używając cudzysłowów '', a elementy dodajemy metodą insert()", false, questionRepository.getById(-197L)));
        answerRepository.save(new Answer(-221L, "Listę tworzymy używając klamr {}, a elementy dodajemy metodą add()", false, questionRepository.getById(-197L)));
        answerRepository.save(new Answer(-222L, "Listę tworzymy używając nawiasów okrągłych (), a elementy dodajemy operatorem +", false, questionRepository.getById(-197L)));
        answerRepository.save(new Answer(-220L, "Listę tworzymy używając nawiasów kwadratowych [], a elementy dodajemy metodą append()", true, questionRepository.getById(-197L)));

        // Odpowiedzi dla pytania: "Jak działa instrukcja warunkowa if w Pythonie?"
        answerRepository.save(new Answer(-223L, "Instrukcja if służy do definiowania funkcji warunkowych", false, questionRepository.getById(-198L)));
        answerRepository.save(new Answer(-224L, "Instrukcja if sprawdza warunek i wykonuje blok kodu, jeśli warunek jest prawdziwy", true, questionRepository.getById(-198L)));
        answerRepository.save(new Answer(-225L, "Instrukcja if inicjalizuje pętlę, która wykonuje kod wielokrotnie", false, questionRepository.getById(-198L)));
        answerRepository.save(new Answer(-226L, "Instrukcja if wykonuje blok kodu zawsze, niezależnie od warunku", false, questionRepository.getById(-198L)));

        // Odpowiedzi dla pytania: "Co to są pętle w Pythonie i jakie są ich rodzaje?"
        answerRepository.save(new Answer(-227L, "Pętle to instrukcje warunkowe, które wykonują kod w zależności od spełnienia warunku, podstawowe rodzaje to if i else", false, questionRepository.getById(-199L)));
        answerRepository.save(new Answer(-228L, "Pętle to zmienne, które przechowują listy elementów, podstawowe rodzaje to list i tuple", false, questionRepository.getById(-199L)));
        answerRepository.save(new Answer(-229L, "Pętle to struktury, które pozwalają na wielokrotne wykonanie bloku kodu, podstawowe rodzaje to for i while", true, questionRepository.getById(-199L)));
        answerRepository.save(new Answer(-230L, "Pętle to specjalne funkcje, które wywołujemy w Pythonie, podstawowe rodzaje to loop i repeat", false, questionRepository.getById(-199L)));

        // Odpowiedzi dla pytania: "Jak zdefiniować funkcję w Pythonie?"
        answerRepository.save(new Answer(-232L, "Funkcję definiujemy używając słowa kluczowego def, a następnie nazwy funkcji i nawiasów np. def moja_funkcja():", true, questionRepository.getById(-200L)));
        answerRepository.save(new Answer(-231L, "Funkcję definiujemy używając słowa kluczowego function, a następnie nawiasów i nawiasów klamrowych", false, questionRepository.getById(-200L)));
        answerRepository.save(new Answer(-233L, "Funkcję definiujemy używając słowa kluczowego create, a następnie nazwy funkcji i średnika", false, questionRepository.getById(-200L)));
        answerRepository.save(new Answer(-234L, "Funkcję definiujemy używając słowa kluczowego define, a następnie dwukropka", false, questionRepository.getById(-200L)));

        // Odpowiedzi dla pytania: "Co to są moduły w Pythonie i jak je importować?"
        answerRepository.save(new Answer(-235L, "Moduły to struktury danych, importujemy je używając słowa kluczowego attach", false, questionRepository.getById(-201L)));
        answerRepository.save(new Answer(-236L, "Moduły to zewnętrzne pliki Pythona zawierające funkcje i klasy, importujemy je używając słowa kluczowego import", true, questionRepository.getById(-201L)));
        answerRepository.save(new Answer(-237L, "Moduły to instrukcje warunkowe, importujemy je używając słowa kluczowego require", false, questionRepository.getById(-201L)));
        answerRepository.save(new Answer(-238L, "Moduły to specjalne zmienne przechowujące listy, importujemy je używając słowa kluczowego include", false, questionRepository.getById(-201L)));

        // Odpowiedzi dla pytania: "Jakie są metody manipulacji ciągami znaków w Pythonie?"
        answerRepository.save(new Answer(-239L, "Wykorzystujemy metody .add(), .delete() i .cut() do manipulacji ciągami", false, questionRepository.getById(-202L)));
        answerRepository.save(new Answer(-240L, "Manipulacja ciągami znaków odbywa się głównie za pomocą operatorów matematycznych jak + i -", false, questionRepository.getById(-202L)));
        answerRepository.save(new Answer(-241L, "Metody takie jak .upper(), .lower(), .replace() służą do manipulacji ciągami znaków", true, questionRepository.getById(-202L)));
        answerRepository.save(new Answer(-242L, "Do manipulacji ciągami znaków używamy wyłącznie funkcji zewnętrznych bibliotek", false, questionRepository.getById(-202L)));

        // Odpowiedzi dla pytania: "Co to jest klasa w Pythonie?"
        answerRepository.save(new Answer(-253L, "Klasa to szablon do tworzenia obiektów, który definiuje ich atrybuty i metody", true, questionRepository.getById(-243L)));
        answerRepository.save(new Answer(-254L, "Klasa to specjalny rodzaj modułu w Pythonie", false, questionRepository.getById(-243L)));
        answerRepository.save(new Answer(-255L, "Klasa to kolekcja funkcji związanych z konkretnym typem danych", false, questionRepository.getById(-243L)));
        answerRepository.save(new Answer(-256L, "Klasa to struktura danych służąca do przechowywania stanu aplikacji", false, questionRepository.getById(-243L)));

        // Odpowiedzi dla pytania: "Jak tworzyć instancje klasy w Pythonie?"
        answerRepository.save(new Answer(-257L, "Instancję klasy tworzy się używając operatora new", false, questionRepository.getById(-244L)));
        answerRepository.save(new Answer(-258L, "Instancję klasy tworzy się, wywołując klasę jak funkcję, np. instancja = Klasa()", true, questionRepository.getById(-244L)));
        answerRepository.save(new Answer(-259L, "Instancję klasy tworzy się, deklarując zmienne wewnątrz klasy", false, questionRepository.getById(-244L)));
        answerRepository.save(new Answer(-260L, "Instancje klas tworzy się, importując klasy z modułów zewnętrznych", false, questionRepository.getById(-244L)));

        // Odpowiedzi dla pytania: "Co to jest dziedziczenie w kontekście klas w Pythonie?"
        answerRepository.save(new Answer(-261L, "Dziedziczenie to mechanizm tworzenia nowej klasy z już istniejącej klasy", true, questionRepository.getById(-245L)));
        answerRepository.save(new Answer(-262L, "Dziedziczenie to metoda kopiowania funkcji z jednego modułu do drugiego", false, questionRepository.getById(-245L)));
        answerRepository.save(new Answer(-263L, "Dziedziczenie to metoda importowania wszystkich metod z jednego pliku do drugiego", false, questionRepository.getById(-245L)));
        answerRepository.save(new Answer(-264L, "Dziedziczenie to proces, w którym funkcje mogą korzystać z zmiennych globalnych", false, questionRepository.getById(-245L)));

        // Odpowiedzi dla pytania: "Jak definiuje się metodę w klasie Pythona?"
        answerRepository.save(new Answer(-265L, "Metodę definiuje się, tworząc funkcję poza klasą", false, questionRepository.getById(-246L)));
        answerRepository.save(new Answer(-266L, "Metodę definiuje się, używając słowa kluczowego 'func' wewnątrz klasy", false, questionRepository.getById(-246L)));
        answerRepository.save(new Answer(-267L, "Metodę definiuje się, używając słowa kluczowego 'def' wewnątrz klasy", true, questionRepository.getById(-246L)));
        answerRepository.save(new Answer(-268L, "Metodę definiuje się, deklarując ją jako statyczną poza klasą", false, questionRepository.getById(-246L)));

        // Odpowiedzi dla pytania: "Co to jest konstruktor klasy w Pythonie i jak go zdefiniować?"
        answerRepository.save(new Answer(-269L, "Konstruktor to metoda inicjalizująca obiekt klasy, definiuje się go używając __init__(self):", true, questionRepository.getById(-247L)));
        answerRepository.save(new Answer(-270L, "Konstruktor to funkcja, która tworzy zmienne globalne dla klasy", false, questionRepository.getById(-247L)));
        answerRepository.save(new Answer(-271L, "Konstruktor to funkcja definiowana poza klasą, która inicjalizuje obiekty", false, questionRepository.getById(-247L)));
        answerRepository.save(new Answer(-272L, "Konstruktor to dowolna metoda wewnątrz klasy służąca do tworzenia jej instancji", false, questionRepository.getById(-247L)));

        // Odpowiedzi dla pytania: "Jak można zmodyfikować atrybuty instancji klasy w Pythonie?"
        answerRepository.save(new Answer(-273L, "Atrybuty instancji nie mogą być modyfikowane po ich utworzeniu", false, questionRepository.getById(-248L)));
        answerRepository.save(new Answer(-274L, "Atrybuty instancji można zmodyfikować, przypisując nowe wartości bezpośrednio do nich", true, questionRepository.getById(-248L)));
        answerRepository.save(new Answer(-275L, "Atrybuty instancji są zmieniane automatycznie przez Pythona", false, questionRepository.getById(-248L)));
        answerRepository.save(new Answer(-276L, "Atrybuty instancji zmienia się, używając specjalnych metod klasy", false, questionRepository.getById(-248L)));

        // Odpowiedzi dla pytania: "Co to jest polimorfizm w Pythonie?"
        answerRepository.save(new Answer(-277L, "Polimorfizm to zdolność do tworzenia wielu formularzy w aplikacjach webowych", false, questionRepository.getById(-249L)));
        answerRepository.save(new Answer(-278L, "Polimorfizm to zdolność różnych obiektów do reagowania na te same operacje w różny sposób", true, questionRepository.getById(-249L)));
        answerRepository.save(new Answer(-279L, "Polimorfizm to funkcja, która pozwala na zmianę typów danych", false, questionRepository.getById(-249L)));
        answerRepository.save(new Answer(-280L, "Polimorfizm to mechanizm importowania funkcji z różnych bibliotek", false, questionRepository.getById(-249L)));

        // Odpowiedzi dla pytania: "Jak użyć hermetyzacji w klasach Pythona?"
        answerRepository.save(new Answer(-281L, "Hermetyzacja nie jest możliwa w Pythonie, ponieważ wszystko jest publiczne", false, questionRepository.getById(-250L)));
        answerRepository.save(new Answer(-282L, "Hermetyzacja polega na deklarowaniu wszystkich zmiennych na początku klasy", false, questionRepository.getById(-250L)));
        answerRepository.save(new Answer(-283L, "Hermetyzacja używa podkreśleń do oznaczania atrybutów jako prywatne, np. __atrybut", true, questionRepository.getById(-250L)));
        answerRepository.save(new Answer(-284L, "Hermetyzacja jest automatycznie zarządzana przez Pythona i nie wymaga dodatkowego kodowania", false, questionRepository.getById(-250L)));

        // Odpowiedzi dla pytania: "Jakie są metody specjalne klasy w Pythonie i do czego służą?"
        answerRepository.save(new Answer(-285L, "Metody specjalne są używane do definiowania zachowań dla operatorów, takich jak __add__ dla +", true, questionRepository.getById(-251L)));
        answerRepository.save(new Answer(-286L, "Metody specjalne to zewnętrzne funkcje, które można dołączyć do klas", false, questionRepository.getById(-251L)));
        answerRepository.save(new Answer(-287L, "Metody specjalne to metody, które są automatycznie generowane przez Pythona", false, questionRepository.getById(-251L)));
        answerRepository.save(new Answer(-288L, "Metody specjalne są używane wyłącznie w modułach i frameworkach", false, questionRepository.getById(-251L)));

        // Odpowiedzi dla pytania: "Jak można zaimplementować dziedziczenie wielokrotne w Pythonie?"
        answerRepository.save(new Answer(-289L, "Dziedziczenie wielokrotne jest osiągane przez dziedziczenie po jednej klasie wielokrotnie", false, questionRepository.getById(-252L)));
        answerRepository.save(new Answer(-290L, "Dziedziczenie wielokrotne jest osiągane przez implementację wielu interfejsów", false, questionRepository.getById(-252L)));
        answerRepository.save(new Answer(-291L, "Dziedziczenie wielokrotne w Pythonie jest realizowane przez dziedziczenie po wielu klasach", true, questionRepository.getById(-252L)));
        answerRepository.save(new Answer(-292L, "Dziedziczenie wielokrotne jest niemożliwe w Pythonie", false, questionRepository.getById(-252L)));

        // Odpowiedzi dla pytania: "Co to jest TypeScript i do czego służy?"
        answerRepository.save(new Answer(-303L, "TypeScript to biblioteka JavaScript służąca do animacji webowych", false, questionRepository.getById(-293L)));
        answerRepository.save(new Answer(-304L, "TypeScript to nowa wersja JavaScript z lepszą wydajnością w przeglądarkach", false, questionRepository.getById(-293L)));
        answerRepository.save(new Answer(-305L, "TypeScript to framework do tworzenia aplikacji mobilnych", false, questionRepository.getById(-293L)));
        answerRepository.save(new Answer(-306L, "TypeScript to język programowania oparty na JavaScript, zapewniający statyczne typowanie", true, questionRepository.getById(-293L)));

        // Odpowiedzi dla pytania: "Jakie są główne różnice między TypeScript a JavaScript?"
        answerRepository.save(new Answer(-307L, "TypeScript dodaje statyczne typowanie i jest transpilowany do JavaScript", true, questionRepository.getById(-294L)));
        answerRepository.save(new Answer(-308L, "TypeScript i JavaScript są identyczne, TypeScript jest tylko nowszą nazwą", false, questionRepository.getById(-294L)));
        answerRepository.save(new Answer(-309L, "TypeScript jest szybszy w wykonaniu niż JavaScript", false, questionRepository.getById(-294L)));
        answerRepository.save(new Answer(-310L, "JavaScript wspiera klasy i interfejsy, a TypeScript nie", false, questionRepository.getById(-294L)));

        // Odpowiedzi dla pytania: "Co to są typy w TypeScript i jak są używane?"
        answerRepository.save(new Answer(-311L, "Typy w TypeScript to metody służące do pisania bardziej skomplikowanego kodu", false, questionRepository.getById(-295L)));
        answerRepository.save(new Answer(-312L, "Typy w TypeScript służą do określania rodzajów błędów przy kompilacji", false, questionRepository.getById(-295L)));
        answerRepository.save(new Answer(-313L, "Typy w TypeScript to system typowania zapewniający bezpieczeństwo typów na etapie kompilacji", true, questionRepository.getById(-295L)));
        answerRepository.save(new Answer(-314L, "Typy w TypeScript to specjalne funkcje przetwarzające dane wejściowe", false, questionRepository.getById(-295L)));

        // Odpowiedzi dla pytania: "Jak zadeklarować zmienną w TypeScript?"
        answerRepository.save(new Answer(-315L, "Zmienną deklaruje się, używając słowa kluczowego 'var' lub 'const'", false, questionRepository.getById(-296L)));
        answerRepository.save(new Answer(-316L, "Zmienną deklaruje się, używając słowa kluczowego 'let' lub 'const' przed nazwą zmiennej", true, questionRepository.getById(-296L)));
        answerRepository.save(new Answer(-317L, "Zmienną deklaruje się, podając typ po nazwie zmiennej, np. x: number", false, questionRepository.getById(-296L)));
        answerRepository.save(new Answer(-318L, "W TypeScript nie ma potrzeby deklarowania zmiennych", false, questionRepository.getById(-296L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania TypeScript w dużych projektach?"
        answerRepository.save(new Answer(-319L, "TypeScript jest łatwiejszy do nauczenia dla nowych programistów, co jest kluczowe w dużych zespołach", false, questionRepository.getById(-297L)));
        answerRepository.save(new Answer(-320L, "TypeScript redukuje czas potrzebny na debugowanie dzięki statycznemu typowaniu", true, questionRepository.getById(-297L)));
        answerRepository.save(new Answer(-321L, "TypeScript automatycznie minimalizuje kod, co poprawia wydajność aplikacji", false, questionRepository.getById(-297L)));
        answerRepository.save(new Answer(-322L, "TypeScript oferuje lepsze narzędzia do bezpośredniej kompilacji na native aplikacje", false, questionRepository.getById(-297L)));

        // Odpowiedzi dla pytania: "Jak TypeScript wspiera programowanie obiektowe?"
        answerRepository.save(new Answer(-323L, "TypeScript wprowadza koncepcję klas i dziedziczenia, co jest podstawą programowania obiektowego", true, questionRepository.getById(-298L)));
        answerRepository.save(new Answer(-324L, "TypeScript wspiera programowanie obiektowe poprzez automatyczne tworzenie obiektów JSON", false, questionRepository.getById(-298L)));
        answerRepository.save(new Answer(-325L, "TypeScript nie wspiera programowania obiektowego, jest to czysto funkcyjny język", false, questionRepository.getById(-298L)));
        answerRepository.save(new Answer(-326L, "TypeScript używa wyłącznie funkcji, nie klas, do tworzenia struktur danych", false, questionRepository.getById(-298L)));

        // Odpowiedzi dla pytania: "Jak można zdefiniować interfejs w TypeScript?"
        answerRepository.save(new Answer(-327L, "Interfejs definiuje się za pomocą słowa kluczowego 'interface', np. interface Osoba {}", true, questionRepository.getById(-299L)));
        answerRepository.save(new Answer(-328L, "Interfejs definiuje się za pomocą słowa kluczowego 'class', np. class Osoba {}", false, questionRepository.getById(-299L)));
        answerRepository.save(new Answer(-329L, "Interfejs definiuje się za pomocą słowa kluczowego 'struct', tworząc struktury danych", false, questionRepository.getById(-299L)));
        answerRepository.save(new Answer(-330L, "W TypeScript nie definiuje się interfejsów, ponieważ jest to dynamiczny język", false, questionRepository.getById(-299L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między interfejsami a klasami w TypeScript?"
        answerRepository.save(new Answer(-331L, "Interfejsy i klasy w TypeScript są tożsame, oba definiują metody i właściwości obiektów", false, questionRepository.getById(-300L)));
        answerRepository.save(new Answer(-332L, "Interfejsy definiują tylko sygnatury dla typów, podczas gdy klasy implementują te typy", true, questionRepository.getById(-300L)));
        answerRepository.save(new Answer(-333L, "Klasy w TypeScript są używane do definiowania danych, a interfejsy do definiowania funkcji", false, questionRepository.getById(-300L)));
        answerRepository.save(new Answer(-334L, "Interfejsy mogą zawierać stan (zmienne), podczas gdy klasy nie mogą", false, questionRepository.getById(-300L)));

        // Odpowiedzi dla pytania: "Jak TypeScript obsługuje typy generyczne?"
        answerRepository.save(new Answer(-335L, "TypeScript używa typów generycznych podobnie jak Java, definiując je za pomocą <>", true, questionRepository.getById(-301L)));
        answerRepository.save(new Answer(-336L, "TypeScript nie obsługuje typów generycznych; wszystkie typy są domyślne", false, questionRepository.getById(-301L)));
        answerRepository.save(new Answer(-337L, "W TypeScript typy generyczne są definiowane dynamicznie podczas wykonania programu", false, questionRepository.getById(-301L)));
        answerRepository.save(new Answer(-338L, "TypeScript obsługuje tylko generyczne kolekcje danych, takie jak tablice i listy", false, questionRepository.getById(-301L)));

        // Odpowiedzi dla pytania: "Jak skonfigurować środowisko dla TypeScript?"
        answerRepository.save(new Answer(-339L, "Środowisko dla TypeScript konfiguruje się instalując Node.js i npm", false, questionRepository.getById(-302L)));
        answerRepository.save(new Answer(-340L, "TypeScript wymaga specjalnego oprogramowania IDE do konfiguracji środowiska", false, questionRepository.getById(-302L)));
        answerRepository.save(new Answer(-341L, "Środowisko dla TypeScript konfiguruje się instalując pakiet npm 'typescript' i używając tsc do kompilacji", true, questionRepository.getById(-302L)));
        answerRepository.save(new Answer(-342L, "Konfiguracja środowiska TypeScript jest automatyczna przy pierwszym uruchomieniu skryptu", false, questionRepository.getById(-302L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe sposoby integracji TypeScript z JavaScript?"
        answerRepository.save(new Answer(-353L, "TypeScript można zintegrować z JavaScript poprzez dodawanie typów do istniejącego kodu JavaScript", true, questionRepository.getById(-343L)));
        answerRepository.save(new Answer(-354L, "Integracja odbywa się poprzez całkowite przepisanie kodu JavaScript na TypeScript", false, questionRepository.getById(-343L)));
        answerRepository.save(new Answer(-355L, "TypeScript integruje się z JavaScript tylko w środowiskach Node.js", false, questionRepository.getById(-343L)));
        answerRepository.save(new Answer(-356L, "Integracja możliwa jest tylko przy użyciu specjalnych frameworków", false, questionRepository.getById(-343L)));

        // Odpowiedzi dla pytania: "Czy można wykorzystać biblioteki JavaScript w projektach TypeScript?"
        answerRepository.save(new Answer(-357L, "Nie, TypeScript nie wspiera bibliotek JavaScript", false, questionRepository.getById(-344L)));
        answerRepository.save(new Answer(-358L, "Tak, można używać bibliotek JavaScript, korzystając z deklaracji typów", true, questionRepository.getById(-344L)));
        answerRepository.save(new Answer(-359L, "Tylko wybrane biblioteki JavaScript są kompatybilne z TypeScript", false, questionRepository.getById(-344L)));
        answerRepository.save(new Answer(-360L, "Biblioteki JavaScript można używać, ale tylko w przeglądarce", false, questionRepository.getById(-344L)));

        // Odpowiedzi dla pytania: "Jakie są różnice w obsłudze błędów pomiędzy JavaScript a TypeScript?"
        answerRepository.save(new Answer(-361L, "TypeScript eliminuje wszystkie błędy występujące w JavaScript", false, questionRepository.getById(-345L)));
        answerRepository.save(new Answer(-362L, "TypeScript dodaje statyczne typowanie, co pomaga w wykrywaniu błędów na etapie kompilacji", true, questionRepository.getById(-345L)));
        answerRepository.save(new Answer(-363L, "W TypeScript nie ma obsługi błędów, wszystkie błędy są ignorowane", false, questionRepository.getById(-345L)));
        answerRepository.save(new Answer(-364L, "JavaScript i TypeScript mają identyczną obsługę błędów", false, questionRepository.getById(-345L)));

        // Odpowiedzi dla pytania: "Jak TypeScript wpływa na wydajność aplikacji JavaScript?"
        answerRepository.save(new Answer(-365L, "TypeScript zawsze poprawia wydajność aplikacji JavaScript", false, questionRepository.getById(-346L)));
        answerRepository.save(new Answer(-366L, "Wpływ TypeScript na wydajność jest neutralny, ponieważ jest to tylko warstwa typowania", true, questionRepository.getById(-346L)));
        answerRepository.save(new Answer(-367L, "TypeScript znacząco spowalnia aplikacje JavaScript ze względu na dodatkowy narzut kompilacji", false, questionRepository.getById(-346L)));
        answerRepository.save(new Answer(-368L, "TypeScript przyspiesza wydajność, bo pozwala na lepsze zarządzanie pamięcią", false, questionRepository.getById(-346L)));

        // Odpowiedzi dla pytania: "Czy TypeScript wymaga transpilacji do JavaScript przed uruchomieniem w przeglądarce?"
        answerRepository.save(new Answer(-369L, "Nie, TypeScript może być bezpośrednio uruchomiony w przeglądarce", false, questionRepository.getById(-347L)));
        answerRepository.save(new Answer(-370L, "Tak, TypeScript musi być transpilowany do JavaScript, aby był zrozumiały dla przeglądarek", true, questionRepository.getById(-347L)));
        answerRepository.save(new Answer(-371L, "TypeScript jest kompatybilny z większością przeglądarek bez transpilacji", false, questionRepository.getById(-347L)));
        answerRepository.save(new Answer(-372L, "Transpilacja jest opcjonalna i zależna od konfiguracji projektu", false, questionRepository.getById(-347L)));

        // Odpowiedzi dla pytania: "Jak korzystać z plików definicji typów w TypeScript dla bibliotek JavaScript?"
        answerRepository.save(new Answer(-373L, "Pliki definicji typów są niepotrzebne, TypeScript automatycznie rozpoznaje typy z JavaScript", false, questionRepository.getById(-348L)));
        answerRepository.save(new Answer(-374L, "Pliki definicji typów (.d.ts) są używane do zapewnienia informacji o typach dla istniejących bibliotek JavaScript", true, questionRepository.getById(-348L)));
        answerRepository.save(new Answer(-375L, "Pliki definicji są używane tylko w projektach czysto TypeScriptowych", false, questionRepository.getById(-348L)));
        answerRepository.save(new Answer(-376L, "Pliki definicji są generowane automatycznie przez TypeScript", false, questionRepository.getById(-348L)));

        // Odpowiedzi dla pytania: "Jakie są najlepsze praktyki przy mieszaniu kodu TypeScript i JavaScript?"
        answerRepository.save(new Answer(-377L, "Należy unikać mieszania kodu TypeScript i JavaScript w jednym projekcie", false, questionRepository.getById(-349L)));
        answerRepository.save(new Answer(-378L, "Kod JavaScript i TypeScript powinien być oddzielony i niezależny", false, questionRepository.getById(-349L)));
        answerRepository.save(new Answer(-379L, "Używać plików definicji typów do zarządzania typami w kodzie JavaScript", true, questionRepository.getById(-349L)));
        answerRepository.save(new Answer(-380L, "Konwertować cały kod JavaScript do TypeScript jako najlepszą praktykę", false, questionRepository.getById(-349L)));

        // Odpowiedzi dla pytania: "Jak narzędzia deweloperskie wspierają integrację TypeScript z JavaScript?"
        answerRepository.save(new Answer(-381L, "Narzędzia deweloperskie, takie jak WebStorm i Visual Studio, oferują pełne wsparcie dla integracji TypeScript z JavaScript", true, questionRepository.getById(-350L)));
        answerRepository.save(new Answer(-382L, "Brak narzędzi wspierających integrację, deweloperzy muszą zarządzać wszystkim ręcznie", false, questionRepository.getById(-350L)));
        answerRepository.save(new Answer(-383L, "Istnieją tylko specjalistyczne narzędzia do TypeScript, które nie wspierają JavaScript", false, questionRepository.getById(-350L)));
        answerRepository.save(new Answer(-384L, "Wszystkie nowoczesne narzędzia deweloperskie ignorują TypeScript", false, questionRepository.getById(-350L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania TypeScript w istniejących projektach JavaScript?"
        answerRepository.save(new Answer(-385L, "TypeScript automatycznie przekształca kod JavaScript w wydajniejszy kod", false, questionRepository.getById(-351L)));
        answerRepository.save(new Answer(-386L, "Dodanie TypeScript do projektu JavaScript poprawia dokumentację i czytelność kodu", true, questionRepository.getById(-351L)));
        answerRepository.save(new Answer(-387L, "TypeScript sprawia, że projekty JavaScript są trudniejsze do zrozumienia i utrzymania", false, questionRepository.getById(-351L)));
        answerRepository.save(new Answer(-388L, "TypeScript eliminuje potrzebę testowania kodu JavaScript", false, questionRepository.getById(-351L)));

        // Odpowiedzi dla pytania: "Jakie są wyzwania związane z integracją TypeScript i JavaScript w dużych projektach?"
        answerRepository.save(new Answer(-389L, "Integracja nie wprowadza żadnych wyzwań i jest całkowicie bezproblemowa", false, questionRepository.getById(-352L)));
        answerRepository.save(new Answer(-390L, "Wyzwaniem jest zarządzanie typami i zależnościami między plikami TypeScript i JavaScript", true, questionRepository.getById(-352L)));
        answerRepository.save(new Answer(-391L, "Największym wyzwaniem jest zmniejszenie wydajności aplikacji po integracji", false, questionRepository.getById(-352L)));
        answerRepository.save(new Answer(-392L, "TypeScript jest niekompatybilny z większością narzędzi używanych w projektach JavaScript", false, questionRepository.getById(-352L)));

        // Odpowiedzi dla pytania: "Co to jest JavaScript i w jakim celu jest używany?"
        answerRepository.save(new Answer(-403L, "JavaScript to system baz danych używany w aplikacjach webowych", false, questionRepository.getById(-393L)));
        answerRepository.save(new Answer(-404L, "JavaScript to język skryptowy używany głównie do tworzenia efektów wizualnych na stronach internetowych", false, questionRepository.getById(-393L)));
        answerRepository.save(new Answer(-405L, "JavaScript to język programowania używany do tworzenia interaktywnych stron internetowych", true, questionRepository.getById(-393L)));
        answerRepository.save(new Answer(-406L, "JavaScript to zaawansowany język programowania używany do tworzenia aplikacji desktopowych", false, questionRepository.getById(-393L)));

        // Odpowiedzi dla pytania: "Jakie są typy danych dostępne w JavaScript?"
        answerRepository.save(new Answer(-407L, "Typy danych w JavaScript to tylko string i number", false, questionRepository.getById(-394L)));
        answerRepository.save(new Answer(-408L, "JavaScript używa wyłącznie dynamicznych typów, więc nie określa się typów danych", false, questionRepository.getById(-394L)));
        answerRepository.save(new Answer(-409L, "JavaScript obsługuje tylko typy obiektowe i funkcje", false, questionRepository.getById(-394L)));
        answerRepository.save(new Answer(-410L, "Typy danych w JavaScript to: string, number, boolean, object, undefined, symbol, i bigint", true, questionRepository.getById(-394L)));

        // Odpowiedzi dla pytania: "Jak stworzyć zmienną w JavaScript?"
        answerRepository.save(new Answer(-411L, "Zmienną tworzy się używając słowa kluczowego 'variable'", false, questionRepository.getById(-395L)));
        answerRepository.save(new Answer(-412L, "Zmienna w JavaScript jest tworzona automatycznie przy pierwszym użyciu", false, questionRepository.getById(-395L)));
        answerRepository.save(new Answer(-413L, "Zmienną tworzy się używając słów kluczowych 'var', 'let', lub 'const'", true, questionRepository.getById(-395L)));
        answerRepository.save(new Answer(-414L, "Zmienną tworzy się poprzez deklarację bez słów kluczowych, np. x = 20", false, questionRepository.getById(-395L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między var, let i const w JavaScript?"
        answerRepository.save(new Answer(-415L, "var i let są stałymi, const pozwala na zmianę wartości zmiennej", false, questionRepository.getById(-396L)));
        answerRepository.save(new Answer(-416L, "var, let i const nie różnią się od siebie; są to tylko synonimy", false, questionRepository.getById(-396L)));
        answerRepository.save(new Answer(-417L, "var ma zakres funkcji, let i const mają zakres blokowy, const jest też niezmienne", true, questionRepository.getById(-396L)));
        answerRepository.save(new Answer(-418L, "let i const to nowsze alternatywy dla var, oferujące lepsze zarządzanie zakresem", false, questionRepository.getById(-396L)));

        // Odpowiedzi dla pytania: "Co to jest funkcja w JavaScript i jak ją zdefiniować?"
        answerRepository.save(new Answer(-419L, "Funkcja w JavaScript definiuje się poprzez słowo kluczowe 'function' i odpowiednią syntaksę", true, questionRepository.getById(-397L)));
        answerRepository.save(new Answer(-420L, "JavaScript nie obsługuje funkcji; wszystkie operacje są wykonywane na poziomie obiektów", false, questionRepository.getById(-397L)));
        answerRepository.save(new Answer(-421L, "Funkcje w JavaScript są automatycznie generowane i nie można ich zdefiniować", false, questionRepository.getById(-397L)));
        answerRepository.save(new Answer(-422L, "Funkcje są tworzone tylko przez konstruktory i klasy w JavaScript", false, questionRepository.getById(-397L)));

        // Odpowiedzi dla pytania: "Jak działają pętle w JavaScript, jakie są ich rodzaje?"
        answerRepository.save(new Answer(-423L, "W JavaScript jedyną dostępną pętlą jest 'while'", false, questionRepository.getById(-398L)));
        answerRepository.save(new Answer(-424L, "JavaScript oferuje różne rodzaje pętli, takie jak for, while, do-while", true, questionRepository.getById(-398L)));
        answerRepository.save(new Answer(-425L, "Pętle w JavaScript działają tylko w połączeniu z funkcjami rekurencyjnymi", false, questionRepository.getById(-398L)));
        answerRepository.save(new Answer(-426L, "Pętla 'for' w JavaScript jest jedyną pętlą, która nie wymaga warunku stopu", false, questionRepository.getById(-398L)));

        // Odpowiedzi dla pytania: "Co to jest obiekt w JavaScript i jak można go stworzyć?"
        answerRepository.save(new Answer(-427L, "Obiekt w JavaScript tworzy się używając konstruktora Object()", false, questionRepository.getById(-399L)));
        answerRepository.save(new Answer(-428L, "Obiekt w JavaScript to każda zmienna zdefiniowana w kodzie", false, questionRepository.getById(-399L)));
        answerRepository.save(new Answer(-429L, "Obiekty w JavaScript tworzy się przez notację literalną, np. let obj = {}", true, questionRepository.getById(-399L)));
        answerRepository.save(new Answer(-430L, "Obiekty w JavaScript nie mogą być tworzone bezpośrednio, tylko przez dziedziczenie", false, questionRepository.getById(-399L)));

        // Odpowiedzi dla pytania: "Jakie są metody manipulacji DOM w JavaScript?"
        answerRepository.save(new Answer(-431L, "JavaScript nie posiada metod manipulacji DOM, ponieważ nie działa w przeglądarce", false, questionRepository.getById(-400L)));
        answerRepository.save(new Answer(-432L, "Manipulacja DOM w JavaScript odbywa się za pomocą jQuery", false, questionRepository.getById(-400L)));
        answerRepository.save(new Answer(-433L, "Metody takie jak getElementById i querySelector służą do manipulacji DOM", true, questionRepository.getById(-400L)));
        answerRepository.save(new Answer(-434L, "DOM w JavaScript manipuluje się tylko przez CSS", false, questionRepository.getById(-400L)));

        // Odpowiedzi dla pytania: "Jak obsługiwać zdarzenia w JavaScript?"
        answerRepository.save(new Answer(-435L, "Zdarzenia w JavaScript obsługuje się wyłącznie przez atrybuty HTML, np. onclick", false, questionRepository.getById(-401L)));
        answerRepository.save(new Answer(-436L, "JavaScript nie obsługuje zdarzeń; jest to funkcjonalność dodana tylko w HTML5", false, questionRepository.getById(-401L)));
        answerRepository.save(new Answer(-437L, "Obsługa zdarzeń w JavaScript odbywa się poprzez addEventListener i removeEventListener", true, questionRepository.getById(-401L)));
        answerRepository.save(new Answer(-438L, "Zdarzenia są obsługiwane automatycznie przez przeglądarkę bez interwencji JavaScript", false, questionRepository.getById(-401L)));

        // Odpowiedzi dla pytania: "Co to jest JSON i jak jest używany w JavaScript?"
        answerRepository.save(new Answer(-439L, "JSON to typ danych w JavaScript, używany wyłącznie do tworzenia zmiennych", false, questionRepository.getById(-402L)));
        answerRepository.save(new Answer(-440L, "JSON to biblioteka JavaScript służąca do obsługi zapytań sieciowych", false, questionRepository.getById(-402L)));
        answerRepository.save(new Answer(-441L, "JSON, JavaScript Object Notation, to format wymiany danych używany do przechowywania i przesyłania danych", true, questionRepository.getById(-402L)));
        answerRepository.save(new Answer(-442L, "JSON jest metodą szyfrowania danych w JavaScript", false, questionRepository.getById(-402L)));

        // Odpowiedzi dla pytania: "Co to jest jQuery i do czego jest używane?"
        answerRepository.save(new Answer(-453L, "jQuery to język programowania służący do tworzenia aplikacji na Androida", false, questionRepository.getById(-443L)));
        answerRepository.save(new Answer(-454L, "jQuery to biblioteka JavaScript ułatwiająca manipulację DOM, obsługę zdarzeń i animacje", true, questionRepository.getById(-443L)));
        answerRepository.save(new Answer(-455L, "jQuery to zaawansowany framework do tworzenia serwerowych aplikacji webowych", false, questionRepository.getById(-443L)));
        answerRepository.save(new Answer(-456L, "jQuery jest pluginem do przeglądarek wspomagającym debugowanie kodu JavaScript", false, questionRepository.getById(-443L)));

        // Odpowiedzi dla pytania: "Jakie są główne cechy frameworka Angular?"
        answerRepository.save(new Answer(-457L, "Angular jest minimalistycznym frameworkiem do tworzenia aplikacji mobilnych", false, questionRepository.getById(-444L)));
        answerRepository.save(new Answer(-458L, "Angular jest biblioteką do manipulacji tekstem na stronach webowych", false, questionRepository.getById(-444L)));
        answerRepository.save(new Answer(-459L, "Angular oferuje model MVC, dwustronną synchronizację danych i rozszerzalne HTML", true, questionRepository.getById(-444L)));
        answerRepository.save(new Answer(-460L, "Angular pozwala na szybką konwersję aplikacji desktopowych na aplikacje webowe", false, questionRepository.getById(-444L)));

        // Odpowiedzi dla pytania: "Na czym polega główna różnica między Angular a React?"
        answerRepository.save(new Answer(-461L, "React jest szybszy i bardziej elastyczny niż Angular", false, questionRepository.getById(-445L)));
        answerRepository.save(new Answer(-462L, "Angular jest pełnym frameworkiem, podczas gdy React jest biblioteką do budowania interfejsów użytkownika", true, questionRepository.getById(-445L)));
        answerRepository.save(new Answer(-463L, "Nie ma żadnych znaczących różnic; oba narzędzia są identyczne", false, questionRepository.getById(-445L)));
        answerRepository.save(new Answer(-464L, "Angular to język programowania, a React to biblioteka JavaScript", false, questionRepository.getById(-445L)));

        // Odpowiedzi dla pytania: "Co to jest Vue.js i jakie ma zastosowania?"
        answerRepository.save(new Answer(-465L, "Vue.js to progresywny framework JavaScript używany do budowania interfejsów użytkownika", true, questionRepository.getById(-446L)));
        answerRepository.save(new Answer(-466L, "Vue.js to framework do tworzenia mobilnych aplikacji hybrydowych", false, questionRepository.getById(-446L)));
        answerRepository.save(new Answer(-467L, "Vue.js jest specjalistycznym narzędziem do testowania kodu JavaScript", false, questionRepository.getById(-446L)));
        answerRepository.save(new Answer(-468L, "Vue.js to biblioteka do szyfrowania danych w aplikacjach webowych", false, questionRepository.getById(-446L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania React w projektach webowych?"
        answerRepository.save(new Answer(-469L, "React automatycznie testuje i optymalizuje kod, eliminując błędy", false, questionRepository.getById(-447L)));
        answerRepository.save(new Answer(-470L, "React oferuje najlepsze narzędzia do tworzenia statycznych stron internetowych", false, questionRepository.getById(-447L)));
        answerRepository.save(new Answer(-471L, "React umożliwia tworzenie skomplikowanych aplikacji z dynamicznym interfejsem użytkownika", true, questionRepository.getById(-447L)));
        answerRepository.save(new Answer(-472L, "Główną zaletą React jest wbudowany kompilator JavaScript", false, questionRepository.getById(-447L)));

        // Odpowiedzi dla pytania: "Co to jest Node.js i jak jest używane?"
        answerRepository.save(new Answer(-473L, "Node.js to zaawansowany edytor tekstu dla programistów JavaScript", false, questionRepository.getById(-448L)));
        answerRepository.save(new Answer(-474L, "Node.js to środowisko uruchomieniowe JavaScript pozwalające na wykonywanie kodu po stronie serwera", true, questionRepository.getById(-448L)));
        answerRepository.save(new Answer(-475L, "Node.js to plugin do przeglądarek internetowych, który umożliwia wykonywanie JavaScriptu po stronie klienta", false, questionRepository.getById(-448L)));
        answerRepository.save(new Answer(-476L, "Node.js jest systemem operacyjnym opartym na JavaScript", false, questionRepository.getById(-448L)));

        // Odpowiedzi dla pytania: "Jakie biblioteki JavaScript służą do tworzenia animacji?"
        answerRepository.save(new Answer(-477L, "JavaScript używa głównie biblioteki Three.js do animacji", false, questionRepository.getById(-449L)));
        answerRepository.save(new Answer(-478L, "Do tworzenia animacji używa się bibliotek takich jak GreenSock (GSAP), mo.js, i anime.js", true, questionRepository.getById(-449L)));
        answerRepository.save(new Answer(-479L, "Biblioteki do animacji nie są dostępne w JavaScript", false, questionRepository.getById(-449L)));
        answerRepository.save(new Answer(-480L, "jQuery jest jedyną biblioteką służącą do tworzenia animacji w JavaScript", false, questionRepository.getById(-449L)));

        // Odpowiedzi dla pytania: "Co charakteryzuje framework Ember.js?"
        answerRepository.save(new Answer(-481L, "Ember.js charakteryzuje się tym, że jest minimalistyczny i oferuje tylko podstawowe funkcje", false, questionRepository.getById(-450L)));
        answerRepository.save(new Answer(-482L, "Ember.js jest znany z konwencji nad konfiguracją, wbudowanego routingu i silnego systemu szablonów", true, questionRepository.getById(-450L)));
        answerRepository.save(new Answer(-483L, "Ember.js jest frameworkiem backendowym do zarządzania bazami danych", false, questionRepository.getById(-450L)));
        answerRepository.save(new Answer(-484L, "Ember.js jest przeznaczony głównie do tworzenia prostych stron statycznych", false, questionRepository.getById(-450L)));

        // Odpowiedzi dla pytania: "W jaki sposób TypeScript współpracuje z frameworkami JavaScript?"
        answerRepository.save(new Answer(-485L, "TypeScript zastępuje frameworki JavaScript, oferując lepszą wydajność i bezpieczeństwo", false, questionRepository.getById(-451L)));
        answerRepository.save(new Answer(-486L, "TypeScript może być używany z frameworkami takimi jak Angular, React i Vue.js, dostarczając silne typowanie i ułatwienia w zarządzaniu kodem", true, questionRepository.getById(-451L)));
        answerRepository.save(new Answer(-487L, "TypeScript jest niekompatybilny z frameworkami JavaScript i nie może być z nimi używany", false, questionRepository.getById(-451L)));
        answerRepository.save(new Answer(-488L, "TypeScript ogranicza możliwości frameworków JavaScript, czyniąc je mniej elastycznymi", false, questionRepository.getById(-451L)));

        // Odpowiedzi dla pytania: "Jakie są różnice w zarządzaniu stanem w React i Vue?"
        answerRepository.save(new Answer(-489L, "Vue używa systemu Vuex do zarządzania stanem, podczas gdy React korzysta z Context API jako głównego rozwiązania", false, questionRepository.getById(-452L)));
        answerRepository.save(new Answer(-490L, "W React używa się głównie Reduxa do zarządzania stanem, podczas gdy Vue oferuje bardziej zintegrowane rozwiązanie z Vuexem", true, questionRepository.getById(-452L)));
        answerRepository.save(new Answer(-491L, "Nie ma różnic w zarządzaniu stanem; React i Vue używają dokładnie tego samego systemu zarządzania stanem", false, questionRepository.getById(-452L)));
        answerRepository.save(new Answer(-492L, "React zarządza stanem na poziomie komponentów, podczas gdy Vue wymaga zewnętrznego pluginu do zarządzania stanem", false, questionRepository.getById(-452L)));

        // Odpowiedzi dla pytania: "Co to jest React i kto jest jego twórcą?"
        answerRepository.save(new Answer(-503L, "React to biblioteka JavaScript do budowania interfejsów użytkownika, stworzona przez Facebook", true, questionRepository.getById(-493L)));
        answerRepository.save(new Answer(-504L, "React to framework PHP stworzony przez Microsoft", false, questionRepository.getById(-493L)));
        answerRepository.save(new Answer(-505L, "React to narzędzie do automatyzacji testów stworzone przez Google", false, questionRepository.getById(-493L)));
        answerRepository.save(new Answer(-506L, "React to system zarządzania bazami danych opracowany przez Oracle", false, questionRepository.getById(-493L)));

        // Odpowiedzi dla pytania: "Co to jest JSX i jak jest używany w React?"
        answerRepository.save(new Answer(-507L, "JSX to język programowania stworzony na potrzeby serwerowych aplikacji", false, questionRepository.getById(-494L)));
        answerRepository.save(new Answer(-508L, "JSX to rozszerzenie składni JavaScript, które pozwala na pisanie HTML wewnątrz skryptów React", true, questionRepository.getById(-494L)));
        answerRepository.save(new Answer(-509L, "JSX to biblioteka do zarządzania stanem w aplikacjach React", false, questionRepository.getById(-494L)));
        answerRepository.save(new Answer(-510L, "JSX to specjalny framework do tworzenia animacji w aplikacjach webowych", false, questionRepository.getById(-494L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania React w porównaniu z tradycyjnymi podejściami do budowy interfejsów użytkownika?"
        answerRepository.save(new Answer(-511L, "React zapewnia lepszą integrację z bazami danych niż tradycyjne podejścia", false, questionRepository.getById(-495L)));
        answerRepository.save(new Answer(-512L, "React automatycznie aktualizuje strony bez interwencji użytkownika", false, questionRepository.getById(-495L)));
        answerRepository.save(new Answer(-513L, "React oferuje prostsze i szybsze reagowanie na zmiany stanu dzięki wirtualnemu DOM", true, questionRepository.getById(-495L)));
        answerRepository.save(new Answer(-514L, "React umożliwia bezpośrednie manipulowanie DOM, co przyspiesza aplikacje", false, questionRepository.getById(-495L)));

        // Odpowiedzi dla pytania: "Co to są komponenty w React i jakie są ich rodzaje?"
        answerRepository.save(new Answer(-515L, "Komponenty w React są wyłącznie funkcjonalne i nie mogą przechowywać stanu", false, questionRepository.getById(-496L)));
        answerRepository.save(new Answer(-516L, "W React istnieje tylko jeden rodzaj komponentu, który zarządza wszystkimi aspektami aplikacji", false, questionRepository.getById(-496L)));
        answerRepository.save(new Answer(-517L, "Komponenty w React dzielą się na stanowe i bezstanowe, odpowiednio klasy i funkcje", true, questionRepository.getById(-496L)));
        answerRepository.save(new Answer(-518L, "React używa tylko komponentów bezstanowych, ponieważ są szybsze i bardziej efektywne", false, questionRepository.getById(-496L)));

        // Odpowiedzi dla pytania: "Jak działa stan (state) w komponentach React?"
        answerRepository.save(new Answer(-519L, "Stan w komponentach React jest niezmienialny i musi być aktualizowany za pomocą zewnętrznych narzędzi", false, questionRepository.getById(-497L)));
        answerRepository.save(new Answer(-520L, "Stan w komponentach React jest wewnętrznym mechanizmem, który pozwala na reagowanie na interakcje użytkownika i aktualizowanie UI", true, questionRepository.getById(-497L)));
        answerRepository.save(new Answer(-521L, "Stan w komponentach React jest globalny dla całej aplikacji i dzielony między wszystkie komponenty", false, questionRepository.getById(-497L)));
        answerRepository.save(new Answer(-522L, "React nie używa stanu; zamiast tego opiera się na propsach do przekazywania danych", false, questionRepository.getById(-497L)));

        // Odpowiedzi dla pytania: "Co to są propsy (props) w React i do czego są używane?"
        answerRepository.save(new Answer(-523L, "Propsy w React służą do przechowywania wewnętrznego stanu komponentu, który można aktualizować", false, questionRepository.getById(-498L)));
        answerRepository.save(new Answer(-524L, "Propsy w React są używane do przekazywania danych i zdarzeń między komponentami, działają jak parametry funkcji", true, questionRepository.getById(-498L)));
        answerRepository.save(new Answer(-525L, "Propsy to lokalne zmienne używane do wykonania obliczeń wewnątrz komponentów", false, questionRepository.getById(-498L)));
        answerRepository.save(new Answer(-526L, "Propsy są to stylowe właściwości CSS przekazywane do komponentów Reacta", false, questionRepository.getById(-498L)));

        // Odpowiedzi dla pytania: "Jak można zarządzać stanem aplikacji w React bez użycia zewnętrznych bibliotek?"
        answerRepository.save(new Answer(-527L, "Używając kontekstu API i hooków takich jak useState i useReducer", true, questionRepository.getById(-499L)));
        answerRepository.save(new Answer(-528L, "Zarządzanie stanem w React bez zewnętrznych bibliotek nie jest możliwe", false, questionRepository.getById(-499L)));
        answerRepository.save(new Answer(-529L, "Poprzez bezpośrednią manipulację DOM w każdym komponencie", false, questionRepository.getById(-499L)));
        answerRepository.save(new Answer(-530L, "Stosując wzorzec Singleton do przechowywania stanu aplikacji", false, questionRepository.getById(-499L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między klasowymi a funkcyjnymi komponentami w React?"
        answerRepository.save(new Answer(-531L, "Klasowe komponenty są niemutowalne i nie mogą mieć stanu, podczas gdy funkcjonalne mogą", false, questionRepository.getById(-500L)));
        answerRepository.save(new Answer(-532L, "Klasowe komponenty mogą używać metod cyklu życia i stanu, podczas gdy funkcjonalne komponenty używają hooków do zarządzania stanem", true, questionRepository.getById(-500L)));
        answerRepository.save(new Answer(-533L, "Nie ma żadnych różnic, oba typy komponentów działają identycznie", false, questionRepository.getById(-500L)));
        answerRepository.save(new Answer(-534L, "Funkcjonalne komponenty są przeznaczone wyłącznie do aplikacji serwerowych", false, questionRepository.getById(-500L)));

        // Odpowiedzi dla pytania: "Jakie są najpopularniejsze narzędzia i biblioteki używane z React?"
        answerRepository.save(new Answer(-535L, "Najpopularniejsze narzędzia to Angular CLI i Vue.js DevTools", false, questionRepository.getById(-501L)));
        answerRepository.save(new Answer(-536L, "Do popularnych narzędzi należą Redux, React Router oraz MobX", true, questionRepository.getById(-501L)));
        answerRepository.save(new Answer(-537L, "React jest zazwyczaj używany z jQuery i Ajax bez dodatkowych narzędzi", false, questionRepository.getById(-501L)));
        answerRepository.save(new Answer(-538L, "Webpack i Babel są jedynymi narzędziami używanymi z React", false, questionRepository.getById(-501L)));

        // Odpowiedzi dla pytania: "Jakie są najlepsze praktyki dotyczące optymalizacji wydajności aplikacji React?"
        answerRepository.save(new Answer(-539L, "Używanie React.Fragment do grupowania list dzieci bez dodatkowych węzłów DOM", true, questionRepository.getById(-502L)));
        answerRepository.save(new Answer(-540L, "Stosowanie wielkich komponentów klasowych dla każdej małej funkcji w aplikacji", false, questionRepository.getById(-502L)));
        answerRepository.save(new Answer(-541L, "Trzymanie całego stanu aplikacji w jednym komponencie głównym", false, questionRepository.getById(-502L)));
        answerRepository.save(new Answer(-542L, "Zawsze używanie React.Component zamiast PureComponent", false, questionRepository.getById(-502L)));

        // Odpowiedzi dla pytania: "Co to jest optymalizacja wydajności w kontekście rozwoju webowego?"
        answerRepository.save(new Answer(-553L, "Optymalizacja wydajności to proces tworzenia aplikacji, które mogą wykonywać więcej operacji w krótszym czasie", false, questionRepository.getById(-543L)));
        answerRepository.save(new Answer(-554L, "Optymalizacja wydajności to proces poprawy czasu ładowania i responsywności stron internetowych", true, questionRepository.getById(-543L)));
        answerRepository.save(new Answer(-555L, "Optymalizacja wydajności dotyczy tylko zmniejszenia rozmiaru obrazów na stronie", false, questionRepository.getById(-543L)));
        answerRepository.save(new Answer(-556L, "Optymalizacja wydajności polega na zwiększeniu ilości danych, które strona może przechowywać w cache przeglądarki", false, questionRepository.getById(-543L)));

        // Odpowiedzi dla pytania: "Jakie są ogólne techniki optymalizacji wydajności stron internetowych?"
        answerRepository.save(new Answer(-557L, "Zwiększenie liczby reklam na stronie, aby przyciągnąć więcej użytkowników", false, questionRepository.getById(-544L)));
        answerRepository.save(new Answer(-558L, "Kompresja zasobów, opóźnione ładowanie (Lazy Loading), i asynchroniczne ładowanie skryptów", true, questionRepository.getById(-544L)));
        answerRepository.save(new Answer(-559L, "Dodanie większej ilości multimedia i dynamicznych skryptów dla lepszej interaktywności", false, questionRepository.getById(-544L)));
        answerRepository.save(new Answer(-560L, "Użycie tylko CSS do stylizacji bez JavaScript", false, questionRepository.getById(-544L)));

        // Odpowiedzi dla pytania: "Co to jest 'Lazy Loading' i jak wpływa na wydajność strony?"
        answerRepository.save(new Answer(-561L, "Lazy Loading to technika, która zwiększa wydajność poprzez wczytywanie składników strony tylko wtedy, gdy są one widoczne dla użytkownika", true, questionRepository.getById(-545L)));
        answerRepository.save(new Answer(-562L, "Lazy Loading to technika, która wymaga pełnego wczytywania wszystkich elementów strony przed jej wyświetleniem", false, questionRepository.getById(-545L)));
        answerRepository.save(new Answer(-563L, "Lazy Loading jest metodą szyfrowania danych przesyłanych między klientem a serwerem", false, questionRepository.getById(-545L)));
        answerRepository.save(new Answer(-564L, "Lazy Loading jest techniką opóźnienia ładowania reklam na stronie, co wpływa negatywnie na wydajność", false, questionRepository.getById(-545L)));

        // Odpowiedzi dla pytania: "Jakie są zalety stosowania Lazy Loading w aplikacjach webowych?"
        answerRepository.save(new Answer(-565L, "Zmniejsza zużycie przepustowości i poprawia czas ładowania strony poprzez ładowanie zawartości na żądanie", true, questionRepository.getById(-546L)));
        answerRepository.save(new Answer(-566L, "Zwiększa koszt hostingu poprzez intensywne użycie serwera", false, questionRepository.getById(-546L)));
        answerRepository.save(new Answer(-567L, "Powoduje szybsze zużycie zasobów przeglądarki przez nadmierne ładowanie JavaScript", false, questionRepository.getById(-546L)));
        answerRepository.save(new Answer(-568L, "Powoduje wzrost czasu ładowania strony z powodu dodatkowych obliczeń", false, questionRepository.getById(-546L)));

        // Odpowiedzi dla pytania: "Jak można zaimplementować Lazy Loading w JavaScript?"
        answerRepository.save(new Answer(-569L, "Używając tagu <link> do asynchronicznego ładowania skryptów", false, questionRepository.getById(-547L)));
        answerRepository.save(new Answer(-570L, "Przez zastosowanie atrybutu 'async' w tagach skryptowych", false, questionRepository.getById(-547L)));
        answerRepository.save(new Answer(-571L, "Wykorzystując funkcje Intersection Observer API do ładowania elementów, gdy wejdą w obszar widoczny", true, questionRepository.getById(-547L)));
        answerRepository.save(new Answer(-572L, "Implementując funkcje zwrotne (callbacks) w każdym elemencie HTML", false, questionRepository.getById(-547L)));

        // Odpowiedzi dla pytania: "Jakie narzędzia można użyć do analizy wydajności strony internetowej?"
        answerRepository.save(new Answer(-573L, "Google Analytics i Facebook Insights", false, questionRepository.getById(-548L)));
        answerRepository.save(new Answer(-574L, "Google PageSpeed Insights i Lighthouse", true, questionRepository.getById(-548L)));
        answerRepository.save(new Answer(-575L, "Microsoft Excel i Adobe Photoshop", false, questionRepository.getById(-548L)));
        answerRepository.save(new Answer(-576L, "Narzędzia do zarządzania treścią CMS jak WordPress czy Joomla", false, questionRepository.getById(-548L)));

        // Odpowiedzi dla pytania: "Jakie są najlepsze praktyki w optymalizacji renderowania strony?"
        answerRepository.save(new Answer(-577L, "Zwiększanie ilości złożonych animacji CSS i JavaScript", false, questionRepository.getById(-549L)));
        answerRepository.save(new Answer(-578L, "Minimalizacja kodu HTML, CSS i JavaScript", true, questionRepository.getById(-549L)));
        answerRepository.save(new Answer(-579L, "Stosowanie dużych plików obrazowych dla lepszej jakości", false, questionRepository.getById(-549L)));
        answerRepository.save(new Answer(-580L, "Wykorzystanie maksymalnej ilości wtyczek do przeglądarek", false, questionRepository.getById(-549L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między optymalizacją na stronie klienta a serwerowej?"
        answerRepository.save(new Answer(-581L, "Optymalizacja na stronie serwerowej dotyczy tylko przechowywania danych, a klienta dotyczy interfejsu użytkownika", false, questionRepository.getById(-550L)));
        answerRepository.save(new Answer(-582L, "Optymalizacja na stronie klienta skupia się na zmniejszeniu obciążenia przeglądarki, podczas gdy serwerowa na wydajności serwera", true, questionRepository.getById(-550L)));
        answerRepository.save(new Answer(-583L, "Nie ma żadnych różnic, obie dotyczą poprawy szybkości ładowania stron", false, questionRepository.getById(-550L)));
        answerRepository.save(new Answer(-584L, "Optymalizacja serwerowa jest mniej ważna, gdyż nowoczesne przeglądarki radzą sobie z większością zadań", false, questionRepository.getById(-550L)));

        // Odpowiedzi dla pytania: "Jak wpływa minifikacja zasobów na wydajność strony?"
        answerRepository.save(new Answer(-585L, "Zmniejsza to czas ładowania strony przez zmniejszenie rozmiaru przesyłanych danych", true, questionRepository.getById(-551L)));
        answerRepository.save(new Answer(-586L, "Zwiększa koszty utrzymania strony przez potrzebę używania zaawansowanych narzędzi do minifikacji", false, questionRepository.getById(-551L)));
        answerRepository.save(new Answer(-587L, "Nie ma wpływu na wydajność, ale poprawia bezpieczeństwo przesyłanych danych", false, questionRepository.getById(-551L)));
        answerRepository.save(new Answer(-588L, "Powoduje problemy z kompatybilnością starszych przeglądarek", false, questionRepository.getById(-551L)));

        // Odpowiedzi dla pytania: "Jak technika Lazy Loading wpływa na SEO strony internetowej?"
        answerRepository.save(new Answer(-589L, "Może negatywnie wpływać, ponieważ wyszukiwarki mogą nie zindeksować zawartości, która nie jest ładowana od razu", true, questionRepository.getById(-552L)));
        answerRepository.save(new Answer(-590L, "Poprawia SEO, gdyż strona wydaje się być lżejsza i szybciej się ładuje", false, questionRepository.getById(-552L)));
        answerRepository.save(new Answer(-591L, "Nie wpływa na SEO, ponieważ wyszukiwarki nie biorą pod uwagę szybkości ładowania", false, questionRepository.getById(-552L)));
        answerRepository.save(new Answer(-592L, "Zwiększa SEO poprzez automatyczne dodawanie słów kluczowych do ładowanych elementów", false, questionRepository.getById(-552L)));

        // Odpowiedzi dla pytania: "Co to jest Kotlin i do czego jest używany?"
        answerRepository.save(new Answer(-603L, "Kotlin to język programowania używany głównie dla aplikacji serwerowych", false, questionRepository.getById(-593L)));
        answerRepository.save(new Answer(-604L, "Kotlin to nowoczesny język programowania działający na maszynie wirtualnej Javy, używany głównie do tworzenia aplikacji Android i aplikacji backendowych", true, questionRepository.getById(-593L)));
        answerRepository.save(new Answer(-605L, "Kotlin to narzędzie do automatyzacji procesów w systemach Unix", false, questionRepository.getById(-593L)));
        answerRepository.save(new Answer(-606L, "Kotlin to specjalistyczny język do tworzenia gier komputerowych", false, questionRepository.getById(-593L)));

        // Odpowiedzi dla pytania: "Jakie są główne cechy języka Kotlin?"
        answerRepository.save(new Answer(-607L, "Statyczne typowanie, null-safety, i pełna interoperacyjność z Javą", true, questionRepository.getById(-594L)));
        answerRepository.save(new Answer(-608L, "Dynamiczne typowanie, automatyczne zarządzanie pamięcią i wsparcie dla programowania funkcyjnego", false, questionRepository.getById(-594L)));
        answerRepository.save(new Answer(-609L, "Wsparcie tylko dla platformy Windows, dynamiczne typowanie", false, questionRepository.getById(-594L)));
        answerRepository.save(new Answer(-610L, "Obsługa tylko aplikacji mobilnych Android", false, questionRepository.getById(-594L)));

        // Odpowiedzi dla pytania: "Jak Kotlin obsługuje nullability w porównaniu do Javy?"
        answerRepository.save(new Answer(-611L, "Kotlin wymaga jawnego oznaczania typów, które mogą przyjąć wartość null", true, questionRepository.getById(-595L)));
        answerRepository.save(new Answer(-612L, "W Kotlinie wszystkie typy mogą być null, podobnie jak w Javie", false, questionRepository.getById(-595L)));
        answerRepository.save(new Answer(-613L, "Kotlin eliminuje koncept nullability, każda zmienna musi być zainicjalizowana przy deklaracji", false, questionRepository.getById(-595L)));
        answerRepository.save(new Answer(-614L, "Kotlin używa opcjonalnych wartości null tylko w przypadku typów prymitywnych", false, questionRepository.getById(-595L)));

        // Odpowiedzi dla pytania: "Jak zadeklarować zmienną w Kotlinie?"
        answerRepository.save(new Answer(-615L, "Zmienne w Kotlinie deklaruje się za pomocą słów kluczowych 'let' lub 'const'", false, questionRepository.getById(-596L)));
        answerRepository.save(new Answer(-616L, "Używając słów kluczowych 'var' dla zmiennych zmienialnych i 'val' dla niezmienialnych", true, questionRepository.getById(-596L)));
        answerRepository.save(new Answer(-617L, "Zmienne deklaruje się, podając typ po nazwie zmiennej, np. x: Int", false, questionRepository.getById(-596L)));
        answerRepository.save(new Answer(-618L, "Zmienne są automatycznie deklarowane przy pierwszym użyciu", false, questionRepository.getById(-596L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między 'val' a 'var' w Kotlinie?"
        answerRepository.save(new Answer(-619L, "'val' jest dla zmiennych statycznych, 'var' dla dynamicznych", false, questionRepository.getById(-597L)));
        answerRepository.save(new Answer(-620L, "'val' oznacza zmienną niezmienialną, a 'var' zmienną, której wartość może być zmieniana", true, questionRepository.getById(-597L)));
        answerRepository.save(new Answer(-621L, "Nie ma różnic, oba słowa kluczowe są wymienne w Kotlinie", false, questionRepository.getById(-597L)));
        answerRepository.save(new Answer(-622L, "'val' jest używane dla typów wartościowych, a 'var' dla typów referencyjnych", false, questionRepository.getById(-597L)));

        // Odpowiedzi dla pytania: "Jak zdefiniować funkcję w Kotlinie?"
        answerRepository.save(new Answer(-623L, "Funkcje definiuje się używając słowa kluczowego 'function', np. function mojaFunkcja(){}", false, questionRepository.getById(-598L)));
        answerRepository.save(new Answer(-624L, "Funkcje definiuje się używając słowa kluczowego 'def', np. def mojaFunkcja(){}", false, questionRepository.getById(-598L)));
        answerRepository.save(new Answer(-625L, "Funkcje definiuje się używając słowa kluczowego 'fun', np. fun mojaFunkcja(){}", true, questionRepository.getById(-598L)));
        answerRepository.save(new Answer(-626L, "Funkcje są definiowane automatycznie przez kompilator Kotlin", false, questionRepository.getById(-598L)));

        // Odpowiedzi dla pytania: "Jak Kotlin obsługuje dziedziczenie?"
        answerRepository.save(new Answer(-627L, "W Kotlinie wszystkie klasy są domyślnie 'final', więc dziedziczenie jest możliwe tylko po klasach oznaczonych jako 'open'.", true, questionRepository.getById(-599L)));
        answerRepository.save(new Answer(-628L, "Dziedziczenie w Kotlinie nie jest możliwe; język ten używa tylko kompozycji do tworzenia hierarchii obiektów.", false, questionRepository.getById(-599L)));
        answerRepository.save(new Answer(-629L, "Kotlin używa słowa kluczowego 'extends' do dziedziczenia klas.", false, questionRepository.getById(-599L)));
        answerRepository.save(new Answer(-630L, "Kotlin automatycznie obsługuje dziedziczenie pomiędzy wszystkimi klasami.", false, questionRepository.getById(-599L)));

        // Odpowiedzi dla pytania: "Co to są data classes w Kotlinie i do czego są używane?"
        answerRepository.save(new Answer(-631L, "Data classes są specjalnymi klasami używanymi do obsługi baz danych w Kotlinie.", false, questionRepository.getById(-600L)));
        answerRepository.save(new Answer(-632L, "Data classes są klasami, które zapewniają automatycznie generowany kod potrzebny do modelowania danych, takich jak 'equals()', 'hashCode()', i 'toString()'.", true, questionRepository.getById(-600L)));
        answerRepository.save(new Answer(-633L, "Data classes są klasami abstrakcyjnymi używanymi do tworzenia definicji modeli w aplikacjach.", false, questionRepository.getById(-600L)));
        answerRepository.save(new Answer(-634L, "Data classes to funkcje Kotlin, które służą do przesyłania danych między komponentami.", false, questionRepository.getById(-600L)));

        // Odpowiedzi dla pytania: "Jak w Kotlinie zaimplementować interfejs?"
        answerRepository.save(new Answer(-635L, "Interfejsy w Kotlinie implementuje się za pomocą słowa kluczowego 'implements'.", false, questionRepository.getById(-601L)));
        answerRepository.save(new Answer(-636L, "Interfejsy są implementowane przez deklarację klasy z słowem kluczowym 'interface'.", false, questionRepository.getById(-601L)));
        answerRepository.save(new Answer(-637L, "Interfejsy w Kotlinie implementuje się, deklarując klasę z słowem kluczowym 'class' i następnie nazwą interfejsu.", true, questionRepository.getById(-601L)));
        answerRepository.save(new Answer(-638L, "Kotlin nie wspiera implementacji interfejsów, wszystko jest realizowane poprzez dziedziczenie.", false, questionRepository.getById(-601L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania Kotlin Coroutines?"
        answerRepository.save(new Answer(-639L, "Coroutines pozwalają na łatwe i efektywne zarządzanie wielowątkowością i operacjami asynchronicznymi.", true, questionRepository.getById(-602L)));
        answerRepository.save(new Answer(-640L, "Główną zaletą jest zwiększenie wydajności aplikacji poprzez automatyczne przetwarzanie wielowątkowe.", false, questionRepository.getById(-602L)));
        answerRepository.save(new Answer(-641L, "Coroutines ułatwiają interakcję z interfejsem użytkownika, eliminując potrzebę stosowania callbacków.", false, questionRepository.getById(-602L)));
        answerRepository.save(new Answer(-642L, "Kotlin Coroutines są używane głównie do skrócenia czasu kompilacji kodu.", false, questionRepository.getById(-602L)));

        // Odpowiedzi dla pytania: "Jak w Kotlinie używa się delegacji właściwości?"
        answerRepository.save(new Answer(-653L, "Używa się jej do delegowania metod klas do pojedynczej instancji kontrolera.", false, questionRepository.getById(-643L)));
        answerRepository.save(new Answer(-654L, "Delegacja właściwości jest wykorzystywana do bezpośredniego przypisywania wartości do właściwości w konstruktorze klasy.", false, questionRepository.getById(-643L)));
        answerRepository.save(new Answer(-655L, "Delegacja właściwości w Kotlinie pozwala na przekazanie odpowiedzialności za przechowywanie wartości do innych klas, używając 'by' klauzuli.", true, questionRepository.getById(-643L)));
        answerRepository.save(new Answer(-656L, "Delegacja właściwości nie jest wspierana w Kotlinie; zamiast tego używa się dziedziczenia.", false, questionRepository.getById(-643L)));

        // Odpowiedzi dla pytania: "Co to są funkcje rozszerzające w Kotlinie i jak można je zaimplementować?"
        answerRepository.save(new Answer(-657L, "Funkcje rozszerzające są specjalnymi konstruktorami w Kotlinie.", false, questionRepository.getById(-644L)));
        answerRepository.save(new Answer(-658L, "Są to metody klasy abstrakcyjnej, które muszą być nadpisane w klasach dziedziczących.", false, questionRepository.getById(-644L)));
        answerRepository.save(new Answer(-659L, "Funkcje rozszerzające pozwalają dodać nowe metody do istniejących klas bez modyfikacji ich kodu, definiując je poza klasą z dodatkowym odbiorcą.", true, questionRepository.getById(-644L)));
        answerRepository.save(new Answer(-660L, "Implementuje się je poprzez użycie słowa kluczowego 'extend' przed funkcją.", false, questionRepository.getById(-644L)));

        // Odpowiedzi dla pytania: "Jak działają wyrażenia lambda w Kotlinie i do czego są używane?"
        answerRepository.save(new Answer(-661L, "Lambda to interfejsy używane wyłącznie w kontekście wielowątkowości.", false, questionRepository.getById(-645L)));
        answerRepository.save(new Answer(-662L, "Są to predefiniowane funkcje w bibliotece standardowej Kotlin, nie można ich tworzyć samodzielnie.", false, questionRepository.getById(-645L)));
        answerRepository.save(new Answer(-663L, "Lambda to specjalny typ klasy w Kotlinie używany do modelowania danych.", false, questionRepository.getById(-645L)));
        answerRepository.save(new Answer(-664L, "Wyrażenia lambda w Kotlinie to skrócony sposób zapisu funkcji anonimowych, używane do tworzenia krótkich bloków kodu, które można przekazać jako argumenty.", true, questionRepository.getById(-645L)));

        // Odpowiedzi dla pytania: "Jakie są zalety stosowania sekwencji (sequences) w Kotlinie?"
        answerRepository.save(new Answer(-665L, "Główną zaletą jest szybsze przetwarzanie danych niż w standardowych listach.", false, questionRepository.getById(-646L)));
        answerRepository.save(new Answer(-666L, "Sekwencje są automatycznie wielowątkowe, co zwiększa wydajność.", false, questionRepository.getById(-646L)));
        answerRepository.save(new Answer(-667L, "Pozwalają na bezpośredni dostęp do indeksowanych elementów, jak w tablicach.", false, questionRepository.getById(-646L)));
        answerRepository.save(new Answer(-668L, "Sekwencje zapewniają leniwe przetwarzanie kolekcji, co jest efektywne przy dużych zbiorach danych.", true, questionRepository.getById(-646L)));

        // Odpowiedzi dla pytania: "Jak można zaimplementować wzorzec projektowy 'Singleton' w Kotlinie?"
        answerRepository.save(new Answer(-669L, "Używając słowa kluczowego 'singleton' w definicji klasy.", false, questionRepository.getById(-647L)));
        answerRepository.save(new Answer(-670L, "W Kotlinie wzorzec Singleton można zaimplementować używając obiektu zdefiniowanego słowem kluczowym 'object'.", true, questionRepository.getById(-647L)));
        answerRepository.save(new Answer(-671L, "Singleton w Kotlinie implementuje się przez stworzenie klasy abstrakcyjnej z jedną instancją.", false, questionRepository.getById(-647L)));
        answerRepository.save(new Answer(-672L, "Singleton jest domyślnym wzorcem dla wszystkich klas w Kotlinie.", false, questionRepository.getById(-647L)));

        // Odpowiedzi dla pytania: "Co to jest 'inline function' w Kotlinie i jakie przynosi korzyści?"
        answerRepository.save(new Answer(-673L, "Inline function to funkcja, której kod jest wstawiany bezpośrednio w miejsce wywołania, co zmniejsza narzut wywołania funkcji.", true, questionRepository.getById(-648L)));
        answerRepository.save(new Answer(-674L, "Inline function to funkcja, która automatycznie synchronizuje dostęp do zasobów między wątkami.", false, questionRepository.getById(-648L)));
        answerRepository.save(new Answer(-675L, "Inline function to funkcja, która jest wykonywana w tle przez kompilator.", false, questionRepository.getById(-648L)));
        answerRepository.save(new Answer(-676L, "Inline function to funkcja, która jest wykonywana tylko raz podczas inicjalizacji klasy.", false, questionRepository.getById(-648L)));

        // Odpowiedzi dla pytania: "Jak Kotlin obsługuje wielowątkowość i jakie mechanizmy są do tego używane?"
        answerRepository.save(new Answer(-677L, "Kotlin używa standardowych mechanizmów Javy do obsługi wielowątkowości, takich jak Thread i Runnable.", true, questionRepository.getById(-649L)));
        answerRepository.save(new Answer(-678L, "Kotlin nie obsługuje wielowątkowości, wszystko jest wykonywane w jednym wątku.", false, questionRepository.getById(-649L)));
        answerRepository.save(new Answer(-679L, "Kotlin ma własny mechanizm wielowątkowości oparty na korutynach, który zapewnia lepszą efektywność i prostszą synchronizację.", true, questionRepository.getById(-649L)));
        answerRepository.save(new Answer(-680L, "Kotlin używa specjalnych klas do obsługi wielowątkowości, takich jak MultiThread i ConcurrentTask.", false, questionRepository.getById(-649L)));

        // Odpowiedzi dla pytania: "Co to jest typ generyczny w Kotlinie i jakie ma zastosowania?"
        answerRepository.save(new Answer(-681L, "Typ generyczny w Kotlinie pozwala na definiowanie klas i funkcji, które mogą działać z dowolnym typem, zapewniając większą elastyczność i bezpieczeństwo typów.", true, questionRepository.getById(-650L)));
        answerRepository.save(new Answer(-682L, "Typ generyczny to specjalny typ danych używany wyłącznie w strukturach danych takich jak listy i mapy.", false, questionRepository.getById(-650L)));
        answerRepository.save(new Answer(-683L, "Typ generyczny to typ danych, który jest dynamicznie przydzielany podczas wykonania programu.", false, questionRepository.getById(-650L)));
        answerRepository.save(new Answer(-684L, "Typ generyczny to typ danych, który może przechowywać wartości tylko jednego typu przez cały czas życia programu.", false, questionRepository.getById(-650L)));

        // Odpowiedzi dla pytania: "Jak można użyć wzorca 'Decorator' w Kotlinie?"
        answerRepository.save(new Answer(-685L, "Wzorzec Decorator można zaimplementować, używając klas rozszerzających i funkcji rozszerzających, aby dodać nowe funkcje do istniejących obiektów.", true, questionRepository.getById(-651L)));
        answerRepository.save(new Answer(-686L, "W Kotlinie wzorzec Decorator jest automatycznie zarządzany przez kompilator i nie wymaga specjalnego kodu.", false, questionRepository.getById(-651L)));
        answerRepository.save(new Answer(-687L, "Wzorzec Decorator jest realizowany wyłącznie poprzez dziedziczenie po abstrakcyjnych klasach dekoratora.", false, questionRepository.getById(-651L)));
        answerRepository.save(new Answer(-688L, "W Kotlinie wzorzec Decorator nie jest obsługiwany; zamiast tego używa się wzorca Singleton.", false, questionRepository.getById(-651L)));

        // Odpowiedzi dla pytania: "Co to jest rekursja ogonowa w Kotlinie i jak jest optymalizowana?"
        answerRepository.save(new Answer(-689L, "Rekursja ogonowa to technika optymalizacji wywołań rekurencyjnych, gdzie ostatnia operacja funkcji jest wywołaniem samej siebie, co pozwala na optymalizację przez kompilator.", true, questionRepository.getById(-652L)));
        answerRepository.save(new Answer(-690L, "Rekursja ogonowa to technika, w której funkcje rekurencyjne są zawsze wywoływane na końcu programu.", false, questionRepository.getById(-652L)));
        answerRepository.save(new Answer(-691L, "Rekursja ogonowa to technika, która eliminuje potrzebę używania rekurencji w funkcjach, zamieniając ją na iteracje.", false, questionRepository.getById(-652L)));
        answerRepository.save(new Answer(-692L, "Rekursja ogonowa to technika, w której funkcje rekurencyjne są automatycznie przekształcane w równoległe zadania.", false, questionRepository.getById(-652L)));

        // Odpowiedzi dla pytania: "Co to jest C++ i do czego jest używany?"
        answerRepository.save(new Answer(-703L, "C++ to język skryptowy używany głównie do tworzenia stron internetowych.", false, questionRepository.getById(-693L)));
        answerRepository.save(new Answer(-704L, "C++ to framework do tworzenia aplikacji mobilnych.", false, questionRepository.getById(-693L)));
        answerRepository.save(new Answer(-705L, "C++ to język programowania ogólnego przeznaczenia, używany głównie do tworzenia systemów operacyjnych, gier i aplikacji o wysokiej wydajności.", true, questionRepository.getById(-693L)));
        answerRepository.save(new Answer(-706L, "C++ to narzędzie do analizy danych.", false, questionRepository.getById(-693L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe typy danych w C++?"
        answerRepository.save(new Answer(-707L, "Podstawowe typy danych to integer, decimal, string, boolean.", false, questionRepository.getById(-694L)));
        answerRepository.save(new Answer(-708L, "Podstawowe typy danych to int, float, double, char, bool.", true, questionRepository.getById(-694L)));
        answerRepository.save(new Answer(-709L, "Podstawowe typy danych to wholeNumber, fractionalNumber, text.", false, questionRepository.getById(-694L)));
        answerRepository.save(new Answer(-710L, "Podstawowe typy danych to num, txt, bool.", false, questionRepository.getById(-694L)));

        // Odpowiedzi dla pytania: "Jak zadeklarować zmienną w C++?"
        answerRepository.save(new Answer(-711L, "Zmienną w C++ deklaruje się przez użycie słowa kluczowego var, np. var x = 5;", false, questionRepository.getById(-695L)));
        answerRepository.save(new Answer(-712L, "Zmienną w C++ deklaruje się przez użycie słowa kluczowego let, np. let x = 5;", false, questionRepository.getById(-695L)));
        answerRepository.save(new Answer(-713L, "Zmienną w C++ deklaruje się przez podanie typu zmiennej, a następnie jej nazwy, np. int x;", true, questionRepository.getById(-695L)));
        answerRepository.save(new Answer(-714L, "Zmienną w C++ deklaruje się przez użycie słowa kluczowego const, np. const x = 5;", false, questionRepository.getById(-695L)));

        // Odpowiedzi dla pytania: "Co to są wskaźniki i jak się ich używa w C++?"
        answerRepository.save(new Answer(-715L, "Wskaźniki to zmienne, które przechowują wartości innych zmiennych. Używa się ich do prostych operacji matematycznych.", false, questionRepository.getById(-696L)));
        answerRepository.save(new Answer(-716L, "Wskaźniki to specjalne funkcje używane do sortowania danych.", false, questionRepository.getById(-696L)));
        answerRepository.save(new Answer(-717L, "Wskaźniki to zmienne, które przechowują adresy innych zmiennych. Używa się ich do dynamicznego przydzielania pamięci, zarządzania tablicami i tworzenia złożonych struktur danych.", true, questionRepository.getById(-696L)));
        answerRepository.save(new Answer(-718L, "Wskaźniki to typy danych używane do przechowywania znaków.", false, questionRepository.getById(-696L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między wskaźnikiem a referencją w C++?"
        answerRepository.save(new Answer(-719L, "Referencja przechowuje adres zmiennej, natomiast wskaźnik jest aliasem zmiennej.", false, questionRepository.getById(-697L)));
        answerRepository.save(new Answer(-720L, "Wskaźnik przechowuje adres zmiennej, natomiast referencja jest aliasem zmiennej.", true, questionRepository.getById(-697L)));
        answerRepository.save(new Answer(-721L, "Wskaźnik jest używany do przechowywania wartości zmiennych, natomiast referencja jest używana do przechowywania adresów zmiennych.", false, questionRepository.getById(-697L)));
        answerRepository.save(new Answer(-722L, "Nie ma różnicy między wskaźnikiem a referencją w C++.", false, questionRepository.getById(-697L)));

        // Odpowiedzi dla pytania: "Jak zdefiniować funkcję w C++?"
        answerRepository.save(new Answer(-723L, "Funkcję w C++ definiuje się przez użycie słowa kluczowego def, np. def suma(a, b).", false, questionRepository.getById(-698L)));
        answerRepository.save(new Answer(-724L, "Funkcję w C++ definiuje się przez użycie słowa kluczowego fun, np. fun suma(a, b).", false, questionRepository.getById(-698L)));
        answerRepository.save(new Answer(-725L, "Funkcję w C++ definiuje się przez podanie typu zwracanej wartości, nazwy funkcji oraz listy parametrów, np. int suma(int a, int b).", true, questionRepository.getById(-698L)));
        answerRepository.save(new Answer(-726L, "Funkcję w C++ definiuje się przez użycie słowa kluczowego function, np. function suma(a, b).", false, questionRepository.getById(-698L)));

        // Odpowiedzi dla pytania: "Co to jest klasa w C++ i jak ją zdefiniować?"
        answerRepository.save(new Answer(-727L, "Klasa w C++ to typ danych, który może zawierać tylko funkcje (metody). Definiuje się ją za pomocą słowa kluczowego class, np. class MojaKlasa.", false, questionRepository.getById(-699L)));
        answerRepository.save(new Answer(-728L, "Klasa w C++ to złożony typ danych, który może zawierać zarówno dane (pola), jak i funkcje (metody). Definiuje się ją za pomocą słowa kluczowego class, np. class MojaKlasa.", true, questionRepository.getById(-699L)));
        answerRepository.save(new Answer(-729L, "Klasa w C++ to złożony typ danych, który może zawierać tylko dane (pola). Definiuje się ją za pomocą słowa kluczowego class, np. class MojaKlasa.", false, questionRepository.getById(-699L)));
        answerRepository.save(new Answer(-730L, "Klasa w C++ to typ danych używany tylko do dziedziczenia. Definiuje się ją za pomocą słowa kluczowego class, np. class MojaKlasa.", false, questionRepository.getById(-699L)));

        // Odpowiedzi dla pytania: "Jak działa dziedziczenie w C++?"
        answerRepository.save(new Answer(-731L, "Dziedziczenie w C++ pozwala jednej klasie przejąć właściwości i metody innej klasy. Używa się do tego dwukropka i specyfikatora dostępu, np. class Podklasa : public BazowaKlasa.", true, questionRepository.getById(-700L)));
        answerRepository.save(new Answer(-732L, "Dziedziczenie w C++ pozwala jednej klasie przejąć właściwości i metody innej klasy. Używa się do tego słowa kluczowego extends, np. class Podklasa extends BazowaKlasa.", false, questionRepository.getById(-700L)));
        answerRepository.save(new Answer(-733L, "Dziedziczenie w C++ pozwala jednej klasie przejąć właściwości i metody innej klasy. Używa się do tego słowa kluczowego inherit, np. class Podklasa inherit BazowaKlasa.", false, questionRepository.getById(-700L)));
        answerRepository.save(new Answer(-734L, "Dziedziczenie w C++ nie jest możliwe. Każda klasa musi być definiowana osobno.", false, questionRepository.getById(-700L)));

        // Odpowiedzi dla pytania: "Co to jest konstruktor i destruktor w C++?"
        answerRepository.save(new Answer(-735L, "Konstruktor to funkcja, która jest wywoływana podczas usuwania obiektu klasy, a destruktor to funkcja wywoływana podczas tworzenia obiektu klasy.", false, questionRepository.getById(-701L)));
        answerRepository.save(new Answer(-736L, "Konstruktor to specjalna funkcja, która jest wywoływana podczas tworzenia obiektu klasy, a destruktor to specjalna funkcja wywoływana podczas usuwania obiektu klasy.", true, questionRepository.getById(-701L)));
        answerRepository.save(new Answer(-737L, "Konstruktor to funkcja używana do inicjalizacji zmiennych w klasie, a destruktor to funkcja używana do zarządzania pamięcią dynamiczną.", false, questionRepository.getById(-701L)));
        answerRepository.save(new Answer(-738L, "Konstruktor to funkcja, która jest używana do zarządzania pamięcią dynamiczną, a destruktor to funkcja używana do inicjalizacji zmiennych w klasie.", false, questionRepository.getById(-701L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe różnice między C++ a innymi językami programowania, takimi jak Python lub Java?"
        answerRepository.save(new Answer(-739L, "C++ oferuje bardziej bezpośredni dostęp do pamięci i większą kontrolę nad zasobami sprzętowymi w porównaniu do Pythona i Javy.", true, questionRepository.getById(-702L)));
        answerRepository.save(new Answer(-740L, "Python i Java są językami kompilowanymi, podczas gdy C++ jest językiem interpretowanym.", false, questionRepository.getById(-702L)));
        answerRepository.save(new Answer(-741L, "C++ jest językiem o dynamicznym typowaniu, podczas gdy Python i Java są językami o statycznym typowaniu.", false, questionRepository.getById(-702L)));
        answerRepository.save(new Answer(-742L, "Python i Java oferują bardziej bezpośredni dostęp do pamięci i większą kontrolę nad zasobami sprzętowymi w porównaniu do C++.", false, questionRepository.getById(-702L)));

        // Odpowiedzi dla pytania: "Co to jest koncept (concept) w C++20?"
        answerRepository.save(new Answer(-753L, "Koncept to nowy sposób definiowania wymagań dla typów w szablonach.", true, questionRepository.getById(-743L)));
        answerRepository.save(new Answer(-754L, "Koncept to nowy typ danych wprowadzony w C++20.", false, questionRepository.getById(-743L)));
        answerRepository.save(new Answer(-755L, "Koncept to nowa metoda zarządzania pamięcią w C++20.", false, questionRepository.getById(-743L)));
        answerRepository.save(new Answer(-756L, "Koncept to funkcja służąca do optymalizacji kodu.", false, questionRepository.getById(-743L)));

        // Odpowiedzi dla pytania: "Jakie są główne cele wprowadzenia korutyn (coroutines) w C++20?"
        answerRepository.save(new Answer(-757L, "Korutyny są wprowadzone w celu poprawy zarządzania pamięcią.", false, questionRepository.getById(-744L)));
        answerRepository.save(new Answer(-758L, "Korutyny zastępują wskaźniki i referencje w C++20.", false, questionRepository.getById(-744L)));
        answerRepository.save(new Answer(-759L, "Korutyny wprowadzają możliwość współprogramowania, co ułatwia pisanie asynchronicznego kodu.", true, questionRepository.getById(-744L)));
        answerRepository.save(new Answer(-760L, "Korutyny są nowym typem zmiennych w C++20.", false, questionRepository.getById(-744L)));

        // Odpowiedzi dla pytania: "Jak działa operator trójargumentowy (spaceship operator) w C++20?"
        answerRepository.save(new Answer(-761L, "Operator trójargumentowy jest używany do zarządzania pamięcią.", false, questionRepository.getById(-745L)));
        answerRepository.save(new Answer(-762L, "Operator trójargumentowy to nowa funkcja do formatowania tekstu.", false, questionRepository.getById(-745L)));
        answerRepository.save(new Answer(-763L, "Operator trójargumentowy zastępuje operator przypisania.", false, questionRepository.getById(-745L)));
        answerRepository.save(new Answer(-764L, "Operator trójargumentowy ułatwia porównywanie wartości, zwracając jedną z trzech wartości: mniej, równo, więcej.", true, questionRepository.getById(-745L)));

        // Odpowiedzi dla pytania: "Co to jest zakres (range) w C++20 i jakie daje korzyści?"
        answerRepository.save(new Answer(-765L, "Zakresy (ranges) ułatwiają manipulację sekwencjami danych poprzez udostępnienie nowego interfejsu do pracy z kolekcjami.", true, questionRepository.getById(-746L)));
        answerRepository.save(new Answer(-766L, "Zakresy (ranges) to nowy typ danych wprowadzony w C++20.", false, questionRepository.getById(-746L)));
        answerRepository.save(new Answer(-767L, "Zakresy (ranges) służą do zarządzania pamięcią w programach C++.", false, questionRepository.getById(-746L)));
        answerRepository.save(new Answer(-768L, "Zakresy (ranges) są nowym rodzajem funkcji w C++20.", false, questionRepository.getById(-746L)));

        // Odpowiedzi dla pytania: "Jakie są nowe funkcje związane z programowaniem współbieżnym w C++20?"
        answerRepository.save(new Answer(-769L, "C++20 wprowadza nowy standardowy model współbieżności.", false, questionRepository.getById(-747L)));
        answerRepository.save(new Answer(-770L, "C++20 zastępuje wszystkie wcześniejsze mechanizmy współbieżności nowymi funkcjami.", false, questionRepository.getById(-747L)));
        answerRepository.save(new Answer(-771L, "C++20 wprowadza nową składnię do definiowania wątków.", false, questionRepository.getById(-747L)));
        answerRepository.save(new Answer(-772L, "C++20 wprowadza nowe biblioteki do zarządzania współbieżnością, takie jak std::jthread i synchronizacja z atomic_wait.", true, questionRepository.getById(-747L)));

        // Odpowiedzi dla pytania: "Jakie są główne zmiany w standardowej bibliotece C++20?"
        answerRepository.save(new Answer(-773L, "Wprowadzenie nowych algorytmów do biblioteki standardowej, takich jak ranges::copy, ranges::sort.", true, questionRepository.getById(-748L)));
        answerRepository.save(new Answer(-774L, "Wprowadzenie nowego typu zmiennych w bibliotece standardowej.", false, questionRepository.getById(-748L)));
        answerRepository.save(new Answer(-775L, "Usunięcie wsparcia dla starszych wersji C++ w bibliotece standardowej.", false, questionRepository.getById(-748L)));
        answerRepository.save(new Answer(-776L, "Zastąpienie wszystkich wcześniejszych funkcji nowymi.", false, questionRepository.getById(-748L)));

        // Odpowiedzi dla pytania: "Jakie są zalety używania modułów w C++20?"
        answerRepository.save(new Answer(-777L, "Moduły poprawiają szybkość kompilacji i zarządzanie zależnościami w dużych projektach.", true, questionRepository.getById(-749L)));
        answerRepository.save(new Answer(-778L, "Moduły wprowadzają nowy sposób zarządzania pamięcią.", false, questionRepository.getById(-749L)));
        answerRepository.save(new Answer(-779L, "Moduły zastępują wskaźniki i referencje w C++20.", false, questionRepository.getById(-749L)));
        answerRepository.save(new Answer(-780L, "Moduły służą do optymalizacji kodu w C++20.", false, questionRepository.getById(-749L)));

        // Odpowiedzi dla pytania: "Jakie są główne zmiany w zakresie inicjalizacji zmiennych w C++20?"
        answerRepository.save(new Answer(-781L, "C++20 usuwa wsparcie dla starej składni inicjalizacji zmiennych.", false, questionRepository.getById(-750L)));
        answerRepository.save(new Answer(-782L, "C++20 zmienia sposób deklaracji zmiennych globalnych.", false, questionRepository.getById(-750L)));
        answerRepository.save(new Answer(-783L, "C++20 wprowadza nowe typy zmiennych dla inicjalizacji.", false, questionRepository.getById(-750L)));
        answerRepository.save(new Answer(-784L, "C++20 wprowadza nową składnię inicjalizacji zmiennych przy użyciu nawiasów.", true, questionRepository.getById(-750L)));

        // Odpowiedzi dla pytania: "Jakie są główne zmiany dotyczące szablonów (templates) w C++20?"
        answerRepository.save(new Answer(-785L, "C++20 wprowadza bardziej elastyczne szablony poprzez koncepty, które pozwalają na lepsze definiowanie wymagań dla typów.", true, questionRepository.getById(-751L)));
        answerRepository.save(new Answer(-786L, "C++20 usuwa wsparcie dla starszych wersji szablonów.", false, questionRepository.getById(-751L)));
        answerRepository.save(new Answer(-787L, "C++20 wprowadza nową składnię dla szablonów, która jest niekompatybilna z poprzednimi wersjami.", false, questionRepository.getById(-751L)));
        answerRepository.save(new Answer(-788L, "C++20 zmienia sposób definiowania szablonów dla funkcji.", false, questionRepository.getById(-751L)));

        // Odpowiedzi dla pytania: "Co to jest formatowanie std::format w C++20?"
        answerRepository.save(new Answer(-789L, "std::format to nowa funkcja do zarządzania pamięcią w C++20.", false, questionRepository.getById(-752L)));
        answerRepository.save(new Answer(-790L, "std::format to nowa metoda sortowania danych w C++20.", false, questionRepository.getById(-752L)));
        answerRepository.save(new Answer(-791L, "std::format to nowy typ danych w C++20.", false, questionRepository.getById(-752L)));
        answerRepository.save(new Answer(-792L, "std::format to nowa funkcja do formatowania ciągów znaków, która jest bardziej elastyczna i bezpieczna niż wcześniej używane metody.", true, questionRepository.getById(-752L)));

        // Odpowiedzi dla pytania: "Co to jest PHP i do czego jest używane?"
        answerRepository.save(new Answer(-803L, "PHP to język programowania używany głównie do analizy danych.", false, questionRepository.getById(-793L)));
        answerRepository.save(new Answer(-804L, "PHP to język programowania ogólnego przeznaczenia używany do tworzenia dynamicznych stron internetowych.", true, questionRepository.getById(-793L)));
        answerRepository.save(new Answer(-805L, "PHP to framework do tworzenia aplikacji mobilnych.", false, questionRepository.getById(-793L)));
        answerRepository.save(new Answer(-806L, "PHP to narzędzie do zarządzania bazami danych.", false, questionRepository.getById(-793L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe typy danych w PHP?"
        answerRepository.save(new Answer(-807L, "Podstawowe typy danych to integer, decimal, text, boolean.", false, questionRepository.getById(-794L)));
        answerRepository.save(new Answer(-808L, "Podstawowe typy danych to num, str, bool.", false, questionRepository.getById(-794L)));
        answerRepository.save(new Answer(-809L, "Podstawowe typy danych to int, float, string, bool.", true, questionRepository.getById(-794L)));
        answerRepository.save(new Answer(-810L, "Podstawowe typy danych to number, text, array.", false, questionRepository.getById(-794L)));

        // Odpowiedzi dla pytania: "Jak zadeklarować zmienną w PHP?"
        answerRepository.save(new Answer(-811L, "Zmienną w PHP deklaruje się przez użycie słowa kluczowego var, np. var x = 5;", false, questionRepository.getById(-795L)));
        answerRepository.save(new Answer(-812L, "Zmienną w PHP deklaruje się przez użycie znaku dolara przed nazwą zmiennej, np. $x = 5;", true, questionRepository.getById(-795L)));
        answerRepository.save(new Answer(-813L, "Zmienną w PHP deklaruje się przez użycie słowa kluczowego let, np. let x = 5;", false, questionRepository.getById(-795L)));
        answerRepository.save(new Answer(-814L, "Zmienną w PHP deklaruje się przez użycie słowa kluczowego const, np. const x = 5;", false, questionRepository.getById(-795L)));

        // Odpowiedzi dla pytania: "Co to są tablice w PHP i jak się je definiuje?"
        answerRepository.save(new Answer(-815L, "Tablica w PHP to zmienna, która może przechowywać wiele wartości jednocześnie. Używa się jej za pomocą funkcji array().", true, questionRepository.getById(-796L)));
        answerRepository.save(new Answer(-816L, "Tablica w PHP to zmienna, która może przechowywać tylko wartości tekstowe.", false, questionRepository.getById(-796L)));
        answerRepository.save(new Answer(-817L, "Tablica w PHP to specjalna funkcja używana do sortowania danych.", false, questionRepository.getById(-796L)));
        answerRepository.save(new Answer(-818L, "Tablica w PHP to zmienna, która może przechowywać tylko liczby całkowite.", false, questionRepository.getById(-796L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między zmiennymi lokalnymi a globalnymi w PHP?"
        answerRepository.save(new Answer(-819L, "Zmienna lokalna jest dostępna tylko w obrębie funkcji, w której została zadeklarowana, a zmienna globalna jest dostępna w całym skrypcie.", true, questionRepository.getById(-797L)));
        answerRepository.save(new Answer(-820L, "Zmienna lokalna jest dostępna w całym skrypcie, a zmienna globalna tylko w obrębie funkcji.", false, questionRepository.getById(-797L)));
        answerRepository.save(new Answer(-821L, "Zmienna lokalna jest dostępna tylko w plikach konfiguracyjnych, a zmienna globalna tylko w klasach.", false, questionRepository.getById(-797L)));
        answerRepository.save(new Answer(-822L, "Zmienna lokalna i zmienna globalna są identyczne w PHP.", false, questionRepository.getById(-797L)));

        // Odpowiedzi dla pytania: "Jak zdefiniować funkcję w PHP?"
        answerRepository.save(new Answer(-823L, "Funkcję w PHP definiuje się przez użycie słowa kluczowego function, np. function mojaFunkcja() {}", true, questionRepository.getById(-798L)));
        answerRepository.save(new Answer(-824L, "Funkcję w PHP definiuje się przez użycie słowa kluczowego def, np. def mojaFunkcja() {}", false, questionRepository.getById(-798L)));
        answerRepository.save(new Answer(-825L, "Funkcję w PHP definiuje się przez użycie słowa kluczowego func, np. func mojaFunkcja() {}", false, questionRepository.getById(-798L)));
        answerRepository.save(new Answer(-826L, "Funkcję w PHP definiuje się przez użycie słowa kluczowego lambda, np. lambda mojaFunkcja() {}", false, questionRepository.getById(-798L)));

        // Odpowiedzi dla pytania: "Co to są superglobalne tablice w PHP i jakie są ich przykłady?"
        answerRepository.save(new Answer(-827L, "Superglobalne tablice to zmienne, które są dostępne tylko w obrębie jednej funkcji.", false, questionRepository.getById(-799L)));
        answerRepository.save(new Answer(-828L, "Superglobalne tablice to zmienne, które są dostępne we wszystkich funkcjach po użyciu słowa kluczowego global.", false, questionRepository.getById(-799L)));
        answerRepository.save(new Answer(-829L, "Superglobalne tablice to zmienne, które są dostępne tylko w plikach konfiguracyjnych.", false, questionRepository.getById(-799L)));
        answerRepository.save(new Answer(-830L, "Superglobalne tablice to zmienne, które są dostępne w całym skrypcie, niezależnie od zakresu, np. $_GET, $_POST, $_SESSION.", true, questionRepository.getById(-799L)));

        // Odpowiedzi dla pytania: "Jakie są metody obsługi formularzy w PHP?"
        answerRepository.save(new Answer(-831L, "Formularze w PHP są obsługiwane za pomocą metod GET i POST.", true, questionRepository.getById(-800L)));
        answerRepository.save(new Answer(-832L, "Formularze w PHP są obsługiwane tylko za pomocą metody GET.", false, questionRepository.getById(-800L)));
        answerRepository.save(new Answer(-833L, "Formularze w PHP są obsługiwane tylko za pomocą metody POST.", false, questionRepository.getById(-800L)));
        answerRepository.save(new Answer(-834L, "Formularze w PHP są obsługiwane za pomocą metody PUSH.", false, questionRepository.getById(-800L)));

        // Odpowiedzi dla pytania: "Co to jest sesja w PHP i jak ją rozpocząć?"
        answerRepository.save(new Answer(-835L, "Sesja w PHP to mechanizm pozwalający na przechowywanie danych pomiędzy różnymi żądaniami HTTP. Rozpoczyna się ją za pomocą funkcji session_start().", true, questionRepository.getById(-801L)));
        answerRepository.save(new Answer(-836L, "Sesja w PHP to zmienna globalna, którą definiuje się za pomocą słowa kluczowego session.", false, questionRepository.getById(-801L)));
        answerRepository.save(new Answer(-837L, "Sesja w PHP to mechanizm do zarządzania plikami na serwerze.", false, questionRepository.getById(-801L)));
        answerRepository.save(new Answer(-838L, "Sesja w PHP to specjalny typ zmiennej dostępny tylko w klasach.", false, questionRepository.getById(-801L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe funkcje do operacji na plikach w PHP?"
        answerRepository.save(new Answer(-839L, "Podstawowe funkcje do operacji na plikach to file_open(), file_read(), file_write().", false, questionRepository.getById(-802L)));
        answerRepository.save(new Answer(-840L, "Podstawowe funkcje do operacji na plikach to fopen(), fread(), fwrite(), fclose().", true, questionRepository.getById(-802L)));
        answerRepository.save(new Answer(-841L, "Podstawowe funkcje do operacji na plikach to open(), read(), write(), close().", false, questionRepository.getById(-802L)));
        answerRepository.save(new Answer(-842L, "Podstawowe funkcje do operacji na plikach to file_get(), file_put(), file_close().", false, questionRepository.getById(-802L)));

        // Odpowiedzi dla pytania: "Co to jest JIT (Just-In-Time) w PHP 8?"
        answerRepository.save(new Answer(-853L, "JIT to nowa funkcja do zarządzania sesjami w PHP 8.", false, questionRepository.getById(-843L)));
        answerRepository.save(new Answer(-854L, "JIT to narzędzie do analizy kodu w PHP 8.", false, questionRepository.getById(-843L)));
        answerRepository.save(new Answer(-855L, "JIT to technika kompilacji, która polepsza wydajność skryptów PHP przez kompilację kodu do kodu maszynowego w trakcie jego wykonania.", true, questionRepository.getById(-843L)));
        answerRepository.save(new Answer(-856L, "JIT to mechanizm do zarządzania pamięcią w PHP 8.", false, questionRepository.getById(-843L)));

        // Odpowiedzi dla pytania: "Jakie są główne korzyści z użycia JIT w PHP 8?"
        answerRepository.save(new Answer(-857L, "Automatyczne zarządzanie pamięcią bez potrzeby programisty.", false, questionRepository.getById(-844L)));
        answerRepository.save(new Answer(-858L, "Uproszczona składnia języka PHP.", false, questionRepository.getById(-844L)));
        answerRepository.save(new Answer(-859L, "Lepsza kompatybilność z innymi językami programowania.", false, questionRepository.getById(-844L)));
        answerRepository.save(new Answer(-860L, "Zwiększona wydajność skryptów PHP, zwłaszcza w aplikacjach wymagających dużej mocy obliczeniowej.", true, questionRepository.getById(-844L)));

        // Odpowiedzi dla pytania: "Co to są atrybuty w PHP 8 i jak są używane?"
        answerRepository.save(new Answer(-861L, "Atrybuty to specjalne funkcje używane do zarządzania sesjami.", false, questionRepository.getById(-845L)));
        answerRepository.save(new Answer(-862L, "Atrybuty to meta-dane, które można dodawać do deklaracji klas, metod, zmiennych itp., aby przekazać dodatkowe informacje.", true, questionRepository.getById(-845L)));
        answerRepository.save(new Answer(-863L, "Atrybuty to nowe typy zmiennych wprowadzone w PHP 8.", false, questionRepository.getById(-845L)));
        answerRepository.save(new Answer(-864L, "Atrybuty to nowe narzędzie do debugowania kodu.", false, questionRepository.getById(-845L)));

        // Odpowiedzi dla pytania: "Jakie nowe typy danych wprowadza PHP 8?"
        answerRepository.save(new Answer(-865L, "PHP 8 wprowadza typy danych var, let.", false, questionRepository.getById(-846L)));
        answerRepository.save(new Answer(-866L, "PHP 8 wprowadza typy danych mixed, union types.", true, questionRepository.getById(-846L)));
        answerRepository.save(new Answer(-867L, "PHP 8 wprowadza typy danych text, array.", false, questionRepository.getById(-846L)));
        answerRepository.save(new Answer(-868L, "PHP 8 nie wprowadza nowych typów danych.", false, questionRepository.getById(-846L)));

        // Odpowiedzi dla pytania: "Co to jest operator Nullsafe w PHP 8 i jak działa?"
        answerRepository.save(new Answer(-869L, "Operator Nullsafe pozwala na bezpieczne wywoływanie metod na obiektach, które mogą być null, unikając błędów.", true, questionRepository.getById(-847L)));
        answerRepository.save(new Answer(-870L, "Operator Nullsafe jest używany do zarządzania pamięcią w PHP 8.", false, questionRepository.getById(-847L)));
        answerRepository.save(new Answer(-871L, "Operator Nullsafe to nowa funkcja do zarządzania sesjami.", false, questionRepository.getById(-847L)));
        answerRepository.save(new Answer(-872L, "Operator Nullsafe pozwala na automatyczne logowanie błędów.", false, questionRepository.getById(-847L)));

        // Odpowiedzi dla pytania: "Jakie są zmiany w zarządzaniu błędami w PHP 8?"
        answerRepository.save(new Answer(-873L, "PHP 8 usuwa mechanizm wyjątków i wprowadza nowe funkcje do debugowania.", false, questionRepository.getById(-848L)));
        answerRepository.save(new Answer(-874L, "PHP 8 wprowadza tylko zmiany w składni języka.", false, questionRepository.getById(-848L)));
        answerRepository.save(new Answer(-875L, "PHP 8 nie wprowadza żadnych zmian w zarządzaniu błędami.", false, questionRepository.getById(-848L)));
        answerRepository.save(new Answer(-876L, "PHP 8 wprowadza ulepszenia w obsłudze błędów, w tym nowe typy wyjątków i lepsze raportowanie błędów.", true, questionRepository.getById(-848L)));

        // Odpowiedzi dla pytania: "Jakie ulepszenia wprowadzono w zakresie typowania w PHP 8?"
        answerRepository.save(new Answer(-877L, "PHP 8 wprowadza typy union, które pozwalają na deklarowanie zmiennych z wieloma typami.", true, questionRepository.getById(-849L)));
        answerRepository.save(new Answer(-878L, "PHP 8 wprowadza dynamiczne typowanie dla zmiennych.", false, questionRepository.getById(-849L)));
        answerRepository.save(new Answer(-879L, "PHP 8 usuwa wszystkie typy danych i wprowadza typowanie dynamiczne.", false, questionRepository.getById(-849L)));
        answerRepository.save(new Answer(-880L, "PHP 8 wprowadza nowy typ danych text.", false, questionRepository.getById(-849L)));

        // Odpowiedzi dla pytania: "Co to jest Match Expression w PHP 8 i jak działa?"
        answerRepository.save(new Answer(-881L, "Match Expression to nowa funkcja do porównywania ciągów znaków.", false, questionRepository.getById(-850L)));
        answerRepository.save(new Answer(-882L, "Match Expression to narzędzie do debugowania w PHP 8.", false, questionRepository.getById(-850L)));
        answerRepository.save(new Answer(-883L, "Match Expression to nowa metoda zarządzania sesjami.", false, questionRepository.getById(-850L)));
        answerRepository.save(new Answer(-884L, "Match Expression to nowa konstrukcja, która pozwala na bardziej czytelne i zwięzłe pisanie instrukcji warunkowych.", true, questionRepository.getById(-850L)));

        // Odpowiedzi dla pytania: "Jakie są główne różnice między PHP 7 a PHP 8?"
        answerRepository.save(new Answer(-885L, "PHP 8 usuwa wszystkie funkcje z PHP 7 i wprowadza całkowicie nowe podejście do programowania.", false, questionRepository.getById(-851L)));
        answerRepository.save(new Answer(-886L, "PHP 8 wprowadza JIT, nowe typy danych, atrybuty oraz ulepszenia w zakresie typowania i zarządzania błędami.", true, questionRepository.getById(-851L)));
        answerRepository.save(new Answer(-887L, "PHP 8 jest jedynie poprawką błędów PHP 7 bez żadnych nowych funkcji.", false, questionRepository.getById(-851L)));
        answerRepository.save(new Answer(-888L, "PHP 8 wprowadza nowy system zarządzania pamięcią i typami dynamicznymi.", false, questionRepository.getById(-851L)));

        // Odpowiedzi dla pytania: "Jakie nowe funkcje wprowadzono w PHP 8 dla programowania obiektowego?"
        answerRepository.save(new Answer(-889L, "PHP 8 wprowadza nową funkcję do automatycznego generowania klas.", false, questionRepository.getById(-852L)));
        answerRepository.save(new Answer(-890L, "PHP 8 wprowadza atrybuty, które umożliwiają dodawanie meta-danych do klas, metod i właściwości.", true, questionRepository.getById(-852L)));
        answerRepository.save(new Answer(-891L, "PHP 8 wprowadza nową funkcję do automatycznego zarządzania pamięcią.", false, questionRepository.getById(-852L)));
        answerRepository.save(new Answer(-892L, "PHP 8 wprowadza nowe typy zmiennych.", false, questionRepository.getById(-852L)));

        // Odpowiedzi dla pytania: "Co to jest Ruby i do czego jest używany?"
        answerRepository.save(new Answer(-903L, "Ruby to framework do tworzenia aplikacji mobilnych.", false, questionRepository.getById(-893L)));
        answerRepository.save(new Answer(-904L, "Ruby to narzędzie do analizy danych.", false, questionRepository.getById(-893L)));
        answerRepository.save(new Answer(-905L, "Ruby to język programowania ogólnego przeznaczenia, używany głównie do tworzenia aplikacji internetowych.", true, questionRepository.getById(-893L)));
        answerRepository.save(new Answer(-906L, "Ruby to system zarządzania bazami danych.", false, questionRepository.getById(-893L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe typy danych w Ruby?"
        answerRepository.save(new Answer(-908L, "Ruby używa tylko typów tekstowych i całkowitoliczbowych.", false, questionRepository.getById(-894L)));
        answerRepository.save(new Answer(-909L, "Ruby nie posiada wbudowanych typów danych.", false, questionRepository.getById(-894L)));
        answerRepository.save(new Answer(-910L, "W Ruby każdy typ danych jest typem obiektowym.", false, questionRepository.getById(-894L)));
        answerRepository.save(new Answer(-907L, "Typy danych w Ruby to między innymi: Fixnum, String, Array.", true, questionRepository.getById(-894L)));

        // Odpowiedzi dla pytania: "Jak zadeklarować zmienną w Ruby?"
        answerRepository.save(new Answer(-911L, "Zmienna w Ruby jest deklarowana przez słowo kluczowe var, np. var x = 10;", false, questionRepository.getById(-895L)));
        answerRepository.save(new Answer(-912L, "W Ruby zmienne deklaruje się bez słów kluczowych, np. x = 10;", true, questionRepository.getById(-895L)));
        answerRepository.save(new Answer(-913L, "Zmienną w Ruby deklaruje się używając typu, np. int x = 10;", false, questionRepository.getById(-895L)));
        answerRepository.save(new Answer(-914L, "W Ruby wszystkie zmienne są stałe i nie można ich zmieniać po deklaracji.", false, questionRepository.getById(-895L)));

        // Odpowiedzi dla pytania: "Co to są tablice w Ruby i jak się je definiuje?"
        answerRepository.save(new Answer(-915L, "Tablice w Ruby definiuje się używając klamr {}, np. x = {1, 2, 3};", false, questionRepository.getById(-896L)));
        answerRepository.save(new Answer(-916L, "Tablice w Ruby definiuje się używając nawiasów [], np. x = [1, 2, 3];", true, questionRepository.getById(-896L)));
        answerRepository.save(new Answer(-917L, "W Ruby tablice są definiowane przez słowo kluczowe array, np. array x = 1, 2, 3;", false, questionRepository.getById(-896L)));
        answerRepository.save(new Answer(-918L, "Ruby nie obsługuje tablic w sposób bezpośredni, używa się do tego list.", false, questionRepository.getById(-896L)));

        // Odpowiedzi dla pytania: "Jakie są różnice między zmiennymi lokalnymi a globalnymi w Ruby?"
        answerRepository.save(new Answer(-919L, "Zmienne lokalne i globalne nie różnią się w Ruby.", false, questionRepository.getById(-897L)));
        answerRepository.save(new Answer(-920L, "W Ruby zmienne lokalne są dostępne tylko wewnątrz funkcji, a globalne w całym programie.", true, questionRepository.getById(-897L)));
        answerRepository.save(new Answer(-921L, "Zmienne lokalne w Ruby muszą być zadeklarowane z prefiksem $, a globalne bez.", false, questionRepository.getById(-897L)));
        answerRepository.save(new Answer(-922L, "Ruby nie rozróżnia zmiennych lokalnych i globalnych; wszystkie zmienne są globalne.", false, questionRepository.getById(-897L)));

        // Odpowiedzi dla pytania: "Jak zdefiniować metodę w Ruby?"
        answerRepository.save(new Answer(-923L, "Metodę w Ruby definiuje się używając słowa kluczowego function, np. function nazwa_metody.", false, questionRepository.getById(-898L)));
        answerRepository.save(new Answer(-924L, "Metodę w Ruby definiuje się przez prefiks def, np. def nazwa_metody.", true, questionRepository.getById(-898L)));
        answerRepository.save(new Answer(-925L, "Ruby używa słowa kluczowego method do definiowania metod, np. method nazwa_metody.", false, questionRepository.getById(-898L)));
        answerRepository.save(new Answer(-926L, "Metody w Ruby są zawsze anonimowe i nie mogą być nazwane.", false, questionRepository.getById(-898L)));

        // Odpowiedzi dla pytania: "Co to są bloki w Ruby i jak się je używa?"
        answerRepository.save(new Answer(-927L, "Bloki w Ruby to specjalne konstrukcje służące do obsługi wyjątków.", false, questionRepository.getById(-899L)));
        answerRepository.save(new Answer(-928L, "Bloki w Ruby to fragmenty kodu otoczone klamrami {}, które mogą być przekazane do metod.", false, questionRepository.getById(-899L)));
        answerRepository.save(new Answer(-929L, "Bloki w Ruby to anonimowe funkcje, które mogą być przekazywane do metod i wywoływane z argumentami.", true, questionRepository.getById(-899L)));
        answerRepository.save(new Answer(-930L, "Ruby nie wspiera bloków kodu, wszystkie operacje muszą być zdefiniowane w metodach.", false, questionRepository.getById(-899L)));

        // Odpowiedzi dla pytania: "Jakie są metody iteracji w Ruby?"
        answerRepository.save(new Answer(-931L, "Metody iteracji w Ruby obejmują pętle typu for i while.", false, questionRepository.getById(-900L)));
        answerRepository.save(new Answer(-932L, "Ruby używa tylko funkcji rekurencyjnych do iteracji, bez wbudowanych metod iteracji.", false, questionRepository.getById(-900L)));
        answerRepository.save(new Answer(-933L, "W Ruby metody iteracji to głównie each, map i select.", true, questionRepository.getById(-900L)));
        answerRepository.save(new Answer(-934L, "Iteracja w Ruby jest możliwa tylko przez bezpośrednie indeksowanie tablic i kolekcji.", false, questionRepository.getById(-900L)));

        // Odpowiedzi dla pytania: "Co to jest symbol w Ruby i do czego służy?"
        answerRepository.save(new Answer(-935L, "Symbol w Ruby to specjalny typ zmiennej używany do optymalizacji pamięci.", false, questionRepository.getById(-901L)));
        answerRepository.save(new Answer(-936L, "Symbol to typ danych podobny do stringa, ale jest niezmienialny i unikalnie identyfikowany w całym programie.", true, questionRepository.getById(-901L)));
        answerRepository.save(new Answer(-937L, "Symbol w Ruby to funkcja służąca do generowania losowych ciągów znaków.", false, questionRepository.getById(-901L)));
        answerRepository.save(new Answer(-938L, "Symbol to złożony typ danych używany do przechowywania dużych ilości danych.", false, questionRepository.getById(-901L)));

        // Odpowiedzi dla pytania: "Jakie są podstawowe różnice między Ruby a innymi językami programowania, takimi jak Python lub JavaScript?"
        answerRepository.save(new Answer(-939L, "Ruby, w przeciwieństwie do Pythona i JavaScriptu, nie obsługuje programowania asynchronicznego.", false, questionRepository.getById(-902L)));
        answerRepository.save(new Answer(-941L, "Ruby nie pozwala na przeciążanie funkcji, podczas gdy Python i JavaScript to obsługują.", false, questionRepository.getById(-902L)));
        answerRepository.save(new Answer(-942L, "Ruby jest kompilowany, podczas gdy Python i JavaScript są interpretowane.", false, questionRepository.getById(-902L)));
        answerRepository.save(new Answer(-940L, "W Ruby, w przeciwieństwie do Pythona i JavaScriptu, wszystko jest obiektem, włącznie z liczbami i innymi podstawowymi typami danych.", true, questionRepository.getById(-902L)));

        // Odpowiedzi dla pytania: "Co to jest Ruby on Rails i jakie są jego główne założenia?"
        answerRepository.save(new Answer(-951L, "Ruby on Rails to biblioteka JavaScript.", false, questionRepository.getById(-941L)));
        answerRepository.save(new Answer(-952L, "Ruby on Rails to framework do tworzenia dynamicznych stron internetowych oparty na Ruby.", true, questionRepository.getById(-941L)));
        answerRepository.save(new Answer(-953L, "Ruby on Rails to narzędzie do analizy danych.", false, questionRepository.getById(-941L)));
        answerRepository.save(new Answer(-954L, "Ruby on Rails to system zarządzania treścią.", false, questionRepository.getById(-941L)));

        // Odpowiedzi dla pytania: "Jakie wzorce projektowe są najczęściej stosowane w Ruby on Rails?"
        answerRepository.save(new Answer(-955L, "Singleton i Factory.", false, questionRepository.getById(-942L)));
        answerRepository.save(new Answer(-956L, "Model-View-Controller (MVC).", true, questionRepository.getById(-942L)));
        answerRepository.save(new Answer(-957L, "Prototype i Observer.", false, questionRepository.getById(-942L)));
        answerRepository.save(new Answer(-958L, "Command i Adapter.", false, questionRepository.getById(-942L)));

        // Odpowiedzi dla pytania: "Jakie są zasady konwencji nad konfiguracją w Ruby on Rails?"
        answerRepository.save(new Answer(-959L, "Wszystkie elementy aplikacji muszą być skonfigurowane ręcznie.", false, questionRepository.getById(-943L)));
        answerRepository.save(new Answer(-960L, "Kod jest pisany bez konieczności konfiguracji, z zastosowaniem rozsądnych domyślnych ustawień.", true, questionRepository.getById(-943L)));
        answerRepository.save(new Answer(-961L, "Konfiguracja jest generowana automatycznie przez narzędzia.", false, questionRepository.getById(-943L)));
        answerRepository.save(new Answer(-962L, "Użytkownik musi śledzić wszystkie zmiany w konfiguracji ręcznie.", false, questionRepository.getById(-943L)));

        // Odpowiedzi dla pytania: "Co to są migracje w kontekście Ruby on Rails i jak są wykorzystywane?"
        answerRepository.save(new Answer(-963L, "Migracje to skrypty SQL używane do ręcznego zarządzania bazą danych.", false, questionRepository.getById(-944L)));
        answerRepository.save(new Answer(-964L, "Migracje to klasy w Ruby, które służą do efektywnego zarządzania zmianami schematu bazy danych.", true, questionRepository.getById(-944L)));
        answerRepository.save(new Answer(-965L, "Migracje to technika przenoszenia aplikacji między różnymi środowiskami.", false, questionRepository.getById(-944L)));
        answerRepository.save(new Answer(-966L, "Migracje są używane do przesyłania danych między różnymi wersjami aplikacji.", false, questionRepository.getById(-944L)));

        // Odpowiedzi dla pytania: "Jak działa system routingu w Ruby on Rails?"
        answerRepository.save(new Answer(-967L, "Routing w Railsach jest oparty na konfiguracji XML.", false, questionRepository.getById(-945L)));
        answerRepository.save(new Answer(-968L, "Routing opiera się na zasadach zapisywanych w plikach konfiguracyjnych.", false, questionRepository.getById(-945L)));
        answerRepository.save(new Answer(-969L, "System routingu łączy przychodzące żądania URL z kontrolerami i akcjami.", true, questionRepository.getById(-945L)));
        answerRepository.save(new Answer(-970L, "Routing jest zarządzany przez zewnętrzne serwery proxy.", false, questionRepository.getById(-945L)));

        // Odpowiedzi dla pytania: "Co to jest ActiveRecord w Ruby on Rails i jakie ma zastosowanie?"
        answerRepository.save(new Answer(-971L, "ActiveRecord to system cache'owania w Railsach.", false, questionRepository.getById(-946L)));
        answerRepository.save(new Answer(-972L, "ActiveRecord to biblioteka ORM, która pozwala na reprezentację tabel baz danych jako klasy Ruby.", true, questionRepository.getById(-946L)));
        answerRepository.save(new Answer(-973L, "ActiveRecord to framework do tworzenia interfejsów użytkownika.", false, questionRepository.getById(-946L)));
        answerRepository.save(new Answer(-974L, "ActiveRecord to narzędzie do zarządzania migracjami baz danych.", false, questionRepository.getById(-946L)));

        // Odpowiedzi dla pytania: "Jak w Ruby on Rails wykorzystywane są widoki i jak można je modyfikować?"
        answerRepository.save(new Answer(-975L, "Widoki w Railsach są statyczne i nie mogą być modyfikowane.", false, questionRepository.getById(-947L)));
        answerRepository.save(new Answer(-976L, "Widoki są definiowane w HTML i mogą być dynamicznie modyfikowane za pomocą JavaScript.", false, questionRepository.getById(-947L)));
        answerRepository.save(new Answer(-977L, "Widoki są zapisywane jako pliki .html.erb, które mogą zawierać kod Ruby do generowania dynamicznej zawartości.", true, questionRepository.getById(-947L)));
        answerRepository.save(new Answer(-978L, "Widoki w Railsach są zarządzane przez osobny framework.", false, questionRepository.getById(-947L)));

        // Odpowiedzi dla pytania: "Jakie są metody optymalizacji wydajności aplikacji w Ruby on Rails?"
        answerRepository.save(new Answer(-979L, "Główne metody to używanie więcej JavaScriptu w aplikacji.", false, questionRepository.getById(-948L)));
        answerRepository.save(new Answer(-980L, "Optymalizacja obejmuje cachowanie, eager loading oraz redukcję n+1 zapytań.", true, questionRepository.getById(-948L)));
        answerRepository.save(new Answer(-981L, "Rails nie oferuje metodyk optymalizacji wydajności.", false, questionRepository.getById(-948L)));
        answerRepository.save(new Answer(-982L, "Użycie przestarzałych gemów dla lepszej kompatybilności.", false, questionRepository.getById(-948L)));

        // Odpowiedzi dla pytania: "Jak obsługuje się błędy i wyjątki w Ruby on Rails?"
        answerRepository.save(new Answer(-983L, "Błędy są ignorowane domyślnie w środowisku produkcyjnym.", false, questionRepository.getById(-949L)));
        answerRepository.save(new Answer(-984L, "Wyjątki w Railsach są obsługiwane przez automatyczne logowanie i powiadomienia e-mail.", false, questionRepository.getById(-949L)));
        answerRepository.save(new Answer(-985L, "Rails oferuje wbudowane mechanizmy do obsługi błędów, takie jak rescue_from.", true, questionRepository.getById(-949L)));
        answerRepository.save(new Answer(-986L, "Rails używa zewnętrznych narzędzi do obsługi błędów, które muszą być zainstalowane osobno.", false, questionRepository.getById(-949L)));

        // Odpowiedzi dla pytania: "Jakie są najlepsze praktyki związane z testowaniem aplikacji w Ruby on Rails?"
        answerRepository.save(new Answer(-987L, "Testowanie jest opcjonalne i zalecane tylko dla dużych aplikacji.", false, questionRepository.getById(-950L)));
        answerRepository.save(new Answer(-988L, "Rails promuje TDD (Test Driven Development) i używa RSpec, MiniTest dla testowania.", true, questionRepository.getById(-950L)));
        answerRepository.save(new Answer(-989L, "Najlepszą praktyką jest unikanie testów jednostkowych na rzecz testów integracyjnych.", false, questionRepository.getById(-950L)));
        answerRepository.save(new Answer(-990L, "Testy powinny być pisane tylko po zakończeniu projektu.", false, questionRepository.getById(-950L)));
    }
}
