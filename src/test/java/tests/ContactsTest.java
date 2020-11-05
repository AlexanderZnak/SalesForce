package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create new contact")
    @Description("Checking of creating new contact")
    @TmsLink("1404013600")
    public void createContact() {
        loginSteps
                .login(EMAIL, PASSWORD);
        contactsSteps
                .createNewContact()
                .validateIsContactCreated("Sasha Znak");

    }

}
