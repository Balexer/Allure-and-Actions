package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.WaitersMain;
import webcore.BrowserService;

import java.util.concurrent.TimeUnit;

public class DynamicControlTest {

    @Test
    public void test1() {
        WebDriver driver = new BrowserService().initBrowser();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //Найти чекбокс
        WebElement checkBox = driver.findElement(By.xpath("//input[@type ='checkbox']"));
        checkBox.isDisplayed();

        //Нажать на кнопку
        WebElement buttonRemove = driver.findElement(By.xpath("//button[text()='Remove']"));
        buttonRemove.click();

        WaitersMain waiters = new WaitersMain(driver);

        //Дождаться надписи “It’s gone”
        WebElement loadingOne = waiters.waitForVisibilityFluent(By.id("loading"));
        Assert.assertNotNull(loadingOne);

        waiters.waitForInvisibility(loadingOne, 10);

        waiters.waitForVisibility(By.id("message"));

        //Проверить, что чекбокса нет
        try {Assert.assertFalse(checkBox.isDisplayed());}
        catch (StaleElementReferenceException ex) {
        }

        //Найти инпут
        WebElement input = driver.findElement(By.xpath("//form[@id='input-example']/input"));

        //Проверить, что он disabled
        Assert.assertFalse(input.isEnabled());

        //Нажать на кнопку
        WebElement InputButton = driver.findElement(By.xpath("//*[@id='input-example']/button"));
        InputButton.click();

        //Дождаться надписи “It's enabled!”
        WebElement loading = waiters.waitForVisibilityFluent(By.id("loading"));
        Assert.assertNotNull(loading);

        waiters.waitForInvisibility(loading, 5);

        waiters.waitForVisibility(By.id("message"));

        //Проверить, что инпут enabled
        Assert.assertTrue(input.isEnabled());

        driver.quit();
    }
}

