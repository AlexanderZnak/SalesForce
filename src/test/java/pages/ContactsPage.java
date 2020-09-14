package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class ContactsPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }


    public ContactsPage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        isPageOpened();
        return this;
    }

    public ContactsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    public NewContactModal clickNewContact() {
        new AccountsPage(driver).clickNewAccount();
        return new NewContactModal(driver);
    }

    public ContactsPage clickSaveOrCancelOrNew(String name) {
        new AccountsPage(driver).clickSaveOrCancelOrNew(name);
        return this;
    }

    public boolean newContactWasCreated(String accountName) {
        return new AccountsPage(driver).newAccountWasCreated(accountName);
    }

}
