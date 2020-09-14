package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select {
    WebDriver driver;
    String label;
    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInputSelect')]//a";
    String optionLocator = "//li//a[@title='%s']";

    public Select(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }

}
