package ua.com.qatestlab.lecture_5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private final EventFiringWebDriver driver;
    private final By addProductIcon = By.cssSelector("a#page-header-desc-configuration-add > span");

    public ProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickAddProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addProductIcon));
        WebElement addProductElement = driver.findElement(addProductIcon);
        addProductElement.click();
    }

}

