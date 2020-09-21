package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String locator = "//span[text()='%s']/ancestor::div[contains(@class,'uiInput')]//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(locator, label))).sendKeys(text);
    }

}
