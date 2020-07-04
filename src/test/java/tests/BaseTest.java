package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ListenerTest;
import webcore.BrowserService;
@Listeners(ListenerTest.class)

public class BaseTest {
    public static WebDriver driver;

    String URL;
    BrowserService browserService = new BrowserService();

    @Parameters("URL")
    @BeforeClass
    public void setUp(String URL) {
        driver = browserService.initBrowser();
        this.URL = URL;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
