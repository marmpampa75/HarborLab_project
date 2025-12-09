package tests;

import enums.Enums;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.ContactDetailsPage;
import page_objects.ContactListPage;
import page_objects.LoginPage;

import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected boolean contactCreated = false;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        LoginPage login = new LoginPage(driver);
        login.navigateTo("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @After
    public void teardown() {
        if (contactCreated) {
            ContactListPage contactList = new ContactListPage(driver);
            contactList.waitForPageToLoad();

            List<WebElement> cells = contactList.getRowCells(0);
            String firstCellText = cells.get(1).getText().trim();
            System.out.println("The first cell is not empty: " + firstCellText);

            contactList.clickCell(0, 1);

            ContactDetailsPage contactDetails = new ContactDetailsPage(driver);
            contactDetails.waitForPageToLoad();
            contactDetails.clickButton(Enums.ButtonType.DELETE_BUTTON_CONTACT_DETAILS_PAGE);

            Alert alert = driver.switchTo().alert();
            alert.accept(); // clicks OK

            contactList = new ContactListPage(driver);
            contactList.waitForPageToLoad();
        } else {
            System.out.println("Skip deletion");
        }

        if (driver != null) {
            driver.quit();
        }
    }
}