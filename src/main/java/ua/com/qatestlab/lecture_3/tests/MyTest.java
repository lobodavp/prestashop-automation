package ua.com.qatestlab.lecture_3.tests;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import ua.com.qatestlab.lecture_3.pages.CategoriesPage;
import ua.com.qatestlab.lecture_3.pages.LoginPage;
import ua.com.qatestlab.lecture_3.pages.AddCategoryPage;
import ua.com.qatestlab.lecture_3.pages.DashboardPage;

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
        dashboardPage.selectCatalogItem();

        CategoriesPage categoriesPage = new CategoriesPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        categoriesPage.clickAddCategory();

        AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
        System.out.println("Page title is: " + driver.getTitle());
        addCategoryPage.fillNewCategoryInput();
        addCategoryPage.scrollPageDown();
        addCategoryPage.pushSaveNewCategoryButton();
        addCategoryPage.gotoCategoryList();

        System.out.println("Page title is: " + driver.getTitle());
        categoriesPage.sortCategoryByName();
    }
}
