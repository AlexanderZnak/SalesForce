package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class ContactsPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Contact page")
    public ContactsPage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the contact page opened")
    public ContactsPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Clicking for create new contact")
    public NewContactModal clickNewContact() {
        new AccountsPage(driver).clickNewAccount();
        AllureUtils.takeScreenshot(driver);
        return new NewContactModal(driver);
    }

    @Step("Clicking save or cancel, or save&new for ending of creating the new contact")
    public ContactsPage clickSaveOrCancelOrNew(String name) {
        new AccountsPage(driver).clickSaveOrCancelOrNew(name);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the new contact was created")
    public boolean newContactWasCreated(String accountName) {
        AllureUtils.takeScreenshot(driver);
        return new AccountsPage(driver).newAccountWasCreated(accountName);
    }

}
