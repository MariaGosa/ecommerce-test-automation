# E-commerce Test Automation

UI test automation project for [SauceDemo](https://www.saucedemo.com/) built with Java, Selenium WebDriver, JUnit 5, and Maven.

The project demonstrates automated testing of key e-commerce user flows, including login, shopping cart operations, checkout, and form validation. Tests can be executed locally and through GitHub Actions.

## Tech Stack

- **Java** — programming language
- **Selenium WebDriver** — browser automation
- **JUnit 5** — test framework
- **Maven** — dependency management and test execution
- **GitHub Actions** — continuous integration (CI)
- **Chrome** — browser used for automated tests

## Test Scenarios

The test suite covers the following areas:

- **Login** — valid and invalid login scenarios
- **Shopping Cart** — adding products to the cart and verifying cart contents
- **Checkout** — checkout workflow and order information
- **Checkout Validation** — validating required fields and handling invalid form submissions
- **Smoke Tests** — verifying essential application functionality

## Project Structure

```text
ecommerce-test-automation/
├── .github/
│   └── workflows/
│       └── ...
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pl/testautomation/pages/
│   │           ├── LoginPage.java
│   │           ├── ProductsPage.java
│   │           ├── CartPage.java
│   │           └── CheckoutPage.java
│   └── test/
│       └── java/
│           └── pl/testautomation/tests/
│               ├── BaseTest.java
│               ├── LoginTest.java
│               ├── CartTest.java
│               ├── CheckoutTest.java
│               ├── CheckoutValidationTest.java
│               └── SmokeTest.java
├── pom.xml
└── README.md
```

## Design Approach

The project uses the **Page Object Model (POM)** to separate page-specific locators and interactions from test logic.

Key practices include:

- Reusable page objects
- Explicit waits for dynamic elements and navigation
- Independent test setup and teardown
- Headless Chrome configuration for CI execution
- Automated test execution through GitHub Actions

## Prerequisites

Make sure you have installed:

- Java JDK
- Apache Maven
- Google Chrome

Check your Java and Maven installations:

```bash
java -version
mvn -version
```

## Running the Tests

Clone the repository:

```bash
git clone https://github.com/MariaGosa/ecommerce-test-automation.git
cd ecommerce-test-automation
```

Run the complete test suite:

```bash
mvn clean test
```

Maven runs the JUnit tests configured in the project.

## Continuous Integration

The project uses **GitHub Actions** to run automated tests on pushes to the repository.

The workflow is configured to run tests using Maven and headless Chrome, helping verify that the test suite works in a CI environment as well as locally.

Check the latest workflow results here:

[GitHub Actions — Workflow Runs](https://github.com/MariaGosa/ecommerce-test-automation/actions)

## Application Under Test

The tests target SauceDemo, a demo e-commerce application designed for practicing web testing and automation.

Website: https://www.saucedemo.com/

## Project Goals

- Practice browser automation with Selenium WebDriver
- Build maintainable UI tests using the Page Object Model
- Validate important e-commerce user journeys
- Practice test execution with Maven and JUnit 5
- Configure and maintain a CI workflow with GitHub Actions

## Author

**Maria Gosa**

GitHub: [MariaGosa](https://github.com/MariaGosa)
