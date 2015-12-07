package pageObject;

import org.openqa.selenium.WebDriver;
import selenium.WebDriverCommands;

/**
 * Created by Keylin on 29/10/2015.
 */
public class PageObject {

    protected WebDriverCommands webDriverCommands;
    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver){
        this.webDriverCommands = new WebDriverCommands(webDriver);
        this.webDriver = webDriver;
    }

    protected WebDriver getDriver(){
        return this.webDriver;
    }
}
