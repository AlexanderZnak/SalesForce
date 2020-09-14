package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.fail;

public class AccountsPage extends BasePage {
    public static final By NEW_BUTTON = By.cssSelector("[title='New']");
    public static final By ACCOUNTS = By.xpath("//span//a[contains(@class,'outputLookupLink')]");
    String saveCancelNew = "button[title='%s']";

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        isPageOpened();
        return this;
    }

    public AccountsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(NEW_BUTTON));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    public AccountsPage isModalNewAccountOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format(saveCancelNew, "Save"))));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    public NewAccountModal clickNewAccount() {
        driver.findElement(NEW_BUTTON).click();
        isModalNewAccountOpened();
        return new NewAccountModal(driver);
    }

    public AccountsPage clickSaveOrCancelOrNew(String name) {
        driver.findElement(By.cssSelector(String.format(saveCancelNew, name))).click();
        return this;
    }

    public boolean newAccountWasCreated(String accountName) {
        List<WebElement> listOfAccounts = driver.findElements(ACCOUNTS);
        boolean a = false;
        for (int i = 0; i < listOfAccounts.size(); i++) {
            if (listOfAccounts.get(i).getAttribute("title").equals(accountName))
                a = true;
        }
        return a;
    }

}
