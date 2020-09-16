package pages;

import elements.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.fail;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Home page")
    public HomePage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/page/home");
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Checking whether the home page opened")
    public HomePage isPageOpened() {
        try {
            AllureUtils.takeScreenshot(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(new Link(driver).getLocator(), "Home"))));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

}
