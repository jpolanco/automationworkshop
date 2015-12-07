package selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by Keylin on 24/10/2015.
 */
public class SeleniumInitializer extends SeleniumSetup {

    /**
     * <p>Setting up the driver instance with the values coming from testng xml</p>
     * @param browserName Browser name
     * @param url url to connect
     */
    @Parameters ({"browser", "url"})
    @BeforeMethod (alwaysRun = true)
    public void setUp(String browserName, String url){
        super.setUp(browserName);
        driverInstance.get(url);
    }

    /**
     * Overriding the SeleniumSetup quitBrowser method
     */
    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        super.tearDown();
    }
}
