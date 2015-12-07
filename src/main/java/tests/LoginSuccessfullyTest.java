package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.AdminUsers;
import pageObject.HomePage;
import pageObject.MyAccount;
import pageObject.VacationsLoginPage;
import selenium.SeleniumInitializer;

/**
 * Created by He on 9/27/2015.
 */

public class LoginSuccessfullyTest extends SeleniumInitializer {

        @Parameters({"email","user_password_tc_001"})
        @Test(groups = {"login_test_001"})

        public void loginSuccessfulLoginTest(String username, String password) throws InterruptedException {
            // Log in
            VacationsLoginPage vacationsLoginPage = new VacationsLoginPage(getDriverInstance());

            Assert.assertTrue(vacationsLoginPage.isTitleDisplayed(), "Page Cannot load");
            vacationsLoginPage.insert_user(username);
            vacationsLoginPage.insert_password(password);
            HomePage homePage = vacationsLoginPage.clickOnLoginButton();
            Assert.assertTrue(homePage.isLoginPageLoaded(), "Home Page Cannot Login");

        }

    @Parameters({"email","user_password_tc_001"})
    @Test(groups = {"login_test_001"})

    public void loginTestHellen(String username, String password) throws InterruptedException {
        // Log in
        VacationsLoginPage vacationsLoginPage = new VacationsLoginPage(getDriverInstance());

        Assert.assertTrue(vacationsLoginPage.isTitleDisplayed(), "Page Cannot load");
        vacationsLoginPage.insert_user(username);
        vacationsLoginPage.insert_password(password);
        HomePage homePage = vacationsLoginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isLoginPageLoaded(), "Home Page Cannot Login");

    }
}


