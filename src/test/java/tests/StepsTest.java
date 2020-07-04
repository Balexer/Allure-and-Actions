package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class StepsTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver(), URL);
        Assert.assertTrue(!loginPage.isPageOpened(), "Login page hasn't opened.");

        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(dependsOnMethods = "loginTest", alwaysRun = true)
    public void selectProduct() {
        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.isPageOpened());

        productPage.addToCart("Sauce Labs Fleece Jacket");
    }

    @Test
    public void fullTest() {
        LoginPage loginPage = new LoginPage(getDriver(), URL);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page hasn't opened.");

        loginPage.login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(getDriver());
        Assert.assertTrue(productPage.isPageOpened());

        productPage.addToCart("Sauce Labs Fleece Jacket");
    }
}

