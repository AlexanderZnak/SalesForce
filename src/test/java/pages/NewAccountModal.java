package pages;

import elements.Input;
import elements.Select;
import elements.TextArea;
import org.openqa.selenium.WebDriver;

public class NewAccountModal {
    WebDriver driver;

    public NewAccountModal(WebDriver driver) {
        this.driver = driver;
    }

    public AccountsPage createAccount() {
        new Input(driver, "Account Name").write("Sasha Znak");
        new Input(driver, "Parent Account").writeForParentAccount("petya");
        new Input(driver, "Phone").write("375336254654");
        new Input(driver, "Fax").write("220082");
        new Input(driver, "Website").write("jobs.tut.by");
        new Select(driver, "Type").select("Analyst");
        new Select(driver, "Industry").select("Banking");
        new Input(driver, "Employees").write("10");
        new Input(driver, "Annual Revenue").write("20000");
        new TextArea(driver, "Description").write("likes testing");
        new TextArea(driver, "Billing Street").write("Prityckogo");
        new TextArea(driver, "Shipping Street").write("Prityckogo");
        new Input(driver, "Billing City").write("Minsk");
        new Input(driver, "Billing State/Province").write("Minsk district");
        new Input(driver, "Shipping City").write("Minsk");
        new Input(driver, "Shipping State/Province").write("Minsk district");
        new Input(driver, "Billing Zip/Postal Code").write("220082");
        new Input(driver, "Billing Country").write("375");
        new Input(driver, "Shipping Zip/Postal Code").write("220082");
        new Input(driver, "Shipping Country").write("375");
        return new AccountsPage(driver);
    }

}
