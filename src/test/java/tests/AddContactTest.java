package tests;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import page_objects.*;

import java.util.List;

import static enums.Enums.ButtonType;
import static enums.Enums.HeaderType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddContactTest extends BaseTest{

    @Test
    public void NewContactIsDisplayedWhenAdded() {
        LoginPage login = new LoginPage(driver);

        login.headerIsDisplayed(HeaderType.APP_HEADER_LOG_IN_PAGE);
        login.setCredentials("user-mariam@gmail.com", "mariam!");
        login.clickButton(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);

        ContactListPage contactList = new ContactListPage(driver);
        contactList.waitForPageToLoad();
        contactList.buttonIsDisplayed(ButtonType.ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE);
        contactList.clickButton(ButtonType.ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE);

        AddContactPage addContact = new AddContactPage(driver);
        addContact.headerIsDisplayed(HeaderType.ADD_CONTACT_HEADER_ADD_CONTACT_PAGE);
        addContact.setCredentials("maria", "m", "1997-12-12", "maria@gmail.com", "1234567890", "a", "b", "athens", "abc", "12345", "gr");
        addContact.clickButton(ButtonType.SUBMIT_BUTTON_ADD_CONTACT_PAGE);
        contactCreated = true;

        contactList = new ContactListPage(driver);
        List<WebElement> cells = contactList.getRowCells(0);
        assertTrue(cells.get(1).getText().equals("maria m"));
        assertTrue(cells.get(2).getText().equals("1997-12-12"));
        assertTrue(cells.get(3).getText().equals("maria@gmail.com"));
        assertTrue(cells.get(4).getText().equals("1234567890"));
        assertTrue(cells.get(5).getText().equals("a b"));
        assertTrue(cells.get(6).getText().equals("athens abc 12345"));
        assertTrue(cells.get(7).getText().equals("gr"));
    }

    @Test
    public void ContactsDisplayedInLoginAfterLogout() {
        LoginPage login = new LoginPage(driver);

        login.setCredentials("user-mariam@gmail.com", "mariam!");
        login.clickButton(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);

        ContactListPage contactList = new ContactListPage(driver);
        contactList.waitForPageToLoad();
        contactList.clickButton(ButtonType.ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE);

        AddContactPage addContact = new AddContactPage(driver);
        addContact.setCredentials("maria", "m", "1997-12-12", "maria@gmail.com", "1234567890", "a", "b", "athens", "abc", "12345", "gr");
        addContact.clickButton(ButtonType.SUBMIT_BUTTON_ADD_CONTACT_PAGE);
        contactCreated = true;

        contactList = new ContactListPage(driver);
        contactList.waitForPageToLoad();
        contactList.clickButton(ButtonType.LOGOUT_BUTTON_CONTACT_LIST_PAGE);

        login = new LoginPage(driver);
        login.navigateTo("https://thinking-tester-contact-list.herokuapp.com/");
        login.setCredentials("user-mariam@gmail.com", "mariam!");
        login.clickButton(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);

        contactList = new ContactListPage(driver);
        List<WebElement> cells = contactList.getRowCells(0);
        assertTrue(cells.get(1).getText().equals("maria m"));
        assertTrue(cells.get(2).getText().equals("1997-12-12"));
        assertTrue(cells.get(3).getText().equals("maria@gmail.com"));
        assertTrue(cells.get(4).getText().equals("1234567890"));
        assertTrue(cells.get(5).getText().equals("a b"));
        assertTrue(cells.get(6).getText().equals("athens abc 12345"));
        assertTrue(cells.get(7).getText().equals("gr"));
    }

    @Test
    public void AddContactErrorIsDisplayedWhenFieldLastnameIsEmpty() {
        LoginPage login = new LoginPage(driver);

        login.setCredentials("user-mariam@gmail.com", "mariam!");
        login.clickButton(ButtonType.SUBMIT_BUTTON_LOG_IN_PAGE);

        ContactListPage contactList = new ContactListPage(driver);
        contactList.waitForPageToLoad();
        contactList.clickButton(ButtonType.ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE);

        AddContactPage addContact = new AddContactPage(driver);
        addContact.setCredentials("maria", "", "", "", "", "", "", "", "", "", "");
        addContact.clickButton(ButtonType.SUBMIT_BUTTON_ADD_CONTACT_PAGE);

        String actualError = addContact.getHeader(HeaderType.REQUIRED_FIELD_ERROR_ADD_CONTACT_PAGE);
        assertEquals("Contact validation failed: lastName: Path `lastName` is required.", actualError);
    }
}