package ua.com.qatestlab;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginInAdminPanel {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#header_logout")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String header = driver.getTitle();
        Assert.assertEquals(header, "prestashop-automation > Панель администратора (PrestaShop™)");
        System.out.println("Page title is: " + header);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
            driver.manage().deleteAllCookies();
            driver.quit();
    }
}