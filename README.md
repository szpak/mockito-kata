# Mockito Kata

## Wprowadzenie

Projekt jest budowany z wykorzystaniem narzędzia [Gradle](http://www.gradle.org/), jednak dzięki zastosowaniu wrappera
nie jest konieczna jego wcześniejsza instalacja.

Proste zbudowanie i wykonanie testów:

    ./gradlew check

(na platformie Windows zamiast gradlew należy użyć gradlew.bat)

## Integracja z IDE

### Idea 13

Import do IntelliJ Idea 13: File -> Import Project.

### Idea 12

Import do IntelliJ Idea 12:

    ./gradlew idea

i potem otworzenie pliku .ipr przez File->Open

### Eclipse

Import do Eclipse:

    ./gradlew eclipse

i potem File -> Import -> Existing Project Into Workspace

## Dodawanie zależności

### Ogólnie

Gradle umie współpracować z repozytoriami Maven (w tym Central) oraz Ivy.
W celu wprowadzenia zależności należy dodać do pliku build.gradle linię z
żądanym artefaktem. Na przykład:

        testCompile 'org.assertj:assertj-core:1.5.0'

W celu dodania zależności o zasięgu prodykcyjnym (nie testowym) należy
zamiast ```testCompile``` użyć ```compile```.

### IDE

Aby zmiany były widoczne w IDE należy dokonać dodatkowych czynności.

#### Idea 13

Gradle -> Refresh all Gradle projects

#### Idea 12

    ./gradlew ideaModule

#### Eclipse

    ./gradlew eclipseClasspath

## Informacje licencyjne

Autor: [Marcin Zajączkowski](http://blog.solidsoft.info/). Kod jest dostępny na
[licencji Apache w wersji 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
