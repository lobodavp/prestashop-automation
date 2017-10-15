package ua.com.qatestlab.lecture_4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static ua.com.qatestlab.lecture_4.pages.MakeProductPage.newProductName;

public class AllProductsPage {

    private final EventFiringWebDriver driver;
    private final By name = By.xpath("*//div[@class='product-description'] / h1 / a[text()='" + newProductName + "']");
    private final By nextLink = By.cssSelector("a.next.js-search-link");

    public AllProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    //todo the recursive calling of the method for a case more than one next page
    public void openNewProductPage() {
        scrollPageDown();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(nextLink));
        WebElement nextProductsPageLink = driver.findElement(nextLink);
        if (!nextProductsPageLink.isEnabled()) clickNewProductPageLink();
        else {
            clickNextProductsPageLink();
            clickNewProductPageLink();
        }
    }

    private void clickNextProductsPageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(nextLink));
        WebElement nextProductsPageLink = driver.findElement(nextLink);
        nextProductsPageLink.click();
    }

    private void clickNewProductPageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(name));
        Actions action = new Actions(driver);
        WebElement productName = driver.findElement(name);
        Assert.assertEquals(upperCaseFirst(newProductName), productName.getText());
        System.out.println("Product " + productName.getText() + " is shown at the " + driver.getTitle() + " page!");
        action.moveToElement(productName).click().perform();
    }

    private String upperCaseFirst(String value) {
        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }

    private boolean scrollPageDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, (-1000 + document.body.scrollHeight));" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }
}
