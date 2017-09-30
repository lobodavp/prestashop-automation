package ua.com.qatestlab.lecture_2.tests;

import org.junit.Assert;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_2.pages.DashboardPage;
import ua.com.qatestlab.lecture_2.pages.LoginPage;

public class Login_Logut_Test extends BaseTest {

    public static void main(String[] args) {
        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        System.out.println("Page title is: " + driver.getTitle());
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        System.out.println("Page title is: " + driver.getTitle());
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickLogoutImage();
        dashboardPage.clicklogoutButton();
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");

        quitDriver(driver);
    }
}