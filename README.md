This project contains 5 UI tests and 1 API test for https://thinking-tester-contact-list.herokuapp.com/.
The test suite covers both happy and unhappy paths for user login, account creation, adding and deleting a contact.

Framework Description

UI Automation:
-Java 11
-Selenium 4.13.0
-WebDriverManager 5.9.2
-JUnit 4.13.2

The UI framework uses:
-Page Object Model (POM)
-Base Test class for setup/teardown

API Automation:
-RestAssured 5.5.0

How to run the tests

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
