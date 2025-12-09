package tests;

import org.junit.Test;
import page_objects.ContactListPage;
import page_objects.LoginPage;
import page_objects.SignUpPage;

import java.util.concurrent.ThreadLocalRandom;

import static enums.Enums.ButtonType;
import static enums.Enums.HeaderType;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest{

    @Test
    public void LoginSuccessfulWhenCreateNewAccount() {
        LoginPage login = new LoginPage(driver);

        login.headerIsDisplayed(HeaderType.APP_HEADER_LOG_IN_PAGE);
        login.buttonIsDisplayed(ButtonType.SIGNUP_BUTTON_LOG_IN_PAGE);
        login.clickButton(ButtonType.SIGNUP_BUTTON_LOG_IN_PAGE);

        SignUpPage signup = new SignUpPage(driver);

        String random6 = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
        String firstName = "user-" + random6;
        String lastName = "user-" + random6;
        String email = "user-" + random6 + "@gmail.com";
        String password = random6 + "!";
        System.out.println(firstName + "--" + lastName + "--" + email + "--" + password);

        signup.setCredentials(firstName, lastName, email, password);
        signup.clickButton(ButtonType.SUBMIT_BUTTON_SIGN_UP_PAGE);

        ContactListPage contactList = new ContactListPage(driver);

        String actualHeader = contactList.getHeader(HeaderType.CONTACT_LIST_HEADER_CONTACT_LIST_PAGE);
        assertEquals("Contact List", actualHeader);
    }
}