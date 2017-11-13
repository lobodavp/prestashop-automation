package ua.com.qatestlab.lecture_4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        Assert.assertEquals(MakeProductPage.getNewProductName(), currentName);
        System.out.println("New product name is: " + currentName);
    }

    //todo string.format for one-digit price values ( from 0.01 till 9 ) to ( from 0.01 till 09)
    public void checkProductPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentPrice));
        WebElement price = driver.findElement(currentPrice);
//        String currentPrice = price.getText().substring(0, 5);
//        Assert.assertEquals(newProductPrice, currentPrice);
        String currentPrice = price.getAttribute("content").replace(".", ",");
        Assert.assertEquals(MakeProductPage.getNewProductPrice(), currentPrice);
        System.out.println("New product price is: " + currentPrice);
    }

    //todo string.format for one-digit quantity values ( from 1 till 9 ) to ( from 1 till 09)
    public void checkProductQuantity() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(currentQuantity));
        WebElement quantity = driver.findElement(currentQuantity);
        String currentQuantity = quantity.getText().substring(0, 2).trim();
        if (currentQuantity.startsWith("0")) currentQuantity.replace("0", "");

        Assert.assertEquals(MakeProductPage.getNewProductQuantity(), currentQuantity);
        System.out.println("New product quantity is: " + currentQuantity);
    }
}
