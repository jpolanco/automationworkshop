package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.WebDriverCommands;

/**
 * Created by He on 9/27/2015.
 */
public class PageObject {

    protected WebDriverCommands webDriverCommands;
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.webDriverCommands = new WebDriverCommands(driver);
        this.driver = driver;
    }

    protected WebDriver getDriver(){
        return this.driver;
    }
}
