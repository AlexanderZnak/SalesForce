package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;
    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]//input";
    String locatorForParentAccount = "div[title='%s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text %s into input with label %s", text, label));
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }

    public void writeWithSearch(String text) {
        write(text);
        driver.findElement(By.cssSelector(String.format(locatorForParentAccount, text))).click();
    }

}
