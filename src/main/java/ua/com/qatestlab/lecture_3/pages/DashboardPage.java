package ua.com.qatestlab.lecture_3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private EventFiringWebDriver driver;
    private By catalogTab = By.cssSelector("#subtab-AdminCatalog");

    public DashboardPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void selectCatalogItem() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(catalogTab));
        WebElement TabElement = driver.findElement(catalogTab);
        Actions actions = new Actions(driver);
        actions.moveToElement(TabElement).build().perform();
        TabElement.findElements(By.cssSelector("li")).get(1).click();
    }
}