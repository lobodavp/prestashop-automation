package ua.com.qatestlab.lecture_4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_4.utils.Properties;

public class LoginPage {
    private EventFiringWebDriver driver;
    private By emailInput = By.id("email");
    private By passwordInput = By.id("passwd");
    private By loginBtn = By.name("submitLogin");

    public LoginPage(EventFiringWebDriver driver){ this.driver = driver; }

    public void open(){ driver.get(Properties.getBaseAdminUrl()); }

    public void fillEmailInput(){ driver.findElement(emailInput).sendKeys(Properties.getLogin()); }

    public void fillPasswordInput(){ driver.findElement(passwordInput).sendKeys(Properties.getPassword()); }

    public void clickLoginButton(){ driver.findElement(loginBtn).click(); }
}