package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import webcore.BrowserService;

import java.io.File;
import java.util.List;

public class DownloadTest {
    WebDriver driver;
    BrowserService browserService = new BrowserService();

    @Test
    public void test1() throws InterruptedException {

        driver = browserService.initBrowser();

        driver.navigate().to("http://the-internet.herokuapp.com/download");


        List<WebElement> list = driver.findElements(By.cssSelector(".example a"));


        WebElement el = list.get(list.size() - 3);
        el.click();
        Thread.sleep(2000);
        
        File folder = new File(System.getProperty("user.dir"));


        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("text.txt")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
        driver.quit();
    }
}
