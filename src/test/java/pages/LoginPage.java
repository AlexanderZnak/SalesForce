package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class LoginPage extends BasePage {
    public static final By USERNAME = By.id("username");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Login page")
    public LoginPage openPage() {
        driver.get("https://login.salesforce.com/");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the login page opened")
    public LoginPage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    @Step("Insert username and password for login")
    public HomePage login() {
        openPage();
        driver.findElement(USERNAME).sendKeys("sasha_znak-hf5l@force.com");
        driver.findElement(PASSWORD).sendKeys("123guki1303");
        driver.findElement(LOGIN_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return new HomePage(driver);
    }

}
