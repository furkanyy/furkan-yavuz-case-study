[![SonarQube Cloud](https://sonarcloud.io/images/project_badges/sonarcloud-highlight.svg)](https://sonarcloud.io/summary/new_code?id=furkanyy_furkan-yavuz-case-study)


# case-study

This project is a sample Selenium test automation framework using Java, TestNG, and the Page Object Model (POM) design pattern.

## Features
- Page Object Model (POM) structure
- Supports Chrome and Firefox browsers
- Parameterized browser selection
- TestNG for test management

## Prerequisites
- Java 11 or higher
- Maven
- Chrome and/or Firefox browsers installed

## How to Run Tests

By default, tests run in Chrome. To run the tests:

```
mvn test
```

To run tests in **Firefox**:

```
mvn test -Dbrowser=firefox
```

To run tests in **Chrome** (explicitly):

```
mvn test -Dbrowser=chrome
```

## Browser Parameterization
- The browser type is controlled by the `browser` system property.
- Supported values: `chrome` (default), `firefox`
- Example: `-Dbrowser=firefox` for Firefox, `-Dbrowser=chrome` for Chrome

## Project Structure
- `src/main/java/com/example/automation/pages/` - Page Object classes
- `src/test/java/com/example/automation/tests/` - Test classes
- `pom.xml` - Maven configuration

---

Feel free to extend the framework or add more tests as needed! 
