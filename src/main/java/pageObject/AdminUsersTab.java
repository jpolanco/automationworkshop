package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keylin on 01/11/2015.
 */
public class AdminUsersTab extends HomePage {

    //Xpath
    private final By tabTitle = By.xpath("//h1[contains(text(),'Listing All Administrative Users')]");
    private final By createNewAdminUser = By.xpath(("//div[@id='content']//a[contains(text(),'Create a new Admin user')]"));
    private final By createNewAdminTitle = By.xpath(("//div[@id='content']/h2[contains(text(),'New Admin User')]"));
    private final By firstName = By.id("user_first_name");
    private final By lastName = By.id("user_last_name");
    private final By email = By.id("user_email");
    private final By defaultPassword = By.id("user_password");
    private final By passwordConfirmation = By.id("user_password_confirmation");
    private final By createUserButton = By.name("commit");

    public AdminUsersTab(WebDriver webDriver){
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
        webDriverCommands.click(createNewAdminUser);
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
     * @param defaultPassword Value for default password field
     */
    public void insertDefaultPassword(String defaultPassword){
        webDriverCommands.sendKeys(this.defaultPassword, defaultPassword);
    }

    /**
     * This method insert text in field
     * @param passwordConfirmation Value for password confirmation field
     */
    public void insertConfirmPassword(String passwordConfirmation){
        webDriverCommands.sendKeys(this.passwordConfirmation, passwordConfirmation);
    }

    /**
     * This method clicks the "Create User" button.
     */
    public void clickCreateUserButton() {
        webDriverCommands.click(createUserButton);
    }
}
