package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LoginPage;
import selenium.SeleniumInitializer;

/**
 * Created by Keylin on 31/10/2015.
 */
public class LoginTest extends SeleniumInitializer{

    /**
     * This method verifies if user can login successfully
     * @param userEmail System user
     * @param userPassword System user password
     * @throws InterruptedException
     */
    @Parameters({"emailLogin", "passwordLogin"})
    @Test(groups = "login_test_auto")
    public void successfulTest(String userEmail, String userPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriverInstance());
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Page cannot load");
        loginPage.insertUser(userEmail);
        loginPage.insertPassword(userPassword);

        HomePage homePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isPageLoaded(), "Page cannot load");
    }

    /**
     * This method verifies if user can login successfully
     * @param userEmail System user
     * @param userPassword System user password
     * @throws InterruptedException
     */
    @Parameters({"emailLogin", "passwordLogin"})
    @Test(groups = "login_test")
    public void loginTestKeylin(String userEmail, String userPassword) throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriverInstance());
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Page cannot load");
        loginPage.insertUser(userEmail);
        loginPage.insertPassword(userPassword);

        HomePage homePage = loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isPageLoaded(), "Page cannot load");
    }
}
