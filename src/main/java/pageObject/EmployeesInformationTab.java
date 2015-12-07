package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keylin on 15/11/2015.
 */
public class EmployeesInformationTab extends HomePage {

    //Xpath
    private final By tabTitle = By.xpath("//div[@id='site_content']/div[@id='content']/h1[contains(text(),'Listing employees')]");
    private final By createNewEmployeeLink = By.xpath(("//div[@id='site_content']/div[@id='content']//a[contains(text(),'Create a new employee')]"));
    private final By createNewAdminTitle = By.xpath((".//div[@id='content']/h1[contains(text(),'New employee')]"));
    private final By firstName = By.id("employee_first_name");
    private final By lastName =By.id("employee_last_name");
    private final By email = By.id("employee_email");
    private final By identification = By.id("employee_identification");
    private final By leaderName = By.id("employee_leader_name");
    private final By startWorkingOnYear = By.id("employee_start_working_on_1i");
    private final By startWorkingOnMonth = By.id("employee_start_working_on_2i");
    private final By startWorkingOnDay = By.id("employee_start_working_on_3i");
    private final By createEmployeeButton = By.name("commit");
    private final String selectYear = "//select[@id='employee_start_working_on_1i']/option[text()='%s']";
    private final String selectMonth = "//select[@id='employee_start_working_on_2i']/option[text()='%s']";
    private final String selectDay = "//select[@id='employee_start_working_on_3i']/option[text()='%s']";

    public EmployeesInformationTab (WebDriver webDriver){
        super(webDriver);
    }
    /**
     * This method confirms if the page was loaded
     * @return True if the page was loaded, false if the page was not loaded.
     */
    public boolean isTabTitleDisplayed(){
        return webDriverCommands.waitForElement(tabTitle, 15);
    }

    /**
     * This method clicks "Create a new Admin User" link
     */
    public void clickCreateNewAdminUser() {
        webDriverCommands.click(createNewEmployeeLink);
    }

    /**
     * This method verifies if the "New Admin User" title is displayed
     * @return Returns true if title is displayed, false is title is not displayed
     */
    public boolean isCreateUserTitleDisplayed(){
        return webDriverCommands.waitForElement(createNewAdminTitle, 15);
    }

    /**
     * This method insert text in field
     * @param firstName Value for first name field
     */
    public void insertFirstName(String firstName){
        webDriverCommands.sendKeys(this.firstName, firstName);
    }

    /**
     * This method insert text in field
     * @param lastName Value for last name field
     */
    public void insertLastName(String lastName){
        webDriverCommands.sendKeys(this.lastName, lastName);
    }

    /**
     * This method insert text in field
     * @param email Value for email field
     */
    public void insertEmail(String email){
        webDriverCommands.sendKeys(this.email, email);
    }

    /**
     * This method insert text in field
     * @param identification Value for identification field
     */
    public void insertIdentification(String identification){
        webDriverCommands.sendKeys(this.identification, identification);
    }

    /**
     * This method insert text in field
     * @param leaderName Value for Leader Name field
     */
    public void insertLeaderName (String leaderName){
        webDriverCommands.sendKeys(this.leaderName, leaderName);
    }

    /**
     * This method selects a year from Start Working On year field
     * @param year Value to select
     */
    public void selectStartWorkingOnYear (String year){
        webDriverCommands.click(this.startWorkingOnYear);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
           e.getStackTrace();
        }
        webDriverCommands.click(By.xpath(String.format(this.selectYear,year)));
    }

    /**
     * This method selects a month from Start Working On month field
     * @param month Value to select
     */
    public void selectStartWorkingOnMonth (String month){
        webDriverCommands.click(this.startWorkingOnMonth);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        webDriverCommands.click(By.xpath(String.format(this.selectMonth,month)));
    }

    /**
     * This method selects a day from Start Working On day field
     * @param day Value to select
     */
    public void selectStartWorkingOnDay (String day){
        webDriverCommands.click(this.startWorkingOnDay);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        webDriverCommands.click(By.xpath(String.format(this.selectDay,day)));
    }

    /**
     * This method clicks the "Create Employee" button.
     */
    public void clickCreateEmployeeButton() {
        webDriverCommands.click(createEmployeeButton);
    }
}
