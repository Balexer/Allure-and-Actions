package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllureDescriptionTest {

    @Description("Это позитивный тест")
    @Test(description = "Positive test")
    public void openPage() {
        Assert.assertTrue(true);
    }

    @Description("Это негативный тест")
    @Test(description = "Negative test")
    public void loginPage() {
        Assert.assertTrue(false);
    }

    @Description("Это позитивный")
    @Test(description = "Positive test")
    public void mainPage() {
        Assert.assertTrue(true);
    }
}

