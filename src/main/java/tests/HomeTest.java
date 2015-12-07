package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.*;
import selenium.SeleniumInitializer;

/**
 * Created by Keylin on 01/11/2015.
 */
public class HomeTest extends SeleniumInitializer {

    /**
     * This method verifies if tab switching is successful
     * @param emailLogin System user
     * @param passwordLogin System user password
     * @throws InterruptedException
     */
    @Parameters({"emailLogin", "passwordLogin"})
    @Test(groups = "home_test_tab_switching")
    public void successfulTest (String emailLogin, String passwordLogin) throws InterruptedException{
        //Log in
        LoginPage loginPage = new LoginPage(getDriverInstance());
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Page cannot load");
        loginPage.insertUser(emailLogin);
        loginPage.insertPassword(passwordLogin);

        //Clicking each tab
        HomePage homePage = new HomePage(getDriverInstance());

        AdminUsersTab adminUsersTab = (AdminUsersTab)homePage.clickMenuTab("AdminUser");
        Assert.assertTrue(adminUsersTab.isTabTitleDisplayed(), "Tab cannot load");

        MyAccountTab myAccountTab = (MyAccountTab) homePage.clickMenuTab("MyAccount");
        Assert.assertTrue(myAccountTab.isTitleDisplayed(), "Tab cannot load");
    }

    /**
     * This method creates a Admin User
     * @param emailLogin System user
     * @param passwordLogin System user password
     * @throws InterruptedException
     */
    @Parameters({"emailLogin", "passwordLogin", "administrativeUsersTabOption", "firstNameAdminUser", "lastNameAdminUser",
            "emailAdminUser", "defaultPasswordAdminUser", "passwordConfirmationAdminUser"})
    @Test(groups = "home_test_create_admin_user")
    public void createAdminUser (String emailLogin, String passwordLogin, String administrativeUsersTabOption, String firstNameAdminUser, String lastNameAdminUser,
                                 String emailAdminUser, String defaultPasswordAdminUser, String passwordConfirmationAdminUser) throws InterruptedException{
        //Log in
        LoginPage loginPage = new LoginPage(getDriverInstance());
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Page cannot load");
        loginPage.insertUser(emailLogin);
        loginPage.insertPassword(passwordLogin);

        //Clicking admin users tab
        HomePage homePage = loginPage.clickOnLoginButton();
        AdminUsersTab adminUsersTab = (AdminUsersTab)homePage.clickMenuTab(administrativeUsersTabOption);
        Assert.assertTrue(adminUsersTab.isTabTitleDisplayed(), "Tab cannot load");

        //Creating a user
        adminUsersTab.clickCreateNewAdminUser();
        Assert.assertTrue(adminUsersTab.isCreateUserTitleDisplayed(), "'Create user' fields cannot load");
        adminUsersTab.insertFirstName(firstNameAdminUser);
        adminUsersTab.insertLastName(lastNameAdminUser);
        adminUsersTab.insertEmail(emailAdminUser);
        adminUsersTab.insertDefaultPassword(defaultPasswordAdminUser);
        adminUsersTab.insertConfirmPassword(passwordConfirmationAdminUser);

        adminUsersTab.clickCreateUserButton();
    }

    /**
     * This method creates a Admin User
     * @param emailLogin System user
     * @param passwordLogin System user password
     * @throws InterruptedException
     */
    @Parameters({"emailLogin", "passwordLogin", "employeesInformationTabOption","firstNameEmployeeUser", "lastNameEmployeeUser",
            "emailEmployeeUser", "identificationEmployeeUser", "leadNameEmployeeUser", "startWorkingOnYearEmployeeUser",
            "startWorkingOnMonthEmployeeUser", "startWorkingOnDayEmployeeUser"})
    @Test(groups = "home_test_create_employee")
    public void createEmployee (String emailLogin, String passwordLogin, String employeesInformationTabOption, String firstNameEmployeeUser, String lastNameEmployeeUser,
                                String emailEmployeeUser, String identificationEmployeeUser, String leadNameEmployeeUser,
                                String startWorkingOnYearEmployeeUser, String startWorkingOnMonthEmployeeUser, String startWorkingOnDayEmployeeUser) throws InterruptedException {
        //Log in
        LoginPage loginPage = new LoginPage(getDriverInstance());
        Assert.assertTrue(loginPage.isTitleDisplayed(), "Page cannot load");
        loginPage.insertUser(emailLogin);
        loginPage.insertPassword(passwordLogin);

        //Clicking admin users tab
        HomePage homePage = loginPage.clickOnLoginButton();
        EmployeesInformationTab employeesInformationTab = (EmployeesInformationTab) homePage.clickMenuTab(employeesInformationTabOption);
        Assert.assertTrue(employeesInformationTab.isTabTitleDisplayed(), "Tab cannot load");

        //Creating a user
        employeesInformationTab.clickCreateNewAdminUser();
        Assert.assertTrue(employeesInformationTab.isCreateUserTitleDisplayed(), "'Create employee user' fields cannot load");
        employeesInformationTab.insertFirstName(firstNameEmployeeUser);
        employeesInformationTab.insertLastName(lastNameEmployeeUser);
        employeesInformationTab.insertEmail(emailEmployeeUser);
        employeesInformationTab.insertIdentification(identificationEmployeeUser);
        employeesInformationTab.insertLeaderName(leadNameEmployeeUser);
        employeesInformationTab.selectStartWorkingOnYear(startWorkingOnYearEmployeeUser);
        employeesInformationTab.selectStartWorkingOnMonth(startWorkingOnMonthEmployeeUser);
        employeesInformationTab.selectStartWorkingOnDay(startWorkingOnDayEmployeeUser);

        employeesInformationTab.clickCreateEmployeeButton();
    }
}
