package ua.com.qatestlab.lecture_4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.Reporter;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PagesTest {
    private WebDriver driver;
    private static final int PRODUCT_NAME_LENGTH = 8;
    private static final int PRODUCT_QUANTITY_LENGTH = 2;
    private static String newProductName;
    private static String newProductQuantity;
    private static String newProductPrice;

    @BeforeClass
    public void setup() {
        System.setProperty(
                "webdriver.chrome.driver",
                new File(PagesTest.class.getResource("/chromedriver.exe").getFile()).getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    public void loginTest() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        System.out.println("Page title is: " + driver.getTitle());
        driver.findElement(By.id("email")).sendKeys("webinar.test@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElement(By.name("submitLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        System.out.println("Page title is: " + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subtab-AdminCatalog")));
        WebElement tabElement = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tabElement).build().perform();
        tabElement.findElements(By.cssSelector("li")).get(0).click();
    }

    @Test(dependsOnMethods = "dashboardTest")
    public void productsPageTest() {
        System.out.println("Page title is: " + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#page-header-desc-configuration-add > span")));
        WebElement addProductElement = driver.findElement(By.cssSelector("a#page-header-desc-configuration-add > span"));
        addProductElement.click();
    }

    @Test(dependsOnMethods = "productsPageTest")
    public void makeProductPageTest() {
        System.out.println("Page title is: " + driver.getTitle());
//fillNewProductNameInput
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form_step1_name_1")));
        WebElement productNameInputElement = driver.findElement(By.cssSelector("#form_step1_name_1"));
        productNameInputElement.sendKeys(getRandomProductName());

//clickProductQuantityLink
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[@href='#step3']")));
        WebElement productQuantityInputLink = driver.findElement(By.xpath("*//a[@href='#step3']"));
        productQuantityInputLink.click();

//fillProductQuantityInput
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#form_step3_qty_0")));
        WebElement productQuantityInputElement = driver.findElement(By.cssSelector("input#form_step3_qty_0"));
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("input#form_step3_qty_0"));
        action.doubleClick(element).perform();
        productQuantityInputElement.sendKeys(getRandomProductQuantity());

//clickPriceLink
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[@href='#step2']")));
        WebElement productPriceLinkElement = driver.findElement(By.xpath("*//a[@href='#step2']"));
        productPriceLinkElement.click();

//fillProductPriceInput
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form_step2_price")));
        WebElement productPriceInputElement = driver.findElement(By.cssSelector("#form_step2_price"));
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.cssSelector("#form_step2_price"));
        action1.doubleClick(element1).perform();
        productPriceInputElement.sendKeys(getRandomProductPrice().toString());

//activateProduct
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.switch-input")));
        WebElement productActivateElement = driver.findElement(By.cssSelector("div.switch-input"));
        productActivateElement.click();
        closeConfirmationMessage();

//pushSaveProductButton
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div>button>span:nth-child(1)")));
        WebElement saveProductButtonElement = driver.findElement(By.cssSelector("div>button>span:nth-child(1)"));
        saveProductButtonElement.submit();
        System.out.println("saveProductButton was pushed");
        closeConfirmationMessage();
    }

    @Test(dependsOnMethods = "makeProductPageTest")
    public void mainPageTest() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/");
        System.out.println("Page title is: " + driver.getTitle());
//clickAllProductsLink
        driver.findElement(By.cssSelector("section#content>section>a")).click();
    }

    @Test(dependsOnMethods = "mainPageTest")
    public void allProductsPageTest() {
        System.out.println("Page title is: " + driver.getTitle());
//openNewProductPage
        scrollPageDown();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.next.js-search-link")));
        WebElement nextProductsPageLink = driver.findElement(By.cssSelector("a.next.js-search-link"));
        if (!nextProductsPageLink.isEnabled()) clickNewProductPageLink();
        else {
            clickNextProductsPageLink();
            clickNewProductPageLink();
        }
    }

    @Test(dependsOnMethods = "allProductsPageTest")
    public void newProductPageTest() {
        System.out.println("Page title is: " + driver.getTitle());
//checkProductName
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.h1")));
        WebElement name = driver.findElement(By.cssSelector("h1.h1"));
        String currentName = name.getText().toLowerCase();
        Assert.assertEquals(newProductName, currentName);
        System.out.println("New product name is: " + currentName);

//checkProductQuantity
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.product-quantities>span")));
        WebElement quantity = driver.findElement(By.cssSelector("div.product-quantities>span"));
        String currentQuantity = quantity.getText().substring(0, 2).trim();
        Assert.assertEquals(newProductQuantity, currentQuantity);
        System.out.println("New product quantity is: " + currentQuantity);

//checkProductPrice
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.current-price>span")));
        WebElement price = driver.findElement(By.cssSelector("div.current-price>span"));
//        String currentPrice = price.getText().substring(0, 5);
//        Assert.assertEquals(newProductPrice, currentPrice);
        String currentPrice = price.getAttribute("content").replace(".", ",");
        Assert.assertEquals(newProductPrice, currentPrice);
        System.out.println("New product price is: " + currentPrice);
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

    private void closeConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#growls>div>div:nth-child(1)")));
        Actions action = new Actions(driver);
        WebElement message = driver.findElement(By.cssSelector("#growls>div"));
        System.out.println("confirmation message has the text: " + message.getText());
        Assert.assertEquals("×\n" +
                "Настройки обновлены.", message.getText());
        WebElement messageX = driver.findElement(By.cssSelector("#growls>div>div:nth-child(1)"));
        System.out.println("messageX has the text: " + messageX.getText());
        Assert.assertEquals("×", messageX.getText());
        action.moveToElement(messageX).click().perform();
        System.out.println("confirmation message closed");
    }

    private void clickNextProductsPageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.next.js-search-link")));
        WebElement nextProductsPageLink = driver.findElement(By.cssSelector("a.next.js-search-link"));
        nextProductsPageLink.click();
    }

    private void clickNewProductPageLink() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//div[@class='product-description'] / h1 / a[text()='" + newProductName + "']")));
        Actions action = new Actions(driver);
        WebElement productName = driver.findElement(By.xpath("*//div[@class='product-description'] / h1 / a[text()='" + newProductName + "']"));
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
