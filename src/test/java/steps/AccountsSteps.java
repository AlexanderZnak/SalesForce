package steps;

import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountsPage;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

public class AccountsSteps {
    private LoginPage loginPage;
    private AccountsPage accountsPage;

    public AccountsSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        accountsPage = new AccountsPage(driver);
    }

    @Step("Creating new account")
    public AccountsSteps createNewAccount() {
        Account account = new Account("Sasha Znak", "petya", "375336254654", "2342", "jobs.tut.by", "Analyst", "Banking", "20", "20000", "likes testing", "Prityckogo", "Prityckogo", "Minsk", "Minsk district", "Minsk", "Minsk district", "220082", "375", "220082", "375");
        accountsPage
                .openPage()
                .clickNewAccount()
                .createAccount(account)
                .clickSaveOrCancelOrNew("Save");
        return this;
    }

    @Step("Validate is new account: '{accountName}' created")
    public AccountsSteps validateIsAccountCreated(String accountName) {
        boolean created = accountsPage
                .openPage()
                .newAccountWasCreated(accountName);
        assertTrue(created);
        return this;
    }

}
