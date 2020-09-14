package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AccountsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void createAccount() {
        loginPage
                .openPage()
                .login()
                .isPageOpened();
        boolean created = accountsPage
                .openPage()
                .clickNewAccount()
                .createAccount()
                .clickSaveOrCancelOrNew("Save")
                .openPage()
                .newAccountWasCreated("Sasha Znak");
        assertTrue(created);
    }

}
