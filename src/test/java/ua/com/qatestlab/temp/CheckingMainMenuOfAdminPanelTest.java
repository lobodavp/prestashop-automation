package ua.com.qatestlab.temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckingMainMenuOfAdminPanelTest {
    private WebDriver driver;

    private String getTitle() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver.getTitle();
    }

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
// Go to login page
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void menuOrdersCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a/span")).click();
        Assert.assertEquals(getTitle(), "Заказы • prestashop-automation");
    }

    @Test
    public void menuCustomersCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomer']/a/span")).click();
        Assert.assertEquals(getTitle(), "Управление клиентами • prestashop-automation");
    }

    @Test
    public void menuCustomerServiceCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
        Assert.assertEquals(getTitle(), "Customer Service • prestashop-automation");
    }

    @Test
    public void menuCatalogCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a/span")).click();
        //  driver.findElement(By.partialLinkText("Каталог")).click();
        Assert.assertEquals(getTitle(), "товары • prestashop-automation");
    }

    @Test
    public void menuStatisticCheck() {
        driver.findElement(By.partialLinkText("Статистика")).click();
        Assert.assertEquals(getTitle(), "Статистика • prestashop-automation");
    }

    @Test
    public void menuModulesCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
        Assert.assertEquals(getTitle(), "prestashop-automation");
    }

    @Test
    public void menuDesignCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentThemes']/a/span")).click();
        driver.findElement(By.partialLinkText("Design")).click();
        Assert.assertEquals(getTitle(), "Шаблоны • prestashop-automation");
    }

    @Test
    public void menuDeliveryCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentShipping']/a/span")).click();
        driver.findElement(By.partialLinkText("Доставка")).click();
        Assert.assertEquals(getTitle(), "Курьеры • prestashop-automation");
    }

    @Test
    public void menuLocalizationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminInternational']/a/span")).click();
//        driver.findElement(By.partialLinkText("International")).click();
        Assert.assertEquals(getTitle(), "Локализация • prestashop-automation");
    }

    @Test
    public void menuShopParametersCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-ShopParameters']/a/span")).click();
        driver.findElement(By.partialLinkText("Parameters")).click();
        Assert.assertEquals(getTitle(), "General • prestashop-automation");
    }

    @Test
    public void menuConfigurationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        driver.findElement(By.partialLinkText("Конфигурация")).click();
        Assert.assertEquals(getTitle(), "Information • prestashop-automation");
    }

    @Test
    public void menuDashboardCheck() {
        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a/span")).click();
//        driver.findElement(By.partialLinkText("Dashboard")).click();
        Assert.assertEquals(getTitle(), "Dashboard • prestashop-automation");
    }

    @Test
    public void returnToLoginPage() {
        //exit from the dashboard panel page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#header_logout")).click();
//Check of returning to the Login page
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
//        System.out.println("Page title is: " + driver.getTitle());
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
    }

//close browser
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}