package page_objects;

import enums.Enums.ButtonType;
import enums.Enums.HeaderType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ContactListPage extends BasePage {

    /* Contact List Page Locators */
    private final By contactListHeader = By.cssSelector(".main-content header h1");
    private final By infoHeader = By.cssSelector(".main-content p:first-of-type");
    private final By contactsTable = By.cssSelector(".contactTable");
    private final By tableHeaders = By.cssSelector(".contactTableHead th");
    private final By tableRows = By.cssSelector(".contactTableBodyRow");
    private final By addContactButton = By.id("add-contact");
    private final By logoutButton = By.id("logout");

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    /* Contact List Page functions */
    public boolean headerIsDisplayed(HeaderType header) {
        switch (header) {
            case CONTACT_LIST_HEADER_CONTACT_LIST_PAGE:
                return driver.findElement(contactListHeader).isDisplayed();
            case INFO_HEADER_CONTACT_LIST_PAGE:
                return driver.findElement(infoHeader).isDisplayed();
            default:
                return false;
        }
    }

    public boolean buttonIsDisplayed(ButtonType button) {
        switch (button) {
            case ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE:
                return driver.findElement(addContactButton).isDisplayed();
            case LOGOUT_BUTTON_CONTACT_LIST_PAGE:
                return driver.findElement(logoutButton).isDisplayed();
            default:
                return false;
        }
    }

    public void clickButton(ButtonType button) {
        switch (button) {
            case ADD_CONTACT_BUTTON_CONTACT_LIST_PAGE:
                driver.findElement(addContactButton).click();
                break;
            case LOGOUT_BUTTON_CONTACT_LIST_PAGE:
                driver.findElement(logoutButton).click();
                break;
        }
    }

    public String getHeader(HeaderType header) {
        WebElement element;
        switch (header) {
            case CONTACT_LIST_HEADER_CONTACT_LIST_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(contactListHeader));
                return element.getText();
            case INFO_HEADER_CONTACT_LIST_PAGE:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(infoHeader));
                return element.getText();
            default:
                return "-------";
        }
    }

    public List<WebElement> getRowCells(int rowIndex) {
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));
        return rows.get(rowIndex).findElements(By.tagName("td"));
    }

    public void clickCell(int rowIndex, int cellIndex) {
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tableRows));
        WebElement row = rows.get(rowIndex);

        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(cellIndex).click();
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactsTable));
    }

}