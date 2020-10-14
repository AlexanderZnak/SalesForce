package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.NewAccountModal;
import pages.NewContactModal;
import steps.AccountsSteps;
import steps.ContactsSteps;
import steps.HomeSteps;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    public static final String EMAIL = "sasha_znak-hf5l@force.com";
    public static final String PASSWORD = "123guki1303";
    WebDriver driver;
    NewAccountModal newAccountModal;
    NewContactModal newContactModal;
    AccountsSteps accountsSteps;
    ContactsSteps contactsSteps;
    HomeSteps homeSteps;
    LoginSteps loginSteps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        newAccountModal = new NewAccountModal(driver);
        newContactModal = new NewContactModal(driver);
        accountsSteps = new AccountsSteps(driver);
        contactsSteps = new ContactsSteps(driver);
        homeSteps = new HomeSteps(driver);
        loginSteps = new LoginSteps(driver);
        context.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
