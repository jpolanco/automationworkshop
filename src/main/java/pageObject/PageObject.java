package pageObject;

import org.openqa.selenium.WebDriver;
import selenium.WebDriverCommands;

/**
 * Created by Keylin on 29/10/2015.
 */
public class PageObject {

    protected WebDriverCommands webDriverCommands;
    protected WebDriver webDriver;

    public PageObject(WebDriver driver){
        this.webDriverCommands = new WebDriverCommands(driver);
        this.webDriver = driver;
    }

    protected WebDriver getDriver(){
        return this.webDriver;
    }
}
