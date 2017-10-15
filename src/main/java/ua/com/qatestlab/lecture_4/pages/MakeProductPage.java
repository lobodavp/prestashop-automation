package ua.com.qatestlab.lecture_4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.Random;

public class MakeProductPage {
    private EventFiringWebDriver driver;
    private By productNameInput = By.cssSelector("#form_step1_name_1");
    private By productQuantityLink = By.xpath("*//a[@href='#step3']");
    private By productQuantityInput = By.cssSelector("input#form_step3_qty_0");
    private By productPriceLink = By.xpath("*//a[@href='#step2']");
    private By productPriceInput = By.cssSelector("#form_step2_price");
    //    private By productActivation = By.cssSelector("div.col-lg-5>div");
    private By productActivation = By.cssSelector("div.switch-input");
    private By confirmationMessage = By.cssSelector("#growls>div");
    private By confirmationMessageX = By.cssSelector("#growls>div>div:nth-child(1)");
    private By saveProductButton = By.cssSelector("div>button>span:nth-child(1)");
    private static final int PRODUCT_NAME_LENGTH = 8;
    private static final int PRODUCT_QUANTITY_LENGTH = 2;
    static String newProductName;
    static String newProductQuantity;
    static String newProductPrice;

    public MakeProductPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void fillNewProductNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productNameInput));
        WebElement productNameInputElement = driver.findElement(productNameInput);
        productNameInputElement.sendKeys(getRandomProductName());
    }

    private String getRandomProductName() {
        String s = "abcdefgh";
        StringBuffer productName = new StringBuffer();

        for (int i = 0; i < PRODUCT_NAME_LENGTH; i++) {
            productName.append(s.charAt(new Random().nextInt(s.length())));
        }

        newProductName = productName.toString();
        System.out.println("New product name is: " + newProductName);
        return newProductName;
    }

    public void clickProductQuantityLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productQuantityLink));
        WebElement productQuantityInputLink = driver.findElement(productQuantityLink);
        productQuantityInputLink.click();
    }

    public void fillProductQuantityInput() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productQuantityInput));
        WebElement productQuantityInputElement = driver.findElement(productQuantityInput);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(productQuantityInput);
        action.doubleClick(element).perform();
        productQuantityInputElement.sendKeys(getRandomProductQuantity());
    }

    private String getRandomProductQuantity() {
        String s = "0123456789";
        StringBuffer productQuantity = new StringBuffer();

        for (int i = 0; i < PRODUCT_QUANTITY_LENGTH; i++) {
            productQuantity.append(s.charAt(new Random().nextInt(s.length())));
        }
        if (productQuantity.toString() == "00") getRandomProductQuantity();
        if (productQuantity.toString() == "0") getRandomProductQuantity();

        newProductQuantity = productQuantity.toString();
        System.out.println("Product quantity is: " + newProductQuantity);
        return newProductQuantity;
    }

    public void clickPriceLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productPriceLink));
        WebElement productPriceLinkElement = driver.findElement(productPriceLink);
        productPriceLinkElement.click();
    }

    public void fillProductPriceInput() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productPriceInput));
        WebElement productPriceInputElement = driver.findElement(productPriceInput);
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(productPriceInput);
        action.doubleClick(element).perform();
        productPriceInputElement.sendKeys(getRandomProductPrice().toString());
    }

    private String getRandomProductPrice() {
        DecimalFormat df2 = new DecimalFormat(".##");
        double start = 0.1;
        double end = 100;
        double random = new Random().nextDouble();
        double price = start + (random * (end - start));
        newProductPrice = df2.format(price);
        System.out.println("Product price is: " + newProductPrice);
        return newProductPrice;
    }

    public void activateProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(productActivation));
        WebElement productActivateElement = driver.findElement(productActivation);
        productActivateElement.click();
        closeConfirmationMessage();
    }

    public void pushSaveProductButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(saveProductButton));
        WebElement saveProductButtonElement = driver.findElement(saveProductButton);
        saveProductButtonElement.submit();
        System.out.println("saveProductButton was pushed");
        closeConfirmationMessage();
    }

    private void closeConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(confirmationMessageX));
        Actions action = new Actions(driver);
        WebElement message = driver.findElement(confirmationMessage);
        System.out.println("confirmation message has the text: " + message.getText());
        Assert.assertEquals("×\n" +
                "Настройки обновлены.", message.getText());
        WebElement messageX = driver.findElement(confirmationMessageX);
        System.out.println("messageX has the text: " + messageX.getText());
        Assert.assertEquals("×", messageX.getText());
        action.moveToElement(messageX).click().perform();
        System.out.println("confirmation message closed");
    }

}
