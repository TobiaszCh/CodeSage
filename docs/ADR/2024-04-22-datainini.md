# Adnotacje @Profile i @PostConstruct

Status:
Zaproponowany

Kontekst: Praca na danych powoduje wzrost ilości plików xml (zwanymi "changSetami"). Dane są wprowadzane za pomocą narzędzia liquibase.
Nie jest to najlepsza metoda do takich operacji.

Decyzja: Wprowadzone zostają nowe klasy inicjalizujące dane do każdej z encji. Każda z tych klas zawierać będzie nowe adnotacje takie jak:
@PostConstruct, @DependsOn oraz @Profile. Jeżeli metoda się sprawdzi w przyszłości zostaną usunięte changSety które były odowiedzialne za
wpowadzanie danych na serwer.

Konsekwencje:
- wprowadzenie adnotacji @Profile spowodowało, że w zależności od środowiska w którym pracujemy dana klasa będzie uruchamiana w aplikacji lub
też nie.
- wprowadzenie adnotacji @PostConstruct powoduje uruchomienie metody w trakcie tworzenia beanów (przed działaniem aplikacji) co powoduje
inicjazlizacje danych do serwera
- wprowadzenie adnotacji @DependsOn daje nam kontrole nad tworzeniem beanów w odpowiedniej kolejności. Nie może być takiej
sytuacji gdzie najpierw zostaną zainicjalizowane dane do Answer potem do Course. Takie operacje nie zostaną wykonane.
- wpowadzenie nowych klas inicjalizujących ułatwia prace z danymi. W łatwy sposób można pracować bez potrzeby 
ciągłych zmian i tworzenia nowych plików xmlowych (nie wspominając już o operacjach których liquibase nie pozwala wykonać
bez wprowadzenia wymaganych czynności). Na tym etapie rozwoju aplikacji jest nam potrzebna szybka i sprawna praca z danymi.