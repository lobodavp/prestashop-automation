package ua.com.qatestlab.lecture_3.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCategoryPage {
    private EventFiringWebDriver driver;
    private By categoryNameInput = By.cssSelector("#name_1");
    private By saveNewCategoryButton = By.cssSelector(".process-icon-save");
    private By gotoCategoryList = By.cssSelector("#desc-category-back i");
    private By newCategoryConfirmation = By.xpath("*//div[@class='bootstrap'][2] /div");
    static final String newCategoryName = "New category";

    public AddCategoryPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void fillNewCategoryInput() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(categoryNameInput));
        WebElement categoryNameInputElement = driver.findElement(categoryNameInput);
        categoryNameInputElement.sendKeys(newCategoryName);
    }

    public boolean scrollPageDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //       executor.executeScript("window.scrollBy(1.0)");
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, document.body.scrollHeight);" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }

    public void pushSaveNewCategoryButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(saveNewCategoryButton));
        WebElement saveNewCategoryButtonElement = driver.findElement(categoryNameInput);
        saveNewCategoryButtonElement.submit();
    }

    public void checkConfirmationMessage() {
        WebElement newCategoryConfirmationElement = driver.findElement(newCategoryConfirmation);
        Assert.assertEquals("×\n" + "Создано", newCategoryConfirmationElement.getText());
        System.out.println("Confirmation message is present at the page: " + driver.getTitle());
    }

    public void gotoCategoryList() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(gotoCategoryList));
        WebElement gotoCategoryListElement = driver.findElement(gotoCategoryList);
        gotoCategoryListElement.click();
    }
}
