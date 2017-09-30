package ua.com.qatestlab.lecture_3.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_3.utils.Properties;
import ua.com.qatestlab.utils.EventHandler;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\web-drivers\\geckodriver.exe");
//                System.setProperty(
//                        "webdriver.gecko.driver",
//                        new File(ua.com.qatestlab.lecture_2.tests.BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath());
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
//                System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\web-drivers\\IEDriverServer.exe");
                System.setProperty(
                        "webdriver.ie.driver",
                        new File(BaseTest.class.getResource("/IEDriverServer.exe").getFile()).getPath());
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\web-drivers\\chromedriver.exe");
//                System.setProperty(
//                        "webdriver.chrome.driver",
//                        new File(ua.com.qatestlab.lecture_2.tests.BaseTest.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    public static WebDriver setupPage(WebDriver driver) {
        driver = new FirefoxDriver();
        // driver.navigate().to(Properties.getBaseAdminUrl());
        driver.get(Properties.getBaseAdminUrl());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //        System.out.println("Page title is: " + driver.getTitle());
        return driver;
    }

    public static WebDriver fillLoginPage(WebDriver driver) {
        driver.findElement(By.id("email")).sendKeys(Properties.getLogin());
        driver.findElement(By.id("passwd")).sendKeys(Properties.getPassword());
        driver.findElement(By.name("submitLogin")).submit();
        return driver;
    }

    public static WebDriver exitPage(WebDriver driver) {
        //exit from the dashboard panel page
        driver.findElement(By.className("employee_avatar_small")).click();
        driver.findElement(By.cssSelector("#header_logout")).click();
////Check of returning to the Login page
////        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
//        System.out.println("Page title is: " + driver.getTitle());
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
        return driver;
    }

    public static EventFiringWebDriver getConfiguredDriver(){
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);
        wrappedDriver.register(new EventHandler());
        return wrappedDriver;
    }

    public static void quitDriver(WebDriver driver){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

