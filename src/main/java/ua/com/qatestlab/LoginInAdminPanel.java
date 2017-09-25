package ua.com.qatestlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.util.concurrent.TimeUnit;

public class LoginInAdminPanel {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        // driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        // Find the text input element by its id "email" and fill in "webinar.test@gmail.com"
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        // Find the text input element by its id "passwd" and fill in "Xcg7299bnSmMuRLp9ITw"
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        //        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });

        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
