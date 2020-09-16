package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Positive login")
    @Description("Checking of success login with valid data")
    @TmsLink("1404013600")
    public void login() {
        loginSteps.login();
    }

}
