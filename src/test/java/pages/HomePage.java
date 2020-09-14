package pages;

import elements.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.fail;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get("https://ap16.lightning.force.com/lightning/page/home");
        isPageOpened();
        return this;
    }

    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(new Link(driver).getLocator(), "Home"))));
        } catch (TimeoutException e) {
            fail("Page wasn't opened");
        }
        return this;
    }

}
