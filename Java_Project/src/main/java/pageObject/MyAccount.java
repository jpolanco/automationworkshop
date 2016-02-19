package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by He on 10/17/2015.
 */
public class MyAccount extends PageObject{

    private final By MY_ACCOUNT_TAB_LOADED = By.xpath("//div[@id='content']/h2[contains(text() , 'Edit My Account')]");

    public MyAccount(WebDriver driver){
        super(driver);
    }

    public boolean isMyAccountTabLoaded(){
        return webDriverCommands.waitForElementPresent(MY_ACCOUNT_TAB_LOADED,15);
    }

}
