package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by He on 9/27/2015.
 */
public class VacationsLoginPage extends PageObject {

    private final By PAGE_TITLE = By.xpath("//h2[text()='Sign in']");
    private final By EMAIL_USER = By.id("user_email");
    private final By USER_PASSWORD = By.id("user_password");
    private final By LOGIN_BUTTON = By.name("commit");


    public VacationsLoginPage(WebDriver driver){
        super(driver);
    }

    public boolean isTitleDisplayed(){
        return webDriverCommands.waitForElementPresent(PAGE_TITLE, 15);
    }

    public void insert_user(String userEmail) {
        webDriverCommands.sendKeys(EMAIL_USER, userEmail);
    }

    public void insert_password(String password) {
        webDriverCommands.sendKeys(USER_PASSWORD, password);
    }

    public HomePage clickOnLoginButton() {
        webDriverCommands.click(LOGIN_BUTTON);
        return PageFactory.initElements(getDriver(), HomePage.class);
    }




}
