package ua.com.qatestlab.lecture_5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private final EventFiringWebDriver driver;
    private final By catalogTab = By.cssSelector("#subtab-AdminCatalog");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void selectProductsItem() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        WebElement tabElement = driver.findElement(catalogTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(tabElement).build().perform();
        tabElement.findElements(By.cssSelector("li")).get(0).click();
    }
}