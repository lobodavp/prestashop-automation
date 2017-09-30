package ua.com.qatestlab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions. elementToBeClickable(logoutImage));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("window.scrollBy(0,250)");
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