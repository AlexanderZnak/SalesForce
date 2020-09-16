package tests;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ContactsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Create new contact")
    @Description("Checking of creating new contact")
    @TmsLink("1404013600")
    public void createContact() {
        contactsSteps.createNewContact();
    }

}
