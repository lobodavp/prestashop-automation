package ua.com.qatestlab.temp.tests;

import org.junit.Assert;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.temp.pages.DashboardPage;
import ua.com.qatestlab.temp.pages.LoginPage;

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
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return driver.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });

        dashboardPage.checkDasboardMenu();
        dashboardPage.scrollPageDown();
//        dashboardPage.selectOrdersItem();

        dashboardPage.clicklogoutButtonWithJS();
//        dashboardPage.clickLogoutImage();
//        dashboardPage.clicklogoutButton();
        System.out.println("Page title is: " + driver.getTitle());
        quitDriver(driver);
    }
}