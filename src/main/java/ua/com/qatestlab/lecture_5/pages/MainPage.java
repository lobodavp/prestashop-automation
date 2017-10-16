package ua.com.qatestlab.lecture_5.pages;

import ua.com.qatestlab.lecture_5.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainPage {

    private final EventFiringWebDriver driver;
    private final By allProductsLink = By.cssSelector("section#content>section>a");

    public MainPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(Properties.getBaseMainUrl());
    }

    public void clickAllProductsLink() {
        driver.findElement(allProductsLink).click();
    }

}
