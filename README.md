# Mockito Kata

## Introduction

This project is built with [Gradle](http://www.gradle.org/), but thanks to
used wrapper it is not needed to have Gradle installed manually in the system.

Simple build and test execution:

    ./gradlew check

(on Windows `gradlew.bat` should be used instead of `gradlew`)

## IDE integration

### Idea 13

Import to IntelliJ Idea 13: `File -> Import Project`.

### Idea 12

Import to IntelliJ Idea 12:

    ./gradlew idea

and later open generated `.ipr` file with `File -> Open`

### Eclipse

Import to Eclipse:

    ./gradlew eclipse

i later File -> Import -> Existing Project Into Workspace

## Dependencies

### General

Gradle can use interact with Maven repositories (including Central) and Ivy.
In order to introduce a new test dependency it is required to add a proper line
in `build.gradle`. For example:

        testCompile 'org.assertj:assertj-core:1.5.0'

For a dependency in a production scope ```testCompile``` should be replaced with ```compile```.

### IDE

To make a new dependency visible in IDE it is required to perform an additional action.

#### Idea 13

Gradle -> Refresh all Gradle projects

#### Idea 12

    ./gradlew ideaModule

#### Eclipse

    ./gradlew eclipseClasspath

## License

Author: [Marcin Zajączkowski](http://blog.solidsoft.info/). This code is available
under the terms of the [Apache license version 2.0](https://www.apache.org/licenses/LICENSE-2.0.txt).
