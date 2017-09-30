package ua.com.qatestlab.lecture_2.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_2.utils.Properties;
import ua.com.qatestlab.utils.EventHandler;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver getDriver() {
        String browser = Properties.getBrowser();
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\web-drivers\\geckodriver.exe");
                return new FirefoxDriver();
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\web-drivers\\chromedriver.exe");
                return new ChromeDriver();
        }
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

