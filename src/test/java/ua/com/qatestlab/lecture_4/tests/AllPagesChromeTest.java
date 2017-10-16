package ua.com.qatestlab.lecture_4.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AllPagesChromeTest {
    private WebDriver driver;
    private static final int PRODUCT_NAME_LENGTH = 8;
    private static final int PRODUCT_QUANTITY_LENGTH = 2;
    private static String newProductName;
    private static String newProductPrice;
    private static String newProductQuantity;

    @Parameters(value = {"pChromeProp", "pChromeFile"})
    @BeforeClass
    public void setup(String chromeProp, String chromeFile) {
        Reporter.log("Setup driver in the system property <br />");
        System.setProperty(chromeProp,
                new File(AllPagesChromeTest.class.getResource(chromeFile).getFile()).getPath());
        Reporter.log("Creating browser instance <br />");
        driver = new ChromeDriver();
        Reporter.log("Setup implicitlyWait<br />");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Reporter.log("Maximaze browser window <br />");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("Deleting all cookies <br />");
        driver.manage().deleteAllCookies();
        Reporter.log("Closing browser <br />");
        driver.quit();
    }

    //back-end
    @DataProvider
    public Object[][] getLoginData() {
        return new String[][]{
                {"http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/",
                        "webinar.test@gmail.com",
                        "Xcg7299bnSmMuRLp9ITw"}
        };
    }

    @Test(dataProvider = "getLoginData")
    public void loginTest(String url, String login, String password) {
        driver.get(url);
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
        Reporter.log("Filling email input <br />");
        driver.findElement(By.id("email")).sendKeys(login);
        Reporter.log("Filling password input <br />");
        driver.findElement(By.id("passwd")).sendKeys(password);
        Reporter.log("Clicking login button <br />");
        driver.findElement(By.name("submitLogin")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleContains("Dashboard"));
    }

    @Test(dependsOnMethods = "loginTest")
    public void dashboardTest() {
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#subtab-AdminCatalog")));
        WebElement tabElement = driver.findElement(By.cssSelector("#subtab-AdminCatalog"));
        Actions actions = new Actions(driver);
        actions.moveToElement(tabElement).build().perform();
        Reporter.log("Clicking products link in the menu bar <br />");
        tabElement.findElements(By.cssSelector("li")).get(0).click();
    }

    @Test(dependsOnMethods = "dashboardTest")
    public void productsPageTest() {
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#page-header-desc-configuration-add > span")));
        WebElement addProductElement = driver.findElement(By.cssSelector("a#page-header-desc-configuration-add > span"));
        Reporter.log("Clicking add product link <br />");
        addProductElement.click();
    }

    @Test(dependsOnMethods = "productsPageTest")
    public void makeProductPageTest() {
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
//fillNewProductNameInput
        Reporter.log("Filling product name input <br />");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form_step1_name_1")));
        WebElement productNameInputElement = driver.findElement(By.cssSelector("#form_step1_name_1"));
        productNameInputElement.sendKeys(getRandomProductName());

//clickProductQuantityLink
        Reporter.log("Clicking quantity link <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[@href='#step3']")));
        WebElement productQuantityInputLink = driver.findElement(By.xpath("*//a[@href='#step3']"));
        productQuantityInputLink.click();

//fillProductQuantityInput
        Reporter.log("Filling product quantity input <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#form_step3_qty_0")));
        WebElement productQuantityInputElement = driver.findElement(By.cssSelector("input#form_step3_qty_0"));
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.cssSelector("input#form_step3_qty_0"));
        action.doubleClick(element).perform();
        productQuantityInputElement.sendKeys(getRandomProductQuantity());

//clickPriceLink
        Reporter.log("Clicking price link <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[@href='#step2']")));
        WebElement productPriceLinkElement = driver.findElement(By.xpath("*//a[@href='#step2']"));
        productPriceLinkElement.click();

//fillProductPriceInput
        Reporter.log("Filling product price input <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form_step2_price")));
        WebElement productPriceInputElement = driver.findElement(By.cssSelector("#form_step2_price"));
        Actions action1 = new Actions(driver);
        WebElement element1 = driver.findElement(By.cssSelector("#form_step2_price"));
        action1.doubleClick(element1).perform();
        productPriceInputElement.sendKeys(getRandomProductPrice());

//activateProduct
        Reporter.log("Activating product <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.switch-input")));
        WebElement productActivateElement = driver.findElement(By.cssSelector("div.switch-input"));
        productActivateElement.click();
        closeConfirmationMessage();

//pushSaveProductButton
        Reporter.log("Pushing product button <br />");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div>button>span:nth-child(1)")));
        WebElement saveProductButtonElement = driver.findElement(By.cssSelector("div>button>span:nth-child(1)"));
        saveProductButtonElement.submit();
        Reporter.log("saveProductButton was pushed" + " <br />");
        closeConfirmationMessage();
    }

    @Test(dependsOnMethods = "makeProductPageTest")
    public void mainPageTest() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/");
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
//clickAllProductsLink
        Reporter.log("Clicking AllProducts page link <br />");
        driver.findElement(By.cssSelector("section#content>section>a")).click();
    }

    //front-end
    @Test(dependsOnMethods = "mainPageTest")
    public void allProductsPageTest() {
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
//openNewProductPage
        Reporter.log("Scrolling page down <br />");
        scrollPageDown();
        Reporter.log("Clicking product page link <br />");
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
        Reporter.log("Page title is: " + driver.getTitle() + " <br />");
//checkProductName
        Reporter.log("Check product name <br />");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1.h1")));
        WebElement name = driver.findElement(By.cssSelector("h1.h1"));
        String currentName = name.getText().toLowerCase();
        Assert.assertEquals(newProductName, currentName, "Wrong current name is shown at the product page!");
        Reporter.log("New product name is: " + currentName + " <br />");

//checkProductPrice
        Reporter.log("Check product price <br />");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.current-price>span")));
        WebElement price = driver.findElement(By.cssSelector("div.current-price>span"));
//        String currentPrice = price.getText().substring(0, 5);
//        Assert.assertEquals(newProductPrice, currentPrice);
        String currentPrice = price.getAttribute("content").replace(".", ",");
        Assert.assertEquals(newProductPrice, currentPrice, "Wrong current price is shown at the product page!");
        Reporter.log("New product price is: " + currentPrice + " <br />");

//checkProductQuantity
        Reporter.log("Check product quantity <br />");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.product-quantities>span")));
        WebElement quantity = driver.findElement(By.cssSelector("div.product-quantities>span"));
        String currentQuantity = quantity.getText().substring(0, 2).trim();
        Assert.assertEquals(newProductQuantity, currentQuantity, "Wrong current quantity is shown at the product page!");
        Reporter.log("New product quantity is: " + currentQuantity + " <br />");
    }

    //back-end
    private String getRandomProductName() {
        String s = "abcdefgh";
        StringBuilder productName = new StringBuilder();

        for (int i = 0; i < PRODUCT_NAME_LENGTH; i++) {
            productName.append(s.charAt(new Random().nextInt(s.length())));
        }

        newProductName = productName.toString();
        Reporter.log("New product name is: " + newProductName + " <br />");
        return newProductName;
    }

    private String getRandomProductQuantity() {
        String s = "0123456789";
        StringBuilder productQuantity = new StringBuilder();

        for (int i = 0; i < PRODUCT_QUANTITY_LENGTH; i++) {
            productQuantity.append(s.charAt(new Random().nextInt(s.length())));
        }
        if ("00" == productQuantity.toString()) getRandomProductQuantity();
        if ("0" == productQuantity.toString()) getRandomProductQuantity();

        newProductQuantity = productQuantity.toString();
        Reporter.log("Product quantity is: " + newProductQuantity + " <br />");
        return newProductQuantity;
    }

    private String getRandomProductPrice() {
        DecimalFormat df2 = new DecimalFormat(".##");
        double start = 0.1;
        double end = 100;
        double random = new Random().nextDouble();
        double price = start + (random * (end - start));
        newProductPrice = df2.format(price);
        Reporter.log("Product price is: " + newProductPrice + " <br />");
        return newProductPrice;
    }

    private void closeConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#growls>div>div:nth-child(1)")));
        Actions action = new Actions(driver);
        WebElement message = driver.findElement(By.cssSelector("#growls>div"));
        Reporter.log("Confirmation message 'Настройки обновлены.' was found, it has the text: " + message.getText() + " <br />");
        Assert.assertEquals("×\n" +
                "Настройки обновлены.", message.getText(), "Confirmation message 'Настройки обновлены.' isn't shown");
        WebElement messageX = driver.findElement(By.cssSelector("#growls>div>div:nth-child(1)"));
        Reporter.log("WebElement messageX was found, it has the text: " + messageX.getText() + " <br />");
        Assert.assertEquals("×", messageX.getText(), "WebElement messageX '×' isn't found");
        action.moveToElement(messageX).click().perform();
        Reporter.log("Confirmation message " + message.getText() + " closed" + " <br />");
    }

    //front-end
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
        Reporter.log("Product " + productName.getText() + " is shown at the " + driver.getTitle() + " page!" + " <br />");
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

    //common
    private boolean scrollPageDown() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        boolean scrollResult = (boolean) executor.executeScript(
                "var scrollBefore = $(window).scrollTop();" +
                        "window.scrollTo(scrollBefore, (-1000 + document.body.scrollHeight));" +
                        "return $(window).scrollTop() > scrollBefore;");
        return scrollResult;
    }
}
