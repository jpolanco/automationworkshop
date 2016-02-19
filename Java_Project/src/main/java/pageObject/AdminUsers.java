package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.WebDriverCommands;

/**
 * Created by He on 10/17/2015.
 */
public class AdminUsers extends PageObject {

    private final By ADMINISTRATIVE_USERS_TAB = By.xpath("//ul[@id='menu']//li[2]//a");

    private final By ADMIN_TAB_LOADED = By.xpath("//div[@id='content']/h1[text()='Listing All Administrative Users']");

    private final By MY_ACCOUNT_TAB = By.xpath("//ul[@id='menu']//li[3]//a");

    private final By CREATE_NEW_ADMIN_USER_LINK = By.xpath("//a[text() = 'Create a new Admin user']");

    private final By FIRST_NAME_TEXT_FIELD = By.id("user_first_name");

    private final By LAST_NAME_TEXT_FIELD = By.id("user_last_name");

    private final By USER_EMAIL_TEXT_FIELD = By.id("user_email");

    private final By DEFAULT_PASSWORD_TEXT_FIELD = By.id("user_password");

    private final By PASSWORD_CONFIRMATION_TEXT_FIELD = By.id("user_password_confirmation");

    private final By CREATE_USER_BUTTON = By.name("commit");

    private final  By ADMIN_USER_CREATED = By.xpath("//p[contains(., 'You just created a new account. Please inform the admin')]");

    private final String DESTROY_ACCOUNT_BUTTON = "//tr/td[contains(text(),'%s')]/following-sibling::td/a";

    private final String FIND_USER_IN_TABLE = "//tr/td[contains(text(),'%s')]";


    public AdminUsers(WebDriver driver){
        super(driver);
    }

    public boolean isAdminTabLoaded(){

        return webDriverCommands.waitForElementPresent(ADMIN_TAB_LOADED,15);
    }

    public void clickOnAdminUsersTab() {
        webDriverCommands.click(ADMINISTRATIVE_USERS_TAB);

    }

    public void clickOnCreateNewAdminUserLink(){

        webDriverCommands.click(CREATE_NEW_ADMIN_USER_LINK);

    }

    public void insertFirstName(String firstName){
        webDriverCommands.sendKeys(FIRST_NAME_TEXT_FIELD, firstName);

    }

    public void insertLastName(String lastName){
        webDriverCommands.sendKeys(LAST_NAME_TEXT_FIELD , lastName);

    }

    public void insertUserEmail(String userEmail){
        webDriverCommands.sendKeys(USER_EMAIL_TEXT_FIELD , userEmail);

    }

    public void insertDefaultPassword(String password){
        webDriverCommands.click(DEFAULT_PASSWORD_TEXT_FIELD);
        webDriverCommands.clear(DEFAULT_PASSWORD_TEXT_FIELD);
        webDriverCommands.sendKeys(DEFAULT_PASSWORD_TEXT_FIELD , password);

    }

    public void insertPasswordConfirmation(String passwordConfirmation){
        webDriverCommands.click(PASSWORD_CONFIRMATION_TEXT_FIELD);
        webDriverCommands.clear(PASSWORD_CONFIRMATION_TEXT_FIELD);
        webDriverCommands.sendKeys(PASSWORD_CONFIRMATION_TEXT_FIELD, passwordConfirmation);

    }

    public void clickOnCreateUserButton(){
        webDriverCommands.click(CREATE_USER_BUTTON);

    }

    public boolean wasAdminUserCreatedSuccessfully(){
        return webDriverCommands.waitForElementPresent(ADMIN_USER_CREATED,15);

    }


    public MyAccount clickOnMyAccountTab() {
        webDriverCommands.click(MY_ACCOUNT_TAB);
        return PageFactory.initElements(getDriver(), MyAccount.class);
    }

    public void clickOnDestroyAccountLink(String userEmail){

        webDriverCommands.click(By.xpath(String.format(DESTROY_ACCOUNT_BUTTON, userEmail)));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert=webDriver.switchTo().alert();
        alert.accept();

    }

    public boolean findUser(String userEmail) {
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(FIND_USER_IN_TABLE, userEmail)));
    }


}





