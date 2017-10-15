package ua.com.qatestlab.lecture_4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ua.com.qatestlab.lecture_4.pages.MakeProductPage.newProductName;
import static ua.com.qatestlab.lecture_4.pages.MakeProductPage.newProductQuantity;
import static ua.com.qatestlab.lecture_4.pages.MakeProductPage.newProductPrice;

public class NewProductPage {
    private final EventFiringWebDriver driver;
    private final By currentName = By.cssSelector("h1.h1");
    private final By currentPrice = By.cssSelector("div.current-price>span");
    private final By currentQuantity = By.cssSelector("div.product-quantities>span");

    public NewProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void checkProductName() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentName));
        WebElement name = driver.findElement(currentName);
        String currentName = name.getText().toLowerCase();
        Assert.assertEquals(newProductName, currentName);
        System.out.println("New product name is: " + currentName);
    }

    public void checkProductQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentQuantity));
        WebElement quantity = driver.findElement(currentQuantity);
        String currentQuantity = quantity.getText().substring(0, 2).trim();
        Assert.assertEquals(newProductQuantity, currentQuantity);
        System.out.println("New product quantity is: " + currentQuantity);
    }

    public void checkProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentPrice));
        WebElement price = driver.findElement(currentPrice);
//        String currentPrice = price.getText().substring(0, 5);
//        Assert.assertEquals(newProductPrice, currentPrice);
        String currentPrice = price.getAttribute("content").replace(".", ",");
        Assert.assertEquals(newProductPrice, currentPrice);
        System.out.println("New product price is: " + currentPrice);
    }
}
