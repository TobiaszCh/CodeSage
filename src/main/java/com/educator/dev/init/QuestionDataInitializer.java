package com.educator.dev.init;
import com.educator.core.question.Question;
import com.educator.core.question.QuestionRepository;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("development")
@DependsOn("levelDataInitializer")
public class QuestionDataInitializer {

    private final QuestionRepository questionRepository;

    private final SubjectRepository subjectRepository;

    @PostConstruct
    public void initializeQuestionData () {
        // Klasy - Java
        questionRepository.save(Question.builder().id(-18L).displayName("Czym jest klasa w Javie?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-19L).displayName("Jaką funkcję pełnią atrybuty w Klasie?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-20L).displayName("Czym jest konstruktor w Javie?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-34L).displayName("Które słowo kluczowe służy do definiowania nowej klasy w języku Java?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-35L).displayName("Które słowo kluczowe oznacza, że metoda nie zwraca żadnej wartości?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-36L).displayName("Jak oznacza się dziedziczenie między klasami w języku Java?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-37L).displayName("Które z poniższych jest przykładem enkapsulacji w języku Java?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-38L).displayName("Które z poniższych słów kluczowych służy do zapobiegania dziedziczeniu klasy w Javie?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-39L).displayName("Co oznacza koncepcja polimorfizmu w programowaniu obiektowym?").subject(subjectRepository.getById(-9L)).build());
        questionRepository.save(Question.builder().id(-40L).displayName("Które słowo kluczowe jest używane do oznaczania metody, która może być zaimplementowana w klasach potomnych?").subject(subjectRepository.getById(-9L)).build());

        // Klasy abstrakcyjne - Java
        questionRepository.save(Question.builder().id(-70L).displayName("Co charakteryzuje klasę abstrakcyjną w Javie?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-71L).displayName("Która z poniższych metod jest poprawnym przykładem metody abstrakcyjnej w klasie abstrakcyjnej?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-72L).displayName("Dlaczego klasy abstrakcyjne są użyteczne w programowaniu obiektowym?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-73L).displayName("Co się stanie, jeśli klasa dziedziczy po klasie abstrakcyjnej i nie implementuje wszystkich jej metod abstrakcyjnych?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-74L).displayName("Czy klasa abstrakcyjna może zawierać pola statyczne?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-75L).displayName("Czy klasa abstrakcyjna może implementować interfejs?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-76L).displayName("Jaka jest różnica między klasą abstrakcyjną a interfejsem w Javie?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-77L).displayName("Czy klasa abstrakcyjna może zawierać metody prywatne?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-78L).displayName("Jakie jest główne zastosowanie klas abstrakcyjnych?").subject(subjectRepository.getById(-10L)).build());
        questionRepository.save(Question.builder().id(-79L).displayName("Czy klasa abstrakcyjna może mieć konstruktory?").subject(subjectRepository.getById(-10L)).build());

        // Podstawy Python - Python
        questionRepository.save(Question.builder().id(-193L).displayName("Jak zainstalować Pythona na swoim komputerze?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-194L).displayName("Jak uruchomić skrypt Pythona z linii komend?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-195L).displayName("Co to jest zmienna w Pythonie i jak ją zdefiniować?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-196L).displayName("Jakie są podstawowe typy danych w Pythonie?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-197L).displayName("Jak stworzyć listę w Pythonie i jak dodawać do niej elementy?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-198L).displayName("Jak działa instrukcja warunkowa if w Pythonie?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-199L).displayName("Co to są pętle w Pythonie i jakie są ich rodzaje?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-200L).displayName("Jak zdefiniować funkcję w Pythonie?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-201L).displayName("Co to są moduły w Pythonie i jak je importować?").subject(subjectRepository.getById(-120L)).build());
        questionRepository.save(Question.builder().id(-202L).displayName("Jakie są metody manipulacji ciągami znaków w Pythonie?").subject(subjectRepository.getById(-120L)).build());

        // Obiektowość-Python
        questionRepository.save(Question.builder().id(-243L).displayName("Co to jest klasa w Pythonie?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-244L).displayName("Jak tworzyć instancje klasy w Pythonie?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-245L).displayName("Co to jest dziedziczenie w kontekście klas w Pythonie?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-246L).displayName("Jak definiuje się metodę w klasie Pythona?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-247L).displayName("Co to jest konstruktor klasy w Pythonie i jak go zdefiniować?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-248L).displayName("Jak można zmodyfikować atrybuty instancji klasy w Pythonie?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-249L).displayName("Co to jest polimorfizm w Pythonie?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-250L).displayName("Jak użyć hermetyzacji w klasach Pythona?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-251L).displayName("Jakie są metody specjalne klasy w Pythonie i do czego służą?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-252L).displayName("Jak można zaimplementować dziedziczenie wielokrotne w Pythonie?").subject(subjectRepository.getById(-125L)).build());

        // Wprowadzenie do TypeScript - TypeScript
        questionRepository.save(Question.builder().id(-293L).displayName("Co to jest TypeScript i do czego służy?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-294L).displayName("Jakie są główne różnice między TypeScript a JavaScript?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-295L).displayName("Co to są typy w TypeScript i jak są używane?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-296L).displayName("Jak zadeklarować zmienną w TypeScript?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-297L).displayName("Jakie są zalety używania TypeScript w dużych projektach?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-298L).displayName("Jak TypeScript wspiera programowanie obiektowe?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-299L).displayName("Jak można zdefiniować interfejs w TypeScript?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-300L).displayName("Jakie są różnice między interfejsami a klasami w TypeScript?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-301L).displayName("Jak TypeScript obsługuje typy generyczne?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-302L).displayName("Jak skonfigurować środowisko dla TypeScript?").subject(subjectRepository.getById(-129L)).build());

        // Integracja z JavaScript - TypeScript
        questionRepository.save(Question.builder().id(-343L).displayName("Jakie są podstawowe sposoby integracji TypeScript z JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-344L).displayName("Czy można wykorzystać biblioteki JavaScript w projektach TypeScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-345L).displayName("Jakie są różnice w obsłudze błędów pomiędzy JavaScript a TypeScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-346L).displayName("Jak TypeScript wpływa na wydajność aplikacji JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-347L).displayName("Czy TypeScript wymaga transpilacji do JavaScript przed uruchomieniem w przeglądarce?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-348L).displayName("Jak korzystać z plików definicji typów w TypeScript dla bibliotek JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-349L).displayName("Jakie są najlepsze praktyki przy mieszaniu kodu TypeScript i JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-350L).displayName("Jak narzędzia deweloperskie wspierają integrację TypeScript z JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-351L).displayName("Jakie są zalety używania TypeScript w istniejących projektach JavaScript?").subject(subjectRepository.getById(-137L)).build());
        questionRepository.save(Question.builder().id(-352L).displayName("Jakie są wyzwania związane z integracją TypeScript i JavaScript w dużych projektach?").subject(subjectRepository.getById(-137L)).build());

        // Podstawy JavaScript - JavaScript
        questionRepository.save(Question.builder().id(-393L).displayName("Co to jest JavaScript i w jakim celu jest używany?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-394L).displayName("Jakie są typy danych dostępne w JavaScript?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-395L).displayName("Jak stworzyć zmienną w JavaScript?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-396L).displayName("Jakie są różnice między var, let i const w JavaScript?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-397L).displayName("Co to jest funkcja w JavaScript i jak ją zdefiniować?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-398L).displayName("Jak działają pętle w JavaScript, jakie są ich rodzaje?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-399L).displayName("Co to jest obiekt w JavaScript i jak można go stworzyć?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-400L).displayName("Jakie są metody manipulacji DOM w JavaScript?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-401L).displayName("Jak obsługiwać zdarzenia w JavaScript?").subject(subjectRepository.getById(-138L)).build());
        questionRepository.save(Question.builder().id(-402L).displayName("Co to jest JSON i jak jest używany w JavaScript?").subject(subjectRepository.getById(-138L)).build());

        // Frameworki i biblioteki JavaScript - JavaScript
        questionRepository.save(Question.builder().id(-443L).displayName("Co to jest jQuery i do czego jest używane?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-444L).displayName("Jakie są główne cechy frameworka Angular?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-445L).displayName("Na czym polega główna różnica między Angular a React?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-446L).displayName("Co to jest Vue.js i jakie ma zastosowania?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-447L).displayName("Jakie są zalety używania React w projektach webowych?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-448L).displayName("Co to jest Node.js i jak jest używane?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-449L).displayName("Jakie biblioteki JavaScript służą do tworzenia animacji?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-450L).displayName("Co charakteryzuje framework Ember.js?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-451L).displayName("W jaki sposób TypeScript współpracuje z frameworkami JavaScript?").subject(subjectRepository.getById(-146L)).build());
        questionRepository.save(Question.builder().id(-452L).displayName("Jakie są różnice w zarządzaniu stanem w React i Vue?").subject(subjectRepository.getById(-146L)).build());

        // Wprowadzenie do React i JSX - React
        questionRepository.save(Question.builder().id(-493L).displayName("Co to jest React i kto jest jego twórcą?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-494L).displayName("Co to jest JSX i jak jest używany w React?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-495L).displayName("Jakie są zalety używania React w porównaniu z tradycyjnymi podejściami do budowy interfejsów użytkownika?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-496L).displayName("Co to są komponenty w React i jakie są ich rodzaje?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-497L).displayName("Jak działa stan (state) w komponentach React?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-498L).displayName("Co to są propsy (props) w React i do czego są używane?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-499L).displayName("Jak można zarządzać stanem aplikacji w React bez użycia zewnętrznych bibliotek?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-500L).displayName("Jakie są różnice między klasowymi a funkcyjnymi komponentami w React?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-501L).displayName("Jakie są najpopularniejsze narzędzia i biblioteki używane z React?").subject(subjectRepository.getById(-147L)).build());
        questionRepository.save(Question.builder().id(-502L).displayName("Jakie są najlepsze praktyki dotyczące optymalizacji wydajności aplikacji React?").subject(subjectRepository.getById(-147L)).build());

        // Optymalizacja wydajności, Lazy Loading - React
        questionRepository.save(Question.builder().id(-543L).displayName("Co to jest optymalizacja wydajności w kontekście rozwoju webowego?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-544L).displayName("Jakie są ogólne techniki optymalizacji wydajności stron internetowych?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-545L).displayName("Co to jest 'Lazy Loading' i jak wpływa na wydajność strony?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-546L).displayName("Jakie są zalety stosowania Lazy Loading w aplikacjach webowych?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-547L).displayName("Jak można zaimplementować Lazy Loading w JavaScript?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-548L).displayName("Jakie narzędzia można użyć do analizy wydajności strony internetowej?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-549L).displayName("Jakie są najlepsze praktyki w optymalizacji renderowania strony?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-550L).displayName("Jakie są różnice między optymalizacją na stronie klienta a serwerowej?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-551L).displayName("Jak wpływa minifikacja zasobów na wydajność strony?").subject(subjectRepository.getById(-155L)).build());
        questionRepository.save(Question.builder().id(-552L).displayName("Jak technika Lazy Loading wpływa na SEO strony internetowej?").subject(subjectRepository.getById(-155L)).build());

        // Podstawy Kotlin - Kotlin
        questionRepository.save(Question.builder().id(-593L).displayName("Co to jest Kotlin i do czego jest używany?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-594L).displayName("Jakie są główne cechy języka Kotlin?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-595L).displayName("Jak Kotlin obsługuje nullability w porównaniu do Javy?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-596L).displayName("Jak zadeklarować zmienną w Kotlinie?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-597L).displayName("Jakie są różnice między 'val' a 'var' w Kotlinie?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-598L).displayName("Jak zdefiniować funkcję w Kotlinie?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-599L).displayName("Jak Kotlin obsługuje dziedziczenie?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-600L).displayName("Co to są data classes w Kotlinie i do czego są używane?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-601L).displayName("Jak w Kotlinie zaimplementować interfejs?").subject(subjectRepository.getById(-156L)).build());
        questionRepository.save(Question.builder().id(-602L).displayName("Jakie są zalety używania Kotlin Coroutines?").subject(subjectRepository.getById(-156L)).build());

        // Zaawansowane funkcje języka Kotlin - Kotlin
        questionRepository.save(Question.builder().id(-643L).displayName("Jak w Kotlinie używa się delegacji właściwości?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-644L).displayName("Co to są funkcje rozszerzające w Kotlinie i jak można je zaimplementować?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-645L).displayName("Jak działają wyrażenia lambda w Kotlinie i do czego są używane?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-646L).displayName("Jakie są zalety stosowania sekwencji (sequences) w Kotlinie?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-647L).displayName("Jak można zaimplementować wzorzec projektowy 'Singleton' w Kotlinie?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-648L).displayName("Co to jest 'inline function' w Kotlinie i jakie przynosi korzyści?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-649L).displayName("Jak Kotlin obsługuje wielowątkowość i jakie mechanizmy są do tego używane?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-650L).displayName("Co to jest typ generyczny w Kotlinie i jakie ma zastosowania?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-651L).displayName("Jak można użyć wzorca 'Decorator' w Kotlinie?").subject(subjectRepository.getById(-164L)).build());
        questionRepository.save(Question.builder().id(-652L).displayName("Co to jest rekursja ogonowa w Kotlinie i jak jest optymalizowana?").subject(subjectRepository.getById(-164L)).build());

        // Podstawy C++ - C++
        questionRepository.save(Question.builder().id(-693L).displayName("Co to jest C++ i do czego jest używany?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-694L).displayName("Jakie są podstawowe typy danych w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-695L).displayName("Jak zadeklarować zmienną w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-696L).displayName("Co to są wskaźniki i jak się ich używa w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-697L).displayName("Jakie są różnice między wskaźnikiem a referencją w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-698L).displayName("Jak zdefiniować funkcję w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-699L).displayName("Co to jest klasa w C++ i jak ją zdefiniować?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-700L).displayName("Jak działa dziedziczenie w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-701L).displayName("Co to jest konstruktor i destruktor w C++?").subject(subjectRepository.getById(-165L)).build());
        questionRepository.save(Question.builder().id(-702L).displayName("Jakie są podstawowe różnice między C++ a innymi językami programowania, takimi jak Python lub Java?").subject(subjectRepository.getById(-165L)).build());

        // Nowości w C++20
        questionRepository.save(Question.builder().id(-743L).displayName("Co to jest koncept (concept) w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-744L).displayName("Jakie są główne cele wprowadzenia korutyn (coroutines) w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-745L).displayName("Jak działa operator trójargumentowy (spaceship operator) w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-746L).displayName("Co to jest zakres (range) w C++20 i jakie daje korzyści?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-747L).displayName("Jakie są nowości w zarządzaniu pamięcią w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-748L).displayName("Jakie zmiany wprowadzono w modułach (modules) w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-749L).displayName("Czym są wyrażenia kontraktowe (contracts) w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-750L).displayName("Jakie są usprawnienia w algorytmach w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-751L).displayName("Jakie są nowe możliwości formatowania tekstu w C++20?").subject(subjectRepository.getById(-173L)).build());
        questionRepository.save(Question.builder().id(-752L).displayName("Jakie są zmiany w standardowej bibliotece C++ wprowadzone w C++20?").subject(subjectRepository.getById(-173L)).build());

        // Podstawy PHP - PHP
        questionRepository.save(Question.builder().id(-793L).displayName("Co to jest PHP i do czego jest używane?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-794L).displayName("Jakie są podstawowe typy danych w PHP?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-795L).displayName("Jak zadeklarować zmienną w PHP?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-796L).displayName("Co to są tablice w PHP i jak się je definiuje?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-797L).displayName("Jakie są różnice między zmiennymi lokalnymi a globalnymi w PHP?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-798L).displayName("Jak zdefiniować funkcję w PHP?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-799L).displayName("Co to są superglobalne tablice w PHP i jakie są ich przykłady?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-800L).displayName("Jakie są metody obsługi formularzy w PHP?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-801L).displayName("Co to jest sesja w PHP i jak ją rozpocząć?").subject(subjectRepository.getById(-174L)).build());
        questionRepository.save(Question.builder().id(-802L).displayName("Jakie są podstawowe funkcje do operacji na plikach w PHP?").subject(subjectRepository.getById(-174L)).build());

        // Nowości w PHP 8 - PHP
        questionRepository.save(Question.builder().id(-843L).displayName("Co to jest JIT (Just-In-Time) w PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-844L).displayName("Jakie są główne korzyści z użycia JIT w PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-845L).displayName("Co to są atrybuty w PHP 8 i jak są używane?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-846L).displayName("Jakie nowe typy danych wprowadza PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-847L).displayName("Co to jest operator Nullsafe w PHP 8 i jak działa?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-848L).displayName("Jakie są zmiany w zarządzaniu błędami w PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-849L).displayName("Jakie ulepszenia wprowadzono w zakresie typowania w PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-850L).displayName("Co to jest Match Expression w PHP 8 i jak działa?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-851L).displayName("Jakie są główne różnice między PHP 7 a PHP 8?").subject(subjectRepository.getById(-182L)).build());
        questionRepository.save(Question.builder().id(-852L).displayName("Jakie nowe funkcje wprowadzono w PHP 8 dla programowania obiektowego?").subject(subjectRepository.getById(-182L)).build());

        // Podstawy Ruby - Ruby
        questionRepository.save(Question.builder().id(-893L).displayName("Co to jest Ruby i do czego jest używany?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-894L).displayName("Jakie są podstawowe typy danych w Ruby?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-895L).displayName("Jak zadeklarować zmienną w Ruby?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-896L).displayName("Co to są tablice w Ruby i jak się je definiuje?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-897L).displayName("Jakie są różnice między zmiennymi lokalnymi a globalnymi w Ruby?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-898L).displayName("Jak zdefiniować metodę w Ruby?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-899L).displayName("Co to są bloki w Ruby i jak się je używa?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-900L).displayName("Jakie są metody iteracji w Ruby?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-901L).displayName("Co to jest symbol w Ruby i do czego służy?").subject(subjectRepository.getById(-184L)).build());
        questionRepository.save(Question.builder().id(-902L).displayName("Jakie są podstawowe różnice między Ruby a innymi językami programowania, takimi jak Python lub JavaScript?").subject(subjectRepository.getById(-184L)).build());

        // Ruby on Rails - Ruby
        questionRepository.save(Question.builder().id(-941L).displayName("Co to jest Ruby on Rails i jakie są jego główne założenia?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-942L).displayName("Jakie wzorce projektowe są najczęściej stosowane w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-943L).displayName("Jakie są zasady konwencji nad konfiguracją w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-944L).displayName("Co to są migracje w kontekście Ruby on Rails i jak są wykorzystywane?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-945L).displayName("Jak działa system routingu w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-946L).displayName("Co to jest ActiveRecord w Ruby on Rails i jakie ma zastosowanie?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-947L).displayName("Jak w Ruby on Rails wykorzystywane są widoki i jak można je modyfikować?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-948L).displayName("Jakie są metody optymalizacji wydajności aplikacji w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-949L).displayName("Jak obsługuje się błędy i wyjątki w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());
        questionRepository.save(Question.builder().id(-950L).displayName("Jakie są najlepsze praktyki związane z testowaniem aplikacji w Ruby on Rails?").subject(subjectRepository.getById(-192L)).build());

        // Po jednym pytaniu do tematów javy - testowo
        questionRepository.save(Question.builder().id(-951L).displayName("Jak interfejsy wpływają na modularność i elastyczność kodu w aplikacjach Java?").subject(subjectRepository.getById(-11L)).build());
        questionRepository.save(Question.builder().id(-952L).displayName("W jaki sposób enumy zwiększają bezpieczeństwo typów i ułatwiają utrzymanie kodu?").subject(subjectRepository.getById(-12L)).build());
        questionRepository.save(Question.builder().id(-953L).displayName("Jak atrybuty mogą być wykorzystywane do przechowywania metadanych oraz modyfikacji zachowania aplikacji?").subject(subjectRepository.getById(-13L)).build());
        questionRepository.save(Question.builder().id(-954L).displayName("Jakie są różnice między metodami statycznymi a niestatycznymi oraz kiedy warto je stosować?").subject(subjectRepository.getById(-14L)).build());
        questionRepository.save(Question.builder().id(-955L).displayName("Jak adnotacje wpływają na konfigurację i działanie frameworków w aplikacjach Java?").subject(subjectRepository.getById(-15L)).build());
        questionRepository.save(Question.builder().id(-956L).displayName("Jakie typy kolekcji są najczęściej stosowane i jak wybrać odpowiednią do konkretnego zadania?").subject(subjectRepository.getById(-16L)).build());
        questionRepository.save(Question.builder().id(-957L).displayName("Jakie korzyści płyną ze stosowania funkcji wyższego rzędu w programowaniu funkcyjnym?").subject(subjectRepository.getById(-17L)).build());

        // Po jednym pytaniu do tematów TypeScript - testowo
        questionRepository.save(Question.builder().id(-958L).displayName("Jakie są główne typy danych dostępne w TypeScript i jak wpływają na bezpieczeństwo kodu?").subject(subjectRepository.getById(-129L)).build());
        questionRepository.save(Question.builder().id(-959L).displayName("Jakie są różnice między funkcjami strzałkowymi a tradycyjnymi funkcjami w TypeScript oraz jakie korzyści daje ich stosowanie?").subject(subjectRepository.getById(-130L)).build());
        questionRepository.save(Question.builder().id(-960L).displayName("W jaki sposób klasy i interfejsy w TypeScript współpracują, aby zapewnić silne typowanie i obiektowe podejście do programowania?").subject(subjectRepository.getById(-131L)).build());
        questionRepository.save(Question.builder().id(-961L).displayName("Jakie są różnice między modułami ES6 a przestrzeniami nazw w TypeScript i kiedy warto stosować jedno rozwiązanie zamiast drugiego?").subject(subjectRepository.getById(-132L)).build());
        questionRepository.save(Question.builder().id(-962L).displayName("Jak dekoratory w TypeScript mogą być wykorzystane do modyfikacji zachowania klas i metod oraz jakie są potencjalne wyzwania ich stosowania?").subject(subjectRepository.getById(-133L)).build());
        questionRepository.save(Question.builder().id(-963L).displayName("Jak programowanie generyczne w TypeScript umożliwia tworzenie elastycznych i wielokrotnego użytku komponentów?").subject(subjectRepository.getById(-134L)).build());
        questionRepository.save(Question.builder().id(-964L).displayName("Jakie zaawansowane typy i techniki, takie jak warunkowe typy czy typy indeksowane, mogą zwiększyć bezpieczeństwo i skalowalność aplikacji w TypeScript?").subject(subjectRepository.getById(-135L)).build());

        // Po jednym pytaniu do tematów Phyton - testowo
        questionRepository.save(Question.builder().id(-965L).displayName("Jakie są najlepsze praktyki związane z kontrolą przepływu w Pythonie oraz jak wpływają one na czytelność kodu?").subject(subjectRepository.getById(-121L)).build());
        questionRepository.save(Question.builder().id(-966L).displayName("W jaki sposób funkcje i moduły w Pythonie ułatwiają organizację kodu i wspierają ponowne użycie?").subject(subjectRepository.getById(-122L)).build());
        questionRepository.save(Question.builder().id(-967L).displayName("Jakie są kluczowe zasady obsługi wyjątków w Pythonie i jak można je skutecznie implementować?").subject(subjectRepository.getById(-123L)).build());
        questionRepository.save(Question.builder().id(-968L).displayName("Jakie metody pracy z plikami w Pythonie są najczęściej stosowane w projektach?").subject(subjectRepository.getById(-124L)).build());
        questionRepository.save(Question.builder().id(-969L).displayName("Jakie są podstawowe zasady programowania obiektowego w Pythonie i jakie korzyści płyną z ich stosowania?").subject(subjectRepository.getById(-125L)).build());
        questionRepository.save(Question.builder().id(-970L).displayName("Jakie biblioteki Python są najbardziej popularne i jakie mają zastosowania w różnych dziedzinach?").subject(subjectRepository.getById(-126L)).build());
        questionRepository.save(Question.builder().id(-971L).displayName("Jakie narzędzia i biblioteki Python są wykorzystywane do analizy danych oraz wizualizacji wyników?").subject(subjectRepository.getById(-127L)).build());

        // Po jednym pytaniu do tematów JavaScript - testowo
        questionRepository.save(Question.builder().id(-972L).displayName("Jak funkcje w JavaScript wpływają na zakres zmiennych oraz jakie zasady dotyczą hoistingu?").subject(subjectRepository.getById(-139L)).build());
        questionRepository.save(Question.builder().id(-973L).displayName("Jakie techniki obsługi wyjątków i błędów są najczęściej stosowane w JavaScript i jak wpływają na stabilność aplikacji?").subject(subjectRepository.getById(-140L)).build());
        questionRepository.save(Question.builder().id(-974L).displayName("Jakie są różnice między pracą z DOM a BOM w JavaScript i w jaki sposób wpływają one na manipulację stroną?").subject(subjectRepository.getById(-141L)).build());
        questionRepository.save(Question.builder().id(-975L).displayName("Jak asynchroniczność w JavaScript, np. poprzez Promises czy async/await, poprawia wydajność aplikacji?").subject(subjectRepository.getById(-142L)).build());
        questionRepository.save(Question.builder().id(-976L).displayName("Jakie mechanizmy obsługi zdarzeń w JavaScript są najczęściej wykorzystywane i jakie dają korzyści?").subject(subjectRepository.getById(-143L)).build());
        questionRepository.save(Question.builder().id(-977L).displayName("Jakie podejścia do programowania obiektowego w JavaScript umożliwiają tworzenie skalowalnych i modularnych aplikacji?").subject(subjectRepository.getById(-144L)).build());
        questionRepository.save(Question.builder().id(-978L).displayName("Jak nowoczesne API i interfejsy Webowe zmieniają interakcję użytkowników z aplikacjami internetowymi?").subject(subjectRepository.getById(-145L)).build());

        // Po jednym pytaniu do tematów React - testowo
        questionRepository.save(Question.builder().id(-979L).displayName("Jakie są główne różnice między komponentami klasowymi a funkcyjnymi w React oraz jakie korzyści płyną z ich stosowania?").subject(subjectRepository.getById(-148L)).build());
        questionRepository.save(Question.builder().id(-980L).displayName("Jakie techniki zarządzania stanem i cykl życia komponentów w React są najczęściej stosowane w praktyce?").subject(subjectRepository.getById(-149L)).build());
        questionRepository.save(Question.builder().id(-981L).displayName("W jaki sposób obsługa zdarzeń i formularzy w React różni się od tradycyjnych metod w JavaScript?").subject(subjectRepository.getById(-150L)).build());
        questionRepository.save(Question.builder().id(-982L).displayName("Jakie zalety daje użycie React Routera do routingu w aplikacjach React i jakie wyzwania mogą się pojawić?").subject(subjectRepository.getById(-151L)).build());
        questionRepository.save(Question.builder().id(-983L).displayName("Jakie są różnice między zarządzaniem stanem za pomocą Redux a Context API w React i kiedy warto stosować jedno z tych rozwiązań?").subject(subjectRepository.getById(-152L)).build());
        questionRepository.save(Question.builder().id(-984L).displayName("Jakie korzyści płyną ze stosowania hooków (Hooks) w React oraz jakie są najczęściej używane haki?").subject(subjectRepository.getById(-153L)).build());
        questionRepository.save(Question.builder().id(-985L).displayName("Jakie metody testowania komponentów React są najbardziej efektywne i jak wpływają na jakość aplikacji?").subject(subjectRepository.getById(-154L)).build());

        // Po jednym pytaniu do tematów Kotlin - testowo
        questionRepository.save(Question.builder().id(-986L).displayName("Jakie mechanizmy kontroli przepływu i rodzaje kolekcji w Kotlin wpływają na efektywność i czytelność kodu?").subject(subjectRepository.getById(-157L)).build());
        questionRepository.save(Question.builder().id(-987L).displayName("Jakie są zalety stosowania funkcji i wyrażeń lambda w Kotlin oraz jak przyczyniają się do zwięzłości kodu?").subject(subjectRepository.getById(-158L)).build());
        questionRepository.save(Question.builder().id(-988L).displayName("W jaki sposób klasy, obiekty i mechanizmy dziedziczenia w Kotlin wspierają programowanie obiektowe?").subject(subjectRepository.getById(-159L)).build());
        questionRepository.save(Question.builder().id(-989L).displayName("Jak Kotlin zapewnia bezpieczeństwo typów i obsługę nullability, eliminując ryzyko wystąpienia błędów NullPointerException?").subject(subjectRepository.getById(-160L)).build());
        questionRepository.save(Question.builder().id(-990L).displayName("Jakie cechy programowania funkcyjnego w Kotlin umożliwiają tworzenie bardziej zwięzłego i przejrzystego kodu?").subject(subjectRepository.getById(-161L)).build());
        questionRepository.save(Question.builder().id(-991L).displayName("Jak delegaty i properties w Kotlin ułatwiają zarządzanie stanem obiektów i implementację wzorców projektowych?").subject(subjectRepository.getById(-162L)).build());
        questionRepository.save(Question.builder().id(-992L).displayName("Jakie korzyści niesie wykorzystanie korutyn w Kotlin do obsługi współbieżności i jakie mogą wystąpić wyzwania przy ich implementacji?").subject(subjectRepository.getById(-163L)).build());

        // Po jednym pytaniu do tematów C++ - testowo
        questionRepository.save(Question.builder().id(-993L).displayName("Jakie są najlepsze praktyki definiowania obiektów i klas w C++ oraz jak wpływają na projektowanie oprogramowania?").subject(subjectRepository.getById(-166L)).build());
        questionRepository.save(Question.builder().id(-994L).displayName("Jak dziedziczenie i polimorfizm w C++ umożliwiają tworzenie elastycznych i skalowalnych hierarchii klas?").subject(subjectRepository.getById(-167L)).build());
        questionRepository.save(Question.builder().id(-995L).displayName("Jakie są korzyści wynikające z wykorzystania szablonów i metaprogramowania w C++ przy projektowaniu generycznych rozwiązań?").subject(subjectRepository.getById(-168L)).build());
        questionRepository.save(Question.builder().id(-996L).displayName("Jakie strategie zarządzania pamięcią w C++ pomagają unikać błędów i optymalizować wydajność aplikacji?").subject(subjectRepository.getById(-169L)).build());
        questionRepository.save(Question.builder().id(-997L).displayName("Jakie techniki obsługi wyjątków i błędów w C++ pozwalają na tworzenie bardziej niezawodnych aplikacji?").subject(subjectRepository.getById(-170L)).build());
        questionRepository.save(Question.builder().id(-998L).displayName("Jakie elementy Standardowej Biblioteki Szablonów (STL) są najczęściej wykorzystywane w projektach C++ i dlaczego?").subject(subjectRepository.getById(-171L)).build());
        questionRepository.save(Question.builder().id(-999L).displayName("Jakie mechanizmy współbieżności i wielowątkowości w C++ umożliwiają efektywne wykorzystanie zasobów sprzętowych?").subject(subjectRepository.getById(-172L)).build());

        // Po jednym pytaniu do tematów PHP - testowo
        questionRepository.save(Question.builder().id(-1000L).displayName("Jakie są najlepsze praktyki obsługi formularzy w PHP, aby zapewnić bezpieczeństwo i poprawność przesyłanych danych?").subject(subjectRepository.getById(-175L)).build());
        questionRepository.save(Question.builder().id(-1001L).displayName("Jakie są kluczowe aspekty pracy z bazami danych w PHP, uwzględniając optymalizację zapytań oraz zabezpieczenia przed SQL Injection?").subject(subjectRepository.getById(-176L)).build());
        questionRepository.save(Question.builder().id(-1002L).displayName("Jakie techniki i narzędzia można zastosować, aby zwiększyć bezpieczeństwo aplikacji PHP przed atakami?").subject(subjectRepository.getById(-177L)).build());
        questionRepository.save(Question.builder().id(-1003L).displayName("Jakie są najlepsze metody zarządzania sesjami i ciasteczkami w PHP, aby zapewnić funkcjonalność i bezpieczeństwo użytkowników?").subject(subjectRepository.getById(-178L)).build());
        questionRepository.save(Question.builder().id(-1004L).displayName("Jak obsługa wyjątków i błędów w PHP wpływa na stabilność aplikacji oraz jakie praktyki warto stosować?").subject(subjectRepository.getById(-179L)).build());
        questionRepository.save(Question.builder().id(-1005L).displayName("Jakie są zalety stosowania systemów szablonów w PHP i jak wpływają one na organizację oraz czytelność kodu?").subject(subjectRepository.getById(-180L)).build());
        questionRepository.save(Question.builder().id(-1006L).displayName("Jakie różnice występują między frameworkami PHP, takimi jak Laravel i Symfony, i kiedy warto zastosować jeden z nich?").subject(subjectRepository.getById(-181L)).build());

        // Po jednym pytaniu do tematów Ruby - testowo
        questionRepository.save(Question.builder().id(-1007L).displayName("Jakie są najlepsze praktyki definiowania obiektów i metod w Ruby, aby poprawić czytelność i modularność kodu?").subject(subjectRepository.getById(-185L)).build());
        questionRepository.save(Question.builder().id(-1008L).displayName("Jakie są główne zasady implementacji klas i dziedziczenia w Ruby oraz jak wpływają one na organizację kodu obiektowego?").subject(subjectRepository.getById(-186L)).build());
        questionRepository.save(Question.builder().id(-1009L).displayName("W jaki sposób moduły i mieszanki (mixins) w Ruby umożliwiają ponowne użycie kodu i ułatwiają jego modularizację?").subject(subjectRepository.getById(-187L)).build());
        questionRepository.save(Question.builder().id(-1010L).displayName("Jakie techniki zarządzania wyjątkami w Ruby zapewniają stabilność i niezawodność aplikacji?").subject(subjectRepository.getById(-188L)).build());
        questionRepository.save(Question.builder().id(-1011L).displayName("Jakie metody pracy z plikami oraz serializacji danych w Ruby są najczęściej stosowane w praktyce?").subject(subjectRepository.getById(-189L)).build());
        questionRepository.save(Question.builder().id(-1012L).displayName("Jakie korzyści i wyzwania niesie ze sobą metaprogramowanie w Ruby oraz jakie są najlepsze praktyki jego stosowania?").subject(subjectRepository.getById(-190L)).build());
        questionRepository.save(Question.builder().id(-1013L).displayName("Jakie narzędzia deweloperskie i metody testowania w Ruby przyczyniają się do podniesienia jakości kodu?").subject(subjectRepository.getById(-191L)).build());

    }
}
