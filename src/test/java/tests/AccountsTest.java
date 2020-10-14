package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create new account")
    @Description("Checking of creating new account")
    @TmsLink("1404013600")
    public void createAccount() {
        loginSteps
                .login(EMAIL, PASSWORD);
        accountsSteps
                .createNewAccount()
                .validateIsAccountCreated("Sasha Znak");
    }

}
