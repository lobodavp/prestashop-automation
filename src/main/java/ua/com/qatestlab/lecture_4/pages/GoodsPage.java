package ua.com.qatestlab.lecture_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoodsPage {
    private EventFiringWebDriver driver;
    private By addProductIcon = By.cssSelector("a#page-header-desc-configuration-add > span");

    public GoodsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickAddProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addProductIcon));
        WebElement addProductElement = driver.findElement(addProductIcon);
        addProductElement.click();
    }

}

