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
        //Klasy - Java
        questionRepository.save(new Question(-18L, "Czym jest klasa w Javie?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-19L, "Jaką funkcję pełnią atrybuty w Klasie?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-20L, "Czym jest konstruktor w Javie?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-34L, "Które słowo kluczowe służy do definiowania nowej klasy w języku Java?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-35L, "Które słowo kluczowe oznacza, że metoda nie zwraca żadnej wartości?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-36L, "Jak oznacza się dziedziczenie między klasami w języku Java?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-37L, "Które z poniższych jest przykładem enkapsulacji w języku Java?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-38L, "Które z poniższych słów kluczowych służy do zapobiegania dziedziczeniu klasy w Javie?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-39L, "Co oznacza koncepcja polimorfizmu w programowaniu obiektowym?", subjectRepository.getById(-9L)));
        questionRepository.save(new Question(-40L, "Które słowo kluczowe jest używane do oznaczania metody, która może być zaimplementowana w klasach potomnych?", subjectRepository.getById(-9L)));

        //Klasy abstrakcyjne - Java
        questionRepository.save(new Question(-70L, "Co charakteryzuje klasę abstrakcyjną w Javie?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-71L, "Która z poniższych metod jest poprawnym przykładem metody abstrakcyjnej w klasie abstrakcyjnej?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-72L, "Dlaczego klasy abstrakcyjne są użyteczne w programowaniu obiektowym?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-73L, "Co się stanie, jeśli klasa dziedziczy po klasie abstrakcyjnej i nie implementuje wszystkich jej metod abstrakcyjnych?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-74L, "Czy klasa abstrakcyjna może zawierać pola statyczne?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-75L, "Czy klasa abstrakcyjna może implementować interfejs?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-76L, "Jaka jest różnica między klasą abstrakcyjną a interfejsem w Javie?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-77L, "Czy klasa abstrakcyjna może zawierać metody prywatne?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-78L, "Jakie jest główne zastosowanie klas abstrakcyjnych?", subjectRepository.getById(-10L)));
        questionRepository.save(new Question(-79L, "Czy klasa abstrakcyjna może mieć konstruktory?", subjectRepository.getById(-10L)));

        //Podstawy Python - Python
        questionRepository.save(new Question(-193L, "Jak zainstalować Pythona na swoim komputerze?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-194L, "Jak uruchomić skrypt Pythona z linii komend?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-195L, "Co to jest zmienna w Pythonie i jak ją zdefiniować?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-196L, "Jakie są podstawowe typy danych w Pythonie?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-197L, "Jak stworzyć listę w Pythonie i jak dodawać do niej elementy?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-198L, "Jak działa instrukcja warunkowa if w Pythonie?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-199L, "Co to są pętle w Pythonie i jakie są ich rodzaje?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-200L, "Jak zdefiniować funkcję w Pythonie?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-201L, "Co to są moduły w Pythonie i jak je importować?", subjectRepository.getById(-120L)));
        questionRepository.save(new Question(-202L, "Jakie są metody manipulacji ciągami znaków w Pythonie?", subjectRepository.getById(-120L)));

        //Obiektowość-Python
        questionRepository.save(new Question(-243L, "Co to jest klasa w Pythonie?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-244L, "Jak tworzyć instancje klasy w Pythonie?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-245L, "Co to jest dziedziczenie w kontekście klas w Pythonie?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-246L, "Jak definiuje się metodę w klasie Pythona?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-247L, "Co to jest konstruktor klasy w Pythonie i jak go zdefiniować?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-248L, "Jak można zmodyfikować atrybuty instancji klasy w Pythonie?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-249L, "Co to jest polimorfizm w Pythonie?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-250L, "Jak użyć hermetyzacji w klasach Pythona?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-251L, "Jakie są metody specjalne klasy w Pythonie i do czego służą?", subjectRepository.getById(-125L)));
        questionRepository.save(new Question(-252L, "Jak można zaimplementować dziedziczenie wielokrotne w Pythonie?", subjectRepository.getById(-125L)));

        //Wprowadzenie do TypeScript - TypeScript
        questionRepository.save(new Question(-293L, "Co to jest TypeScript i do czego służy?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-294L, "Jakie są główne różnice między TypeScript a JavaScript?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-295L, "Co to są typy w TypeScript i jak są używane?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-296L, "Jak zadeklarować zmienną w TypeScript?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-297L, "Jakie są zalety używania TypeScript w dużych projektach?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-298L, "Jak TypeScript wspiera programowanie obiektowe?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-299L, "Jak można zdefiniować interfejs w TypeScript?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-300L, "Jakie są różnice między interfejsami a klasami w TypeScript?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-301L, "Jak TypeScript obsługuje typy generyczne?", subjectRepository.getById(-129L)));
        questionRepository.save(new Question(-302L, "Jak skonfigurować środowisko dla TypeScript?", subjectRepository.getById(-129L)));

        //Integracja z JavaScript - TypeScript
        questionRepository.save(new Question(-343L, "Jakie są podstawowe sposoby integracji TypeScript z JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-344L, "Czy można wykorzystać biblioteki JavaScript w projektach TypeScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-345L, "Jakie są różnice w obsłudze błędów pomiędzy JavaScript a TypeScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-346L, "Jak TypeScript wpływa na wydajność aplikacji JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-347L, "Czy TypeScript wymaga transpilacji do JavaScript przed uruchomieniem w przeglądarce?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-348L, "Jak korzystać z plików definicji typów w TypeScript dla bibliotek JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-349L, "Jakie są najlepsze praktyki przy mieszaniu kodu TypeScript i JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-350L, "Jak narzędzia deweloperskie wspierają integrację TypeScript z JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-351L, "Jakie są zalety używania TypeScript w istniejących projektach JavaScript?", subjectRepository.getById(-137L)));
        questionRepository.save(new Question(-352L, "Jakie są wyzwania związane z integracją TypeScript i JavaScript w dużych projektach?", subjectRepository.getById(-137L)));

        //Podstawy JavaScript - JavaScript
        questionRepository.save(new Question(-393L, "Co to jest JavaScript i w jakim celu jest używany?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-394L, "Jakie są typy danych dostępne w JavaScript?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-395L, "Jak stworzyć zmienną w JavaScript?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-396L, "Jakie są różnice między var, let i const w JavaScript?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-397L, "Co to jest funkcja w JavaScript i jak ją zdefiniować?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-398L, "Jak działają pętle w JavaScript, jakie są ich rodzaje?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-399L, "Co to jest obiekt w JavaScript i jak można go stworzyć?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-400L, "Jakie są metody manipulacji DOM w JavaScript?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-401L, "Jak obsługiwać zdarzenia w JavaScript?", subjectRepository.getById(-138L)));
        questionRepository.save(new Question(-402L, "Co to jest JSON i jak jest używany w JavaScript?", subjectRepository.getById(-138L)));

        //Frameworki i biblioteki JavaScript - JavaScript
        questionRepository.save(new Question(-443L, "Co to jest jQuery i do czego jest używane?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-444L, "Jakie są główne cechy frameworka Angular?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-445L, "Na czym polega główna różnica między Angular a React?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-446L, "Co to jest Vue.js i jakie ma zastosowania?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-447L, "Jakie są zalety używania React w projektach webowych?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-448L, "Co to jest Node.js i jak jest używane?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-449L, "Jakie biblioteki JavaScript służą do tworzenia animacji?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-450L, "Co charakteryzuje framework Ember.js?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-451L, "W jaki sposób TypeScript współpracuje z frameworkami JavaScript?", subjectRepository.getById(-146L)));
        questionRepository.save(new Question(-452L, "Jakie są różnice w zarządzaniu stanem w React i Vue?", subjectRepository.getById(-146L)));

        //Wprowadzenie do React i JSX - React
        questionRepository.save(new Question(-493L, "Co to jest React i kto jest jego twórcą?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-494L, "Co to jest JSX i jak jest używany w React?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-495L, "Jakie są zalety używania React w porównaniu z tradycyjnymi podejściami do budowy interfejsów użytkownika?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-496L, "Co to są komponenty w React i jakie są ich rodzaje?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-497L, "Jak działa stan (state) w komponentach React?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-498L, "Co to są propsy (props) w React i do czego są używane?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-499L, "Jak można zarządzać stanem aplikacji w React bez użycia zewnętrznych bibliotek?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-500L, "Jakie są różnice między klasowymi a funkcyjnymi komponentami w React?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-501L, "Jakie są najpopularniejsze narzędzia i biblioteki używane z React?", subjectRepository.getById(-147L)));
        questionRepository.save(new Question(-502L, "Jakie są najlepsze praktyki dotyczące optymalizacji wydajności aplikacji React?", subjectRepository.getById(-147L)));

        //Optmalizacja wydajności, Lazy Loading - React
        questionRepository.save(new Question(-543L, "Co to jest optymalizacja wydajności w kontekście rozwoju webowego?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-544L, "Jakie są ogólne techniki optymalizacji wydajności stron internetowych?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-545L, "Co to jest 'Lazy Loading' i jak wpływa na wydajność strony?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-546L, "Jakie są zalety stosowania Lazy Loading w aplikacjach webowych?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-547L, "Jak można zaimplementować Lazy Loading w JavaScript?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-548L, "Jakie narzędzia można użyć do analizy wydajności strony internetowej?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-549L, "Jakie są najlepsze praktyki w optymalizacji renderowania strony?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-550L, "Jakie są różnice między optymalizacją na stronie klienta a serwerowej?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-551L, "Jak wpływa minifikacja zasobów na wydajność strony?", subjectRepository.getById(-155L)));
        questionRepository.save(new Question(-552L, "Jak technika Lazy Loading wpływa na SEO strony internetowej?", subjectRepository.getById(-155L)));

        //Podstawy Kotlina - Kotlin
        questionRepository.save(new Question(-593L, "Co to jest Kotlin i do czego jest używany?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-594L, "Jakie są główne cechy języka Kotlin?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-595L, "Jak Kotlin obsługuje nullability w porównaniu do Javy?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-596L, "Jak zadeklarować zmienną w Kotlinie?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-597L, "Jakie są różnice między 'val' a 'var' w Kotlinie?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-598L, "Jak zdefiniować funkcję w Kotlinie?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-599L, "Jak Kotlin obsługuje dziedziczenie?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-600L, "Co to są data classes w Kotlinie i do czego są używane?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-601L, "Jak w Kotlinie zaimplementować interfejs?", subjectRepository.getById(-156L)));
        questionRepository.save(new Question(-602L, "Jakie są zalety używania Kotlin Coroutines?", subjectRepository.getById(-156L)));

        //Zaawansowane funkcje języka Kotlin - Kotlin
        questionRepository.save(new Question(-643L, "Jak w Kotlinie używa się delegacji właściwości?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-644L, "Co to są funkcje rozszerzające w Kotlinie i jak można je zaimplementować?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-645L, "Jak działają wyrażenia lambda w Kotlinie i do czego są używane?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-646L, "Jakie są zalety stosowania sekwencji (sequences) w Kotlinie?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-647L, "Jak można zaimplementować wzorzec projektowy 'Singleton' w Kotlinie?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-648L, "Co to jest 'inline function' w Kotlinie i jakie przynosi korzyści?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-649L, "Jak Kotlin obsługuje wielowątkowość i jakie mechanizmy są do tego używane?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-650L, "Co to jest typ generyczny w Kotlinie i jakie ma zastosowania?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-651L, "Jak można użyć wzorca 'Decorator' w Kotlinie?", subjectRepository.getById(-164L)));
        questionRepository.save(new Question(-652L, "Co to jest rekursja ogonowa w Kotlinie i jak jest optymalizowana?", subjectRepository.getById(-164L)));

        //Podstawy C++ - C++
        questionRepository.save(new Question(-693L, "Co to jest C++ i do czego jest używany?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-694L, "Jakie są podstawowe typy danych w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-695L, "Jak zadeklarować zmienną w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-696L, "Co to są wskaźniki i jak się ich używa w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-697L, "Jakie są różnice między wskaźnikiem a referencją w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-698L, "Jak zdefiniować funkcję w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-699L, "Co to jest klasa w C++ i jak ją zdefiniować?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-700L, "Jak działa dziedziczenie w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-701L, "Co to jest konstruktor i destruktor w C++?", subjectRepository.getById(-165L)));
        questionRepository.save(new Question(-702L, "Jakie są podstawowe różnice między C++ a innymi językami programowania, takimi jak Python lub Java?", subjectRepository.getById(-165L)));

        // Nowości w C++20
        questionRepository.save(new Question(-743L, "Co to jest koncept (concept) w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-744L, "Jakie są główne cele wprowadzenia korutyn (coroutines) w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-745L, "Jak działa operator trójargumentowy (spaceship operator) w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-746L, "Co to jest zakres (range) w C++20 i jakie daje korzyści?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-747L, "Jakie są nowości w zarządzaniu pamięcią w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-748L, "Jakie zmiany wprowadzono w modułach (modules) w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-749L, "Czym są wyrażenia kontraktowe (contracts) w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-750L, "Jakie są usprawnienia w algorytmach w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-751L, "Jakie są nowe możliwości formatowania tekstu w C++20?", subjectRepository.getById(-173L)));
        questionRepository.save(new Question(-752L, "Jakie są zmiany w standardowej bibliotece C++ wprowadzone w C++20?", subjectRepository.getById(-173L)));

        // Podstawy PHP - PHP
        questionRepository.save(new Question(-793L, "Co to jest PHP i do czego jest używane?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-794L, "Jakie są podstawowe typy danych w PHP?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-795L, "Jak zadeklarować zmienną w PHP?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-796L, "Co to są tablice w PHP i jak się je definiuje?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-797L, "Jakie są różnice między zmiennymi lokalnymi a globalnymi w PHP?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-798L, "Jak zdefiniować funkcję w PHP?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-799L, "Co to są superglobalne tablice w PHP i jakie są ich przykłady?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-800L, "Jakie są metody obsługi formularzy w PHP?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-801L, "Co to jest sesja w PHP i jak ją rozpocząć?", subjectRepository.getById(-174L)));
        questionRepository.save(new Question(-802L, "Jakie są podstawowe funkcje do operacji na plikach w PHP?", subjectRepository.getById(-174L)));

        // Nowości w PHP 8 - PHP
        questionRepository.save(new Question(-843L, "Co to jest JIT (Just-In-Time) w PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-844L, "Jakie są główne korzyści z użycia JIT w PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-845L, "Co to są atrybuty w PHP 8 i jak są używane?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-846L, "Jakie nowe typy danych wprowadza PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-847L, "Co to jest operator Nullsafe w PHP 8 i jak działa?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-848L, "Jakie są zmiany w zarządzaniu błędami w PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-849L, "Jakie ulepszenia wprowadzono w zakresie typowania w PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-850L, "Co to jest Match Expression w PHP 8 i jak działa?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-851L, "Jakie są główne różnice między PHP 7 a PHP 8?", subjectRepository.getById(-182L)));
        questionRepository.save(new Question(-852L, "Jakie nowe funkcje wprowadzono w PHP 8 dla programowania obiektowego?", subjectRepository.getById(-182L)));

        //Podstawy Ruby - Ruby
        questionRepository.save(new Question(-893L, "Co to jest Ruby i do czego jest używany?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-894L, "Jakie są podstawowe typy danych w Ruby?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-895L, "Jak zadeklarować zmienną w Ruby?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-896L, "Co to są tablice w Ruby i jak się je definiuje?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-897L, "Jakie są różnice między zmiennymi lokalnymi a globalnymi w Ruby?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-898L, "Jak zdefiniować metodę w Ruby?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-899L, "Co to są bloki w Ruby i jak się je używa?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-900L, "Jakie są metody iteracji w Ruby?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-901L, "Co to jest symbol w Ruby i do czego służy?", subjectRepository.getById(-184L)));
        questionRepository.save(new Question(-902L, "Jakie są podstawowe różnice między Ruby a innymi językami programowania, takimi jak Python lub JavaScript?", subjectRepository.getById(-184L)));

        //Ruby on Rails - Ruby
        questionRepository.save(new Question(-941L, "Co to jest Ruby on Rails i jakie są jego główne założenia?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-942L, "Jakie wzorce projektowe są najczęściej stosowane w Ruby on Rails?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-943L, "Jakie są zasady konwencji nad konfiguracją w Ruby on Rails?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-944L, "Co to są migracje w kontekście Ruby on Rails i jak są wykorzystywane?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-945L, "Jak działa system routingu w Ruby on Rails?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-946L, "Co to jest ActiveRecord w Ruby on Rails i jakie ma zastosowanie?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-947L, "Jak w Ruby on Rails wykorzystywane są widoki i jak można je modyfikować?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-948L, "Jakie są metody optymalizacji wydajności aplikacji w Ruby on Rails?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-949L, "Jak obsługuje się błędy i wyjątki w Ruby on Rails?", subjectRepository.getById(-192L)));
        questionRepository.save(new Question(-950L, "Jakie są najlepsze praktyki związane z testowaniem aplikacji w Ruby on Rails?", subjectRepository.getById(-192L)));

    }
}
