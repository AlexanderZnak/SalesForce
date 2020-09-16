package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Success login")
    public LoginSteps login() {
        loginPage
                .openPage()
                .login()
                .isPageOpened();
        return this;
    }

}
