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

    @Step("Creating new account and checking the new account was created")
    public AccountsSteps createNewAccount() {
        Account account = new Account("Sasha Znak", "petya", "375336254654", "2342", "jobs.tut.by", "Analyst", "Banking", "20", "20000", "likes testing", "Prityckogo", "Prityckogo", "Minsk", "Minsk district", "Minsk", "Minsk district", "220082", "375", "220082", "375");
        loginPage
                .openPage()
                .login()
                .isPageOpened();
        boolean created = accountsPage
                .openPage()
                .clickNewAccount()
                .createAccount(account)
                .clickSaveOrCancelOrNew("Save")
                .openPage()
                .newAccountWasCreated("Sasha Znak");
        assertTrue(created);
        return this;
    }

}
