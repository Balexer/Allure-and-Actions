package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ActionMain;
import utils.WaitersMain;
import webcore.BrowserService;

import java.util.concurrent.TimeUnit;

public class ActionMainTest {
    @Test
    public void test1() {
        WebDriver driver = new BrowserService().initBrowser();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        driver.get("http://the-internet.herokuapp.com/context_menu");

        WebElement webElement = driver.findElement(By.id("hot-spot"));

        ActionMain myActions = new ActionMain(driver);
        myActions.clickRightButton(webElement);

        WaitersMain waiters = new WaitersMain(driver);
        waiters.waitForAlert();

        driver.quit();
    }
}

