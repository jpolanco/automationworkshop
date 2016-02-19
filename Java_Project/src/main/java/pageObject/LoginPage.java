package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Keylin on 31/10/2015.
 */
public class LoginPage extends PageObject {

    private final By pageTitle = By.xpath("//h2[text()='Sign in']");
    private final By emailUser = By.id("user_email");
    private final By userPassword = By.id("user_password");
    private final By loginButton = By.name("commit");

    /**
     * Class constructor
     * @param webDriver Driver where to execute the tests
     */
    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * This method confirms if the page's title has been displayed
     * @return True if the page's title was displayed, false if the page's title was not displayed
     */
    public boolean isTitleDisplayed(){
        return webDriverCommands.waitForElement(pageTitle, 15);
    }

    /**
     * This method insert a value in the 'Email User' field.
     * @param emailUser Value to insert
     */
    public void insertUser(String emailUser){
        webDriverCommands.sendKeys(this.emailUser, emailUser);
    }

    /**
     * This method insert a value in the 'User Password' field.
     * @param userPassword Value to insert
     */
    public void insertPassword(String userPassword){
        webDriverCommands.sendKeys(this.userPassword, userPassword);
    }

    /**
     * This method clicks the login button
     * @return The instance to the page where the test will be redirected
     */
    public HomePage clickOnLoginButton(){
        webDriverCommands.click(loginButton);
        return PageFactory.initElements(getDriver(), HomePage.class);
    }
}
