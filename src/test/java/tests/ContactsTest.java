package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void createContact() {
        loginPage
                .openPage()
                .login()
                .isPageOpened();
        boolean created = contactsPage
                .openPage()
                .clickNewContact()
                .createContact()
                .clickSaveOrCancelOrNew("Save")
                .openPage()
                .newContactWasCreated("Sasha Znak");
        assertTrue(created);
    }

}
