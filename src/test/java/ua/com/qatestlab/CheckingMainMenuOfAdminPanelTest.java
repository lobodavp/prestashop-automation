package ua.com.qatestlab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CheckingMainMenuOfAdminPanelTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        // Go to login page
//        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        // Find the text input element by its id "email" and fill in "webinar.test@gmail.com"
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        // Find the text input element by its id "passwd" and fill in "Xcg7299bnSmMuRLp9ITw"
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        // Click "submitLogin" button
        driver.findElement(By.name("submitLogin")).submit();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void menuOrdersCheck() {
        //Click "Orders"
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentOrders']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Заказы • prestashop-automation"
        Assert.assertEquals(header, "Заказы • prestashop-automation");
    }

    @Test
    public void menuCustomersCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomer']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Управление клиентами • prestashop-automation"
        Assert.assertEquals(header, "Управление клиентами • prestashop-automation");
    }

@Test
public void menuCustomerServiceCheck() {
    driver.findElement(By.xpath(".//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    // Get text from header of the current page
    String header = driver.getTitle();
    System.out.println("Page title is: " + header);
    // refresh current page
    driver.navigate().refresh();
    driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
    header = driver.getTitle();
    // Verify that header equals "Customer Service • prestashop-automation"
    Assert.assertEquals(header, "Customer Service • prestashop-automation");
}

    @Test
    public void menuCatalogCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminCatalog']/a/span")).click();
      //  driver.findElement(By.partialLinkText("Каталог")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "товары • prestashop-automation"
        Assert.assertEquals(header, "товары • prestashop-automation");
    }

    @Test
    public void menuStatisticCheck() {
        driver.findElement(By.partialLinkText("Статистика")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Статистика • prestashop-automation"
        Assert.assertEquals(header, "Статистика • prestashop-automation");
    }

    @Test
    public void menuModulesCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "prestashop-automation"
        Assert.assertEquals(header, "prestashop-automation");
    }

    @Test
    public void menuDesignCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentThemes']/a/span")).click();
        driver.findElement(By.partialLinkText("Design")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Шаблоны • prestashop-automation"
        Assert.assertEquals(header, "Шаблоны • prestashop-automation");
    }

    @Test
    public void menuDeliveryCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-AdminParentShipping']/a/span")).click();
        driver.findElement(By.partialLinkText("Доставка")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Курьеры • prestashop-automation"
        Assert.assertEquals(header, "Курьеры • prestashop-automation");
    }

    @Test
    public void menuLocalizationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminInternational']/a/span")).click();
//        driver.findElement(By.partialLinkText("International")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Локализация • prestashop-automation"
        Assert.assertEquals(header, "Локализация • prestashop-automation");
    }

    @Test
    public void menuShopParametersCheck() {
//        driver.findElement(By.xpath(".//*[@id='subtab-ShopParameters']/a/span")).click();
        driver.findElement(By.partialLinkText("Parameters")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "General • prestashop-automation"
        Assert.assertEquals(header, "General • prestashop-automation");
    }

    @Test
    public void menuConfigurationCheck() {
        driver.findElement(By.xpath(".//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        driver.findElement(By.partialLinkText("Конфигурация")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Information • prestashop-automation"
        Assert.assertEquals(header, "Information • prestashop-automation");
    }

    @Test
    public void menuDashboardCheck() {
        //Click "Dashboard"
        driver.findElement(By.xpath(".//*[@id='tab-AdminDashboard']/a/span")).click();
//        driver.findElement(By.partialLinkText("Dashboard")).click();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        // Get text from header of the current page
        String header = driver.getTitle();
        System.out.println("Page title is: " + header);
        // refresh current page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
        header = driver.getTitle();
        // Verify that header equals "Dashboard • prestashop-automation"
        Assert.assertEquals(header, "Dashboard • prestashop-automation");
    }

    @AfterClass
    public void tearDown() {
        // Close all browser windows and safely end the session
        if (driver != null) driver.quit();
    }

}