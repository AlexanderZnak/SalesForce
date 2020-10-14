package steps;

import io.qameta.allure.Step;
import models.Contact;
import org.openqa.selenium.WebDriver;
import pages.ContactsPage;
import pages.LoginPage;

import static org.testng.AssertJUnit.assertTrue;

public class ContactsSteps {
    private LoginPage loginPage;
    private ContactsPage contactsPage;

    public ContactsSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        contactsPage = new ContactsPage(driver);
    }

    @Step("Creating new contact and checking the new contact was created")
    public ContactsSteps createNewContact() {
        Contact contact = new Contact("124124", "124124", "Mr.", "Sasha", "Znak", "Sasha Znak", "sasha_znak@mailinator.com", "Hello", "Frolov", "Moskvina", "Moskvina", "Minsk", "Minks district", "Minsk", "Minks district", "220082", "375", "220082", "375", "2557965", "School", "375172557965", "375172557965", "375172557965", "Petya", "Advertisement", "29.10.1991", "likes testing");
        contactsPage
                .openPage()
                .clickNewContact()
                .createContact(contact)
                .clickSaveOrCancelOrNew("Save");
        return this;
    }

    @Step("Validate is new contact: '{contactName}' created")
    public ContactsSteps validateIsContactCreated(String contactName) {
        boolean created = contactsPage
                .openPage()
                .newContactWasCreated(contactName);
        assertTrue(created);
        return this;
    }

}
