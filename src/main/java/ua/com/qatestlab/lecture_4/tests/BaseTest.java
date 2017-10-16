package ua.com.qatestlab.lecture_4.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_4.utils.Properties;
import ua.com.qatestlab.lecture_4.utils.EventHandler;

import java.io.File;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "firefox":
//                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\web-drivers\\geckodriver.exe");
                System.setProperty(
                        "webdriver.gecko.driver",
                        new File(BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath());
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
//                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\web-drivers\\chromedriver.exe");
                System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseTest.class.getResource("/chromedriver.exe").getFile()).getPath());
                return new ChromeDriver();
        }
    }

    public static EventFiringWebDriver getConfiguredDriver() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);
        wrappedDriver.register(new EventHandler());
        return wrappedDriver;
    }

    public static void quitDriver(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

