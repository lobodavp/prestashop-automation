package ua.com.qatestlab.tests;
import ua.com.qatestlab.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginIn_OutTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // driver.navigate().to(Properties.getBaseAdminUrl());
        driver.get(Properties.getBaseAdminUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.println("Page title is: " + driver.getTitle());
//Login page
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
//exit from the dashboard panel page
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.findElement(By.cssSelector("#header_logout")).click();
////Check of returning to the Login page
////        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
//        System.out.println("Page title is: " + driver.getTitle());
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
//browser close
            driver.manage().deleteAllCookies();
            driver.quit();
    }
}