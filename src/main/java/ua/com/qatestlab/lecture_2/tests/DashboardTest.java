package ua.com.qatestlab.lecture_2.tests;

import org.junit.Assert;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_2.pages.DashboardPage;
import ua.com.qatestlab.lecture_2.pages.LoginPage;

public class DashboardTest extends BaseTest {

    public static void main(String[] args) {
        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        loginPage.open();
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
        dashboardPage.checkDasboardMenu();
        dashboardPage.clickLogoutImage();
        dashboardPage.clicklogoutButton();

        System.out.println("Page title is: " + driver.getTitle());
        quitDriver(driver);
    }
}