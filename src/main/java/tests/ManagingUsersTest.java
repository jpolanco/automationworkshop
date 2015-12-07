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
 * Created by He on 11/18/2015.
 */



    public class ManagingUsersTest extends SeleniumInitializer{

    @Parameters({"email","user_password_tc_001","employeeFirstName", "employeeLastName", "employeeEmail" , "employeeID", "employeeIDConfirmation"})
    @Test(groups = {"login_test_002"})

    public void createNewUser (String username, String password, String firstName, String lastName, String email, String userID, String passwordConfirmation) throws InterruptedException {

        VacationsLoginPage vacationsLoginPage = new VacationsLoginPage(getDriverInstance());

        Assert.assertTrue(vacationsLoginPage.isTitleDisplayed(), "Page Cannot load");
        vacationsLoginPage.insert_user(username);
        vacationsLoginPage.insert_password(password);
        HomePage homePage = vacationsLoginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isLoginPageLoaded(), "Home Page Cannot Login");


        AdminUsers adminUsers = new AdminUsers(getDriverInstance());
        adminUsers.clickOnAdminUsersTab();
        Assert.assertTrue(adminUsers.isAdminTabLoaded(), "Administrative Users Tab Cannot load");

        adminUsers.clickOnCreateNewAdminUserLink();
        adminUsers.insertFirstName(firstName);
        adminUsers.insertLastName(lastName);
        adminUsers.insertUserEmail(email);
        adminUsers.insertDefaultPassword(userID);
        adminUsers.insertPasswordConfirmation(passwordConfirmation);
        adminUsers.clickOnCreateUserButton();

        Assert.assertTrue(adminUsers.wasAdminUserCreatedSuccessfully());
        System.out.println("User has been created successfully!");

    }

    @Parameters({"email","user_password_tc_001", "employeeEmail"})
    @Test(groups = {"login_test_002"}, dependsOnMethods = "createNewUser")

    public void destroyUserAccount(String username, String password, String email)throws InterruptedException {

        VacationsLoginPage vacationsLoginPage = new VacationsLoginPage(getDriverInstance());

        Assert.assertTrue(vacationsLoginPage.isTitleDisplayed(), "Page Cannot load");
        vacationsLoginPage.insert_user(username);
        vacationsLoginPage.insert_password(password);
        HomePage homePage = vacationsLoginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.isLoginPageLoaded(), "Home Page Cannot Login");

        AdminUsers adminUsers = new AdminUsers(getDriverInstance());
        adminUsers.clickOnAdminUsersTab();

        Assert.assertTrue(adminUsers.isAdminTabLoaded(), "Administrative Users Tab Cannot load");

        Assert.assertTrue(adminUsers.findUser(email), "User has not been found.");

        adminUsers.clickOnDestroyAccountLink(email);

        System.out.println("User has been removed successfully from the table.");


     }


}

   // @Test(groups = {"login_test_002"})
    //public void goToMyAccountTab(){

//        MyAccount myAccount = adminUsers.clickOnMyAccountTab();
  //      Assert.assertTrue(myAccount.isMyAccountTabLoaded(), "My Account Tab Cannot load");

    //}

//}

