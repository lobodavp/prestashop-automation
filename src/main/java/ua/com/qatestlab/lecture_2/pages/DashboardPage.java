package ua.com.qatestlab.lecture_2.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private EventFiringWebDriver driver;
    private By logoutImage = By.cssSelector("span.employee_avatar_small");
    private By logoutButton = By.id("header_logout");
    private By ordersTab = By.id("subtab-AdminParentOrders");

    private By dashboard = By.xpath("//*[@id='tab-AdminDashboard']/a/span");
    private String dashboardAssert = "Dashboard • prestashop-automation";
    private By orders = By.xpath("//*[@id='subtab-AdminParentOrders']/a/span");
    private String ordersAssert = "Заказы • prestashop-automation";
    private By goods = By.xpath("//*[@id='subtab-AdminCatalog']/a/span");
    private String goodsAssert = "товары • prestashop-automation";
    private By clients = By.xpath("//*[@id='subtab-AdminParentCustomer']/a/span");
    private String clientsAssert = "Управление клиентами • prestashop-automation";
    private By service = By.xpath("//*[@id='subtab-AdminParentCustomerThreads']/a/span");
    private String serviceAssert = "Customer Service • prestashop-automation";
    private By statistic = By.xpath("//*[@id='subtab-AdminStats']/a/span");
    private String statisticAssert = "Статистика • prestashop-automation";
    private By modules = By.xpath("//*[@id='subtab-AdminParentModulesSf']/a/span");
    private String modulesAssert = "prestashop-automation";
    private By design = By.xpath("//*[@id='subtab-AdminParentThemes']/a/span");
    private String designAssert = "Шаблоны • prestashop-automation";
    private By delivery = By.xpath("//*[@id='subtab-AdminParentShipping']/a/span");
    private String deliveryAssert = "Курьеры • prestashop-automation";
    private By payment = By.xpath("//*[@id='subtab-AdminParentPayment']/a/span");
    private String paymentlAssert = "Payment Methods • prestashop-automation";
    private By international = By.xpath("//*[@id='subtab-AdminInternational']/a/span");
    private String internationalAssert = "Локализация • prestashop-automation";
    private By shopParameters = By.xpath("//*[@id='subtab-ShopParameters']/a/span");
    private String shopParametersAssert = "General • prestashop-automation";
    private By configuration = By.xpath("//*[@id='subtab-AdminAdvancedParameters']/a/span");
    private String configurationAssert = "Information • prestashop-automation";

    public void checkDasboardMenuItems() {

        driver.findElement(dashboard).click();
        Assert.assertEquals(getTitle(driver), dashboardAssert);

        driver.findElement(orders).click();
        Assert.assertEquals(getTitle(driver), ordersAssert);

        driver.findElement(goods).click();
        Assert.assertEquals(getTitle(driver), goodsAssert);

        driver.findElement(clients).click();
        Assert.assertEquals(getTitle(driver), clientsAssert);

        driver.findElement(service).click();
        Assert.assertEquals(getTitle(driver), serviceAssert);

        driver.findElement(statistic).click();
        Assert.assertEquals(getTitle(driver), statisticAssert);

        driver.findElement(modules).click();
        Assert.assertEquals(getTitle(driver), modulesAssert);

        driver.findElement(design).click();
        Assert.assertEquals(getTitle(driver), designAssert);

        driver.findElement(delivery).click();
        Assert.assertEquals(getTitle(driver), deliveryAssert);

        driver.findElement(payment).click();
        Assert.assertEquals(getTitle(driver), paymentlAssert);

        driver.findElement(international).click();
        Assert.assertEquals(getTitle(driver), internationalAssert);

        driver.findElement(shopParameters).click();
        Assert.assertEquals(getTitle(driver), shopParametersAssert);

        driver.findElement(configuration).click();
        Assert.assertEquals(getTitle(driver), configurationAssert);
    }

    public DashboardPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    private String getTitle(WebDriver driver) {
        driver.navigate().refresh();
        System.out.println("Page title after refreshing is: " + driver.getTitle());
        return driver.getTitle();
    }

    public void clickLogoutImage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));
        driver.findElement(logoutImage).click();
    }

    public void clicklogoutButton(){
        driver.findElement(logoutButton).click();
    }

 }