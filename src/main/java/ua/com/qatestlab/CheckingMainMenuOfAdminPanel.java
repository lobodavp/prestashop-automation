package ua.com.qatestlab;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckingMainMenuOfAdminPanel {
    public static void main(String[] args) {
        WebDriver driver;
        String header;

        driver = new FirefoxDriver();
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
//        System.out.println("Page title is: " + driver.getTitle());

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a/span")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Заказы • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomer']/a/span")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Управление клиентами • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Customer Service • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a/span")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "товары • prestashop-automation");

        driver.findElement(By.partialLinkText("Статистика")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Статистика • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentThemes']/a/span")).click();
        driver.findElement(By.partialLinkText("Design")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Шаблоны • prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentShipping']/a/span")).click();
        driver.findElement(By.partialLinkText("Доставка")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Курьеры • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminInternational']/a/span")).click();
//        driver.findElement(By.partialLinkText("International")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Локализация • prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-ShopParameters']/a/span")).click();
        driver.findElement(By.partialLinkText("Parameters")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "General • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        driver.findElement(By.partialLinkText("Конфигурация")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Information • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a/span")).click();
//        driver.findElement(By.partialLinkText("Dashboard")).click();
        header = getTitle(driver);
        Assert.assertEquals(header, "Dashboard • prestashop-automation");

        driver.manage().deleteAllCookies();
        driver.quit();
    }

    private static String getTitle(WebDriver driver) {
        String header;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        header = driver.getTitle();
        return header;
    }
}