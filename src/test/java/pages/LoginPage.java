package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class LoginPage extends BasePage {
    public static final By USERNAME = By.id("username");
    public static final By PASSWORD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get("https://login.salesforce.com/");
        isPageOpened();
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

    public HomePage login() {
        openPage();
        driver.findElement(USERNAME).sendKeys("sasha_znak-hf5l@force.com");
        driver.findElement(PASSWORD).sendKeys("123guki1303");
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }

}
