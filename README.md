This project contains 5 UI tests and 1 API test for https://thinking-tester-contact-list.herokuapp.com/.
The test suite covers both happy and unhappy paths for user login, account creation, adding and deleting a contact.

**Framework Description**

This automation framework is built using the following stack:

- **Java 11** – main programming language
- **JUnit 4** – test runner and assertion library
- **Selenium WebDriver 4.13.0** – UI test automation
- **WebDriverManager 5.9.2** – automatic driver management
- **REST Assured 5.5.0** – API testing
- **Maven** – build, dependency management, and test execution
- **Page Object Model (POM)** – design pattern for maintainable UI tests
- Base Test class for setup/teardown


**How to run the tests**

To execute both UI and API automated tests, run the following command in your terminal:
> mvn test

You should see output similar to this:

...

-------------------------------------------------------

 T E S T S
 
-------------------------------------------------------

...

Results :

Tests run: 6, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  01:19 min

[INFO] Finished at: 2025-12-09T23:42:20+02:00

[INFO] ------------------------------------------------------------------------


To execute only one of the tests, run the following command in your terminal:
> mvn -Dtest=test_class_name test

You should see output similar to this:

...

-------------------------------------------------------

 T E S T S
 
-------------------------------------------------------

...

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  21.212 s

[INFO] Finished at: 2025-12-10T00:04:59+02:00

[INFO] ------------------------------------------------------------------------
