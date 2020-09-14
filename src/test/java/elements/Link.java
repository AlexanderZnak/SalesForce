package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link {
    WebDriver driver;
    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'navUL')]//a";

    public Link(WebDriver driver) {
        this.driver = driver;
    }

    public void goByLink(String label) {
        driver.findElement(By.xpath(String.format(locator, label))).click();
    }

    public String getLocator() {
        return locator;
    }

}
