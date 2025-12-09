package page_objects;

import enums.Enums.ButtonType;
import enums.Enums.HeaderType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContactDetailsPage extends BasePage {

    /* Contact Details Page Locators */
    private final By contactDetailsHeader = By.cssSelector(".main-content header h1");
    private final By editContactButton = By.id("add-contact");
    private final By deleteButton = By.id("delete");
    private final By returnButton = By.id("return");
    private final By logoutButton = By.id("logout");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    /* Contact Details Page functions */
    public boolean headerIsDisplayed(HeaderType header) {
        switch (header) {
            case CONTACT_DETAILS_HEADER_CONTACT_DETAILS_PAGE:
                return driver.findElement(contactDetailsHeader).isDisplayed();
            default:
                return false;
        }
    }

    public boolean buttonIsDisplayed(ButtonType button) {
        switch (button) {
            case EDIT_CONTACT_BUTTON_CONTACT_DETAILS_PAGE:
                return driver.findElement(editContactButton).isDisplayed();
            case DELETE_BUTTON_CONTACT_DETAILS_PAGE:
                return driver.findElement(deleteButton).isDisplayed();
            case RETURN_BUTTON_CONTACT_DETAILS_PAGE:
                return driver.findElement(returnButton).isDisplayed();
            case LOGOUT_BUTTON_CONTACT_DETAILS_PAGE:
                return driver.findElement(logoutButton).isDisplayed();
            default:
                return false;
        }
    }

    public void clickButton(ButtonType button) {
        switch (button) {
            case EDIT_CONTACT_BUTTON_CONTACT_DETAILS_PAGE:
                driver.findElement(editContactButton).click();
                break;
            case DELETE_BUTTON_CONTACT_DETAILS_PAGE:
                driver.findElement(deleteButton).click();
                break;
            case RETURN_BUTTON_CONTACT_DETAILS_PAGE:
                driver.findElement(returnButton).click();
                break;
            case LOGOUT_BUTTON_CONTACT_DETAILS_PAGE:
                driver.findElement(logoutButton).click();
                break;
        }
    }

    public String getHeader(HeaderType header) {
        WebElement element;
        switch (header) {
            case CONTACT_DETAILS_HEADER_CONTACT_DETAILS_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactDetailsHeader));
                return element.getText();
            default:
                return "-------";
        }
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactDetailsHeader));
    }

}