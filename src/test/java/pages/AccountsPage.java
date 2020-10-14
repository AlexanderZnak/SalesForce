package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import java.util.List;

import static org.testng.Assert.fail;

public class AccountsPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    public static final By ACCOUNTS = By.xpath("//span//a[contains(@class,'outputLookupLink')]");
    String saveCancelNew = "button[title='%s']";

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening Account page")
    public AccountsPage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the account page opened")
    public AccountsPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }

        return this;
    }

    @Step("Checking whether the account modal opened")
    public AccountsPage isModalNewAccountOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format(saveCancelNew, "Save"))));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Clicking for create new account")
    public NewAccountModal clickNewAccount() {
        driver.findElement(NEW_BUTTON).click();
        isModalNewAccountOpened();
        AllureUtils.takeScreenshot(driver);
        return new NewAccountModal(driver);
    }

    @Step("Clicking : '{name}'")
    public AccountsPage clickSaveOrCancelOrNew(String name) {
        driver.findElement(By.cssSelector(String.format(saveCancelNew, name))).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the new account: '{accountName}' was created")
    public boolean newAccountWasCreated(String accountName) {
        List<WebElement> listOfAccounts = driver.findElements(ACCOUNTS);
        boolean a = false;
        for (int i = 0; i < listOfAccounts.size(); i++) {
            if (listOfAccounts.get(i).getAttribute("title").equals(accountName))
                a = true;
        }
        AllureUtils.takeScreenshot(driver);
        return a;
    }

}
