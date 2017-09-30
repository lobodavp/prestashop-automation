package ua.com.qatestlab.tests;

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
//setup page
        driver = new FirefoxDriver();
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
//        System.out.println("Page title is: " + driver.getTitle());
//Login form
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
//Main menu
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "Заказы • prestashop-automation");

//        driver.findElement(By.partialLinkText("Каталог")).click();
        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "товары • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomer']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "Управление клиентами • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "Customer Service • prestashop-automation");

        driver.findElement(By.partialLinkText("Статистика")).click();
        Assert.assertEquals(getTitle(driver), "Статистика • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentThemes']/a/span")).click();
        driver.findElement(By.partialLinkText("Design")).click();
        Assert.assertEquals(getTitle(driver), "Шаблоны • prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentShipping']/a/span")).click();
        driver.findElement(By.partialLinkText("Доставка")).click();
        Assert.assertEquals(getTitle(driver), "Курьеры • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminInternational']/a/span")).click();
//        driver.findElement(By.partialLinkText("International")).click();
        Assert.assertEquals(getTitle(driver), "Локализация • prestashop-automation");

//        driver.findElement(By.xpath(".//*[@id='subtab-ShopParameters']/a/span")).click();
        driver.findElement(By.partialLinkText("Parameters")).click();
        Assert.assertEquals(getTitle(driver), "General • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        driver.findElement(By.partialLinkText("Конфигурация")).click();
        Assert.assertEquals(getTitle(driver), "Information • prestashop-automation");

        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a/span")).click();
//        driver.findElement(By.partialLinkText("Dashboard")).click();
        Assert.assertEquals(getTitle(driver), "Dashboard • prestashop-automation");

////exit from the dashboard panel page
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.className("employee_avatar_small")).click();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("#header_logout")).click();
////Check of returning to the Login page
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
//        System.out.println("Page title is: " + driver.getTitle());
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
//close browser
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    private static String getTitle(WebDriver driver) {
        System.out.println("Page title is: " + driver.getTitle());
        driver.navigate().refresh();
        return driver.getTitle();
    }
}