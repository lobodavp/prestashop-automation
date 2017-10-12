package ua.com.qatestlab.lecture_4.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {
    private EventFiringWebDriver driver;
    private By addCategoryIcon = By.cssSelector(".process-icon-new");
    private By filterCategoryByName = By.cssSelector("#table-category tr th:nth-child(3) a > .icon-caret-up");
    private By newCategory = By.xpath("*//td[contains(text(),'New category')]");

    public CategoriesPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void clickAddCategory() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(addCategoryIcon));
        WebElement addCategoryElement = driver.findElement(addCategoryIcon);
        addCategoryElement.click();
    }

    public void sortCategoryByName() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(filterCategoryByName));
        WebElement filterByNameElement = driver.findElement(filterCategoryByName);
        filterByNameElement.click();
        WebElement createdCategory = driver.findElement(newCategory);
        System.out.println("New category name: " + createdCategory.getText());
        Assert.assertEquals(createdCategory.getText(), AddCategoryPage.newCategoryName);
    }
}
