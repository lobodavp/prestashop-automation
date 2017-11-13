package ua.com.qatestlab.lecture_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private final EventFiringWebDriver driver;
    private final By addProductIcon = By.cssSelector("a#page-header-desc-configuration-add > span");
    private final By groupActions = By.cssSelector("#product_bulk_menu");
    private final By deleteAllAction = By.cssSelector("div.btn-group.open .dropdown-menu>a.dropdown-item:nth-child(6)");
    private final By confirmButton = By.cssSelector(".modal-footer button.btn.btn-primary.btn-lg");

    public ProductsPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickAddProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addProductIcon));
        WebElement addProductElement = driver.findElement(addProductIcon);
        addProductElement.click();
    }

    public boolean scrollPageDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, document.body.scrollHeight);" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }

    public void selectCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String checkboxLocator = getCheckboxLocator();
        System.out.println("selectCheckbox method - Checkbox locator is :" + checkboxLocator);
        By checkboxOfNewProduct = By.xpath(checkboxLocator);
//        wait.until(ExpectedConditions.elementToBeClickable(checkboxOfNewProduct));
        wait.until(ExpectedConditions.presenceOfElementLocated(checkboxOfNewProduct));
        WebElement checkbox = driver.findElement(checkboxOfNewProduct);
        System.out.println("selectCheckbox method going to select the new product with the name: " + MakeProductPage.getNewProductName());
        checkbox.click();
        System.out.println("Checkbox with the new product name: " + MakeProductPage.getNewProductName() + " is selected!");
    }

    //creation locator using the generated newProductName in the MakeProductPage and xpath
    private String getCheckboxLocator() {
        String checkboxLocator = "//*[text()='" + MakeProductPage.getNewProductName() + "']/../../descendant::input";
        System.out.println("getCheckboxLocator method - checkbox locator is: " + checkboxLocator);
        return checkboxLocator;
    }

    public boolean scrollPageUp() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean scrollResult = (boolean) executor.executeScript(
                "window.scrollTo(document.body.scrollHeight, 0);" +
                        "return $(window).scrollTop() == 0;");
        return scrollResult;
    }

    public void clickGroupActions() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(groupActions));
        WebElement groupActionsElement = driver.findElement(groupActions);
        groupActionsElement.click();
        System.out.println("clickGroupActions method - groupActionsElement clicked!");
    }

    public void clickDeleteAllAction() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.switchTo();
        System.out.println("clickDeleteAllAction method - switched to window");
        wait.until(ExpectedConditions.elementToBeClickable(deleteAllAction));
        WebElement deleteAllActionElement = driver.findElement(deleteAllAction);
        deleteAllActionElement.click();
    }

    public void clickConfirmButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.switchTo();
        System.out.println("clickConfirmButton method - switched to window");
        wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        WebElement confirmButtonElement = driver.findElement(confirmButton);
        confirmButtonElement.click();
    }
}

