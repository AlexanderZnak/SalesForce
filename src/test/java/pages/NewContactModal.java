package pages;

import elements.Input;
import elements.Select;
import elements.TextArea;
import org.openqa.selenium.WebDriver;

public class NewContactModal {
    WebDriver driver;

    public NewContactModal(WebDriver driver) {
        this.driver = driver;
    }

    public ContactsPage createContact() {
        new Input(driver, "Phone").write("+375176254654");
        new Input(driver, "Mobile").write("+375336254654");
        new Select(driver, "Salutation").select("Mr.");
        new Input(driver, "First Name").write("Sasha");
        new Input(driver, "Last Name").write("Znak");
        new Input(driver, "Account Name").writeForParentAccount("Sasha Znak");
        new Input(driver, "Email").write("sasha_znak@mailinator.com");
        new Input(driver, "Title").write("Hello");
        new Input(driver, "Reports To").writeForParentAccount("Frolov");
        new TextArea(driver, "Mailing Street").write("Moskvina");
        new TextArea(driver, "Other Street").write("Moskvina");
        new Input(driver, "Mailing City").write("Minsk");
        new Input(driver, "Mailing State/Province").write("Minks district");
        new Input(driver, "Other City").write("Minsk");
        new Input(driver, "Other State/Province").write("Minks district");
        new Input(driver, "Mailing Zip/Postal Code").write("220082");
        new Input(driver, "Mailing Country").write("375");
        new Input(driver, "Other Zip/Postal Code").write("220082");
        new Input(driver, "Other Country").write("375");
        new Input(driver, "Fax").write("2557965");
        new Input(driver, "Department").write("School");
        new Input(driver, "Home Phone").write("375172557965");
        new Input(driver, "Other Phone").write("375172557965");
        new Input(driver, "Asst. Phone").write("375172557965");
        new Input(driver, "Assistant").write("Petya");
        new Select(driver, "Lead Source").select("Advertisement");
        new Input(driver, "Birthdate").write("29.10.1991");
        new TextArea(driver, "Description").write("likes testing");
        return new ContactsPage(driver);
    }

}
