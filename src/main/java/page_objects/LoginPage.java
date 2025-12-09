package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import enums.Enums.HeaderType;
import enums.Enums.ButtonType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    /* Login Page Locators */
    private final By appHeader = By.cssSelector("h1");
    private final By logInHeader = By.cssSelector(".main-content p:first-of-type");
    private final By errorMessage = By.id("error");
    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By submitButton = By.id("submit");
    private final By signUpHeader = By.cssSelector(".main-content p:nth-of-type(2)");
    private final By signUpButton = By.id("signup");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /* Login Page functions */
    public void navigateTo(String url) {

        driver.get(url);
    }

    public boolean headerIsDisplayed(HeaderType header) {
        switch (header) {
            case APP_HEADER_LOG_IN_PAGE:
                return driver.findElement(appHeader).isDisplayed();
            case LOGIN_HEADER_LOG_IN_PAGE:
                return driver.findElement(logInHeader).isDisplayed();
            case SIGNUP_HEADER_LOG_IN_PAGE:
                return driver.findElement(signUpHeader).isDisplayed();
            case ERROR_HEADER_LOG_IN_PAGE:
                return driver.findElement(errorMessage).isDisplayed();
            default:
                return false;
        }
    }

    public boolean buttonIsDisplayed(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_LOG_IN_PAGE:
                return driver.findElement(submitButton).isDisplayed();
            case SIGNUP_BUTTON_LOG_IN_PAGE:
                return driver.findElement(signUpButton).isDisplayed();
            default:
                return false;
        }
    }

    public void clickButton(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_LOG_IN_PAGE:
                driver.findElement(submitButton).click();
                break;
            case SIGNUP_BUTTON_LOG_IN_PAGE:
                driver.findElement(signUpButton).click();
                break;
        }
    }

    public void setCredentials(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getHeader(HeaderType header) {
        WebElement element;
        switch (header) {
            case APP_HEADER_LOG_IN_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(appHeader));
                return element.getText();
            case LOGIN_HEADER_LOG_IN_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(logInHeader));
                return element.getText();
            case SIGNUP_HEADER_LOG_IN_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(signUpHeader));
                return element.getText();
            case ERROR_HEADER_LOG_IN_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
                return element.getText();
            default:
                return "-------";
        }
    }
}