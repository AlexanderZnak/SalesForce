package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login with email: '{email}', password: '{password}'")
    public LoginSteps login(String email, String password) {
        loginPage
                .openPage()
                .login(email, password);
        return this;
    }

    @Step("Validate is login page opened")
    public LoginSteps validateIsPageOpened() {
        loginPage.isPageOpened();
        return this;
    }

}
