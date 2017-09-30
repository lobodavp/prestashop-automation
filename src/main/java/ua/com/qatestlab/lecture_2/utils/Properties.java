package ua.com.qatestlab.lecture_2.utils;

import org.openqa.selenium.remote.BrowserType;

public class Properties {
    private static final String DEFAULT_BASE_ADMIN_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private static final String DEFAULT_BROWSER = BrowserType.FIREFOX;
//    private static final String DEFAULT_BROWSER = BrowserType.CHROME;
    private static String LOGIN = "webinar.test@gmail.com";
    private static String PASSWORD = "Xcg7299bnSmMuRLp9ITw";

    public static String getBaseAdminUrl() {
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(), DEFAULT_BASE_ADMIN_URL);
    }

    public static String getLogin() {
        return LOGIN;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getBrowser() {
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }
}

/**
 * All parameters that are passed to automation project
 */
enum EnvironmentVariables {
    BASE_ADMIN_URL("env.admin.url"),
    BROWSER("browser");

    private String value;
    EnvironmentVariables(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

