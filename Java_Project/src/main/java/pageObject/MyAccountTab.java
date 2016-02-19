package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Keylin on 01/11/2015.
 */
public class MyAccountTab extends HomePage {

    //Xpath
    private final By pageTitle = By.xpath("//h2[contains(text(),'Edit My Account')]");

    public MyAccountTab(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * This method confirms if the page was loaded
     * @return True if the page was loaded, false if the page was not loaded.
     */
    public boolean isTitleDisplayed(){
        return webDriverCommands.waitForElement(pageTitle, 15);
    }
}
