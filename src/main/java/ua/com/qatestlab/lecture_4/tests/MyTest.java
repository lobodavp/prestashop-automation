package ua.com.qatestlab.lecture_4.tests;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_4.pages.*;

public class MyTest extends BaseTest {

    public static void main(String[] args) {

        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        System.out.println("Page title is: " + driver.getTitle());
        loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        dashboardPage.selectGoodsItem();

        GoodsPage goodsPage = new GoodsPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        goodsPage.clickAddProduct();

        MakeProductPage makeProductPage = new MakeProductPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        makeProductPage.fillNewProductInput();
        makeProductPage.clickProductQuantityLink();
        makeProductPage.fillProductQuantityInput();
        makeProductPage.clickPriceLink();
        makeProductPage.fillProductPriceInput();
        makeProductPage.activateProduct();
        makeProductPage.pushSaveProductButton();
    }
}
