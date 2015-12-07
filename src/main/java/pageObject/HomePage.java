package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by He on 9/27/2015.
 */

public class HomePage extends PageObject {

    private final By PAGE_LOADED = By.xpath("//div[@id='content']/p[text()='Signed in successfully.']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean isLoginPageLoaded(){
        return webDriverCommands.waitForElementPresent(PAGE_LOADED,15);
    }

}
