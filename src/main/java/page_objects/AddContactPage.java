package page_objects;

import enums.Enums.ButtonType;
import enums.Enums.HeaderType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddContactPage extends BasePage {

    /* Add Contact Page Locators */
    private final By addContactHeader = By.cssSelector(".main-content header h1");
    private final By RequiredFieldError = By.id("error");
    private final By firstNameField = By.id("firstName");
    private final By lastNameField = By.id("lastName");
    private final By birthdateField = By.id("birthdate");
    private final By emailField = By.id("email");
    private final By phoneField = By.id("phone");
    private final By street1Field = By.id("street1");
    private final By street2Field = By.id("street2");
    private final By cityField = By.id("city");
    private final By stateProvinceField = By.id("stateProvince");
    private final By postalCodeField = By.id("postalCode");
    private final By countryField = By.id("country");
    private final By submitButton = By.id("submit");
    private final By cancelButton = By.id("cancel");
    private final By logoutButton = By.id("logout");

    public AddContactPage(WebDriver driver) {
        super(driver);
    }

    /* Add Contact Page functions */
    public boolean headerIsDisplayed(HeaderType header) {
        switch (header) {
            case ADD_CONTACT_HEADER_ADD_CONTACT_PAGE:
                return driver.findElement(addContactHeader).isDisplayed();
            case REQUIRED_FIELD_ERROR_ADD_CONTACT_PAGE:
                return driver.findElement(RequiredFieldError).isDisplayed();
            default:
                return false;
        }
    }

    public boolean buttonIsDisplayed(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_ADD_CONTACT_PAGE:
                return driver.findElement(submitButton).isDisplayed();
            case CANCEL_BUTTON_ADD_CONTACT_PAGE:
                return driver.findElement(cancelButton).isDisplayed();
            case LOGOUT_BUTTON_ADD_CONTACT_PAGE:
                return driver.findElement(logoutButton).isDisplayed();
            default:
                return false;
        }
    }

    public void clickButton(ButtonType button) {
        switch (button) {
            case SUBMIT_BUTTON_ADD_CONTACT_PAGE:
                driver.findElement(submitButton).click();
                break;
            case CANCEL_BUTTON_ADD_CONTACT_PAGE:
                driver.findElement(cancelButton).click();
                break;
            case LOGOUT_BUTTON_ADD_CONTACT_PAGE:
                driver.findElement(cancelButton).click();
                break;
        }
    }

    public void setCredentials(String firstName, String lastName, String birthdate, String email, String phone, String street1, String street2, String city, String stateProvince, String postalCode, String country) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(birthdateField).sendKeys(birthdate);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(street1Field).sendKeys(street1);
        driver.findElement(street2Field).sendKeys(street2);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(stateProvinceField).sendKeys(stateProvince);
        driver.findElement(postalCodeField).sendKeys(postalCode);
        driver.findElement(countryField).sendKeys(country);
    }

    public String getHeader(HeaderType header) {
        WebElement element;
        switch (header) {
            case ADD_CONTACT_HEADER_ADD_CONTACT_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(addContactHeader));
                return element.getText();
            case REQUIRED_FIELD_ERROR_ADD_CONTACT_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(RequiredFieldError));
                return element.getText();
            default:
                return "-------";
        }
    }
}