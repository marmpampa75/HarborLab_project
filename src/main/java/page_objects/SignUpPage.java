package page_objects;

import enums.Enums.ButtonType;
import enums.Enums.HeaderType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignUpPage extends BasePage {

    /* Sign Up Page Locators */
    private final By addUserHeader = By.cssSelector(".main-content h1");
    private final By signUpHeader = By.cssSelector(".main-content p:first-of-type");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By cancelButton = By.id("cancel");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    /* Sign Up Page functions */
    public boolean headerIsDisplayed(HeaderType header) {
        switch (header) {
            case ADD_USER_HEADER_SIGN_UP_PAGE:
                return driver.findElement(addUserHeader).isDisplayed();
            case SIGNUP_HEADER_SIGN_UP_PAGE:
                return driver.findElement(signUpHeader).isDisplayed();
            default:
                return false;
        }
    }

    public boolean buttonIsDisplayed(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_SIGN_UP_PAGE:
                return driver.findElement(submitButton).isDisplayed();
            case CANCEL_BUTTON_SIGN_UP_PAGE:
                return driver.findElement(cancelButton).isDisplayed();
            default:
                return false;
        }
    }

    public void clickButton(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_SIGN_UP_PAGE:
                driver.findElement(submitButton).click();
                break;
            case CANCEL_BUTTON_SIGN_UP_PAGE:
                driver.findElement(cancelButton).click();
                break;
        }
    }

    public void setCredentials(String firstName, String lastName, String email, String password) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getHeader(HeaderType header) {
        WebElement element;
        switch (header) {
            case ADD_USER_HEADER_SIGN_UP_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(addUserHeader));
                return element.getText();
            case SIGNUP_HEADER_SIGN_UP_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpHeader));
                return element.getText();
            default:
                return "-------";
        }
    }


}