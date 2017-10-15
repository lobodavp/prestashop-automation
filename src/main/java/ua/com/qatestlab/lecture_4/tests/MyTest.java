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

        ProductsPage productsPage = new ProductsPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        productsPage.clickAddProduct();

        MakeProductPage makeProductPage = new MakeProductPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        makeProductPage.fillNewProductNameInput();
        makeProductPage.clickProductQuantityLink();
        makeProductPage.fillProductQuantityInput();
        makeProductPage.clickPriceLink();
        makeProductPage.fillProductPriceInput();
        makeProductPage.activateProduct();
        makeProductPage.pushSaveProductButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        System.out.println("Page title is: " + driver.getTitle());
        mainPage.clickAllProductsLink();

        AllProductsPage allProductsPage = new AllProductsPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        allProductsPage.openNewProductPage();

        NewProductPage newProductPage = new NewProductPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        newProductPage.checkProductName();
        newProductPage.checkProductQuantity();
        newProductPage.checkProductPrice();
    }
}
