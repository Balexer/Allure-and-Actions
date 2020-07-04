package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webcore.BrowserService;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    @Test
    public void test1() {
        WebDriver driver = new BrowserService().initBrowser();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload")).sendKeys("C:/Users/user/Desktop/484.jpg");
        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), '484.jpg')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text() = 'File Uploaded!']")).isDisplayed());

        driver.quit();
    }
}
