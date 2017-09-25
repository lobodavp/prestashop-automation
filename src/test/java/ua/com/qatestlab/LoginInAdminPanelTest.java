package ua.com.qatestlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginInAdminPanelTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void gotoLoginPage() {
        // Go to login page
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        // Find the text input element by its id "email" and fill in "webinar.test@gmail.com"
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        // Find the text input element by its id "passwd" and fill in "Xcg7299bnSmMuRLp9ITw"
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        // Click "submitLogin" button
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //Click "header_logout" button
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#header_logout")).click();
        // Get text from header of the login page
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String header = driver.getTitle();
        // Verify that header equals "prestashop-automation > Панель администратора (PrestaShop™)"
        Assert.assertEquals(header, "prestashop-automation > Панель администратора (PrestaShop™)");
    }

    @AfterClass
    public void tearDown() {
        // Close all browser windows and safely end the session
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}