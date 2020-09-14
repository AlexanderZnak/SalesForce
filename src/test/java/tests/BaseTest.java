package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    NewAccountModal newAccountModal;
    HomePage homePage;
    AccountsPage accountsPage;
    ContactsPage contactsPage;
    NewContactModal newContactModal;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        newAccountModal = new NewAccountModal(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        contactsPage = new ContactsPage(driver);
        newContactModal = new NewContactModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}