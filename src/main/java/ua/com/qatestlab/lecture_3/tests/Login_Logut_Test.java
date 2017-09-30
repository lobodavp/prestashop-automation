package ua.com.qatestlab.lecture_3.tests;

import org.junit.Assert;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_3.pages.DashboardPage;
import ua.com.qatestlab.lecture_3.pages.LoginPage;

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
        Assert.assertEquals(driver.getTitle(), "prestashop-automation > Панель администратора (PrestaShop™)");
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return driver.getTitle().toLowerCase().startsWith("prestashop");
//            }
//        });
        System.out.println("Page title is: " + driver.getTitle());

        //dashboardPage.scrollPageDown();
        //dashboardPage.selectOrdersItem();
        //dashboardPage.clicklogoutButtonWithJS();
        //dashboardPage.clickLogoutImage();
        //dashboardPage.clicklogoutButton();

        quitDriver(driver);
    }
}