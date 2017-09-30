package ua.com.qatestlab.temp.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private EventFiringWebDriver driver;
    private By logoutImage = By.cssSelector("span.employee_avatar_small");
    private By logoutButton = By.id("header_logout");
    private By ordersTab = By.id("subtab-AdminParentOrders");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void checkDasboardMenu() {
        driver.findElement(By.xpath("//*[@id='subtab-AdminParentOrders']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "Заказы • prestashop-automation");

//        driver.findElement(By.xpath("//*[@id='subtab-AdminCatalog']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "товары • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminParentCustomer']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Управление клиентами • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminParentCustomerThreads']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Customer Service • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminStats']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Статистика • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminParentModulesSf']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminParentThemes']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Шаблоны • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminParentShipping']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Курьеры • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminInternational']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Локализация • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-ShopParameters']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "General • prestashop-automation");
//
//        driver.findElement(By.xpath("//*[@id='subtab-AdminAdvancedParameters']/a/span")).click();
//        Assert.assertEquals(getTitle(driver), "Information • prestashop-automation");

        driver.findElement(By.xpath("//*[@id='tab-AdminDashboard']/a/span")).click();
        Assert.assertEquals(getTitle(driver), "Dashboard • prestashop-automation");
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

    public void clicklogoutButtonWithJS(){
        WebElement element = driver.findElement(logoutButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    public boolean scrollPageDown(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,50)");
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, document.body.scrollHeight);" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }

    public void selectOrdersItem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));

        WebElement orderTabElement = driver.findElement(ordersTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(orderTabElement).build().perform();

        orderTabElement.findElements(By.cssSelector("li")).get(0).click();
    }

}