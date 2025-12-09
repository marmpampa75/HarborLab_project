package tests;

import static enums.Enums.HeaderType;
import static enums.Enums.ButtonType;

import page_objects.LoginPage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LoginTest extends BaseTest{

    @Test
    public void LoginErrorIsDisplayedWhenFieldsEmpty() {
        LoginPage login = new LoginPage(driver);

        login.headerIsDisplayed(HeaderType.APP_HEADER_LOG_IN_PAGE);
        login.buttonIsDisplayed(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);
        login.clickButton(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);

        String actualError = login.getHeader(HeaderType.ERROR_HEADER_LOG_IN_PAGE);
        assertEquals("Incorrect username or password", actualError);
    }
}