package ua.com.qatestlab;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CheckingMainMenuOfAdminPanel {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
////        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
//        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void menuOrdersCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Заказы • prestashop-automation");
    }

    @Test
    public void menuCustomersCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomer']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Управление клиентами • prestashop-automation");
    }

    @Test
    public void menuCustomerServiceCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Customer Service • prestashop-automation");
    }

    @Test
    public void menuCatalogCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "товары • prestashop-automation");
    }

    @Test
    public void menuStatisticCheck() {
        driver.findElement(By.partialLinkText("Статистика")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Статистика • prestashop-automation");
    }

    @Test
    public void menuModulesCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "prestashop-automation");
    }

    @Test
    public void menuDesignCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentThemes']/a/span")).click();
        driver.findElement(By.partialLinkText("Design")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Шаблоны • prestashop-automation");
    }

    @Test
    public void menuDeliveryCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentShipping']/a/span")).click();
        driver.findElement(By.partialLinkText("Доставка")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Курьеры • prestashop-automation");
    }

    @Test
    public void menuLocalizationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminInternational']/a/span")).click();
//        driver.findElement(By.partialLinkText("International")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Локализация • prestashop-automation");
    }

    @Test
    public void menuShopParametersCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-ShopParameters']/a/span")).click();
        driver.findElement(By.partialLinkText("Parameters")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "General • prestashop-automation");
    }

    @Test
    public void menuConfigurationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        driver.findElement(By.partialLinkText("Конфигурация")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Information • prestashop-automation");
    }

    @Test
    public void menuDashboardCheck() {
        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a/span")).click();
//        driver.findElement(By.partialLinkText("Dashboard")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        driver.navigate().refresh();
        header = driver.getTitle();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(header, "Dashboard • prestashop-automation");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}