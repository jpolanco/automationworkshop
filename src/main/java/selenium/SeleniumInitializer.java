package selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by He on 9/27/2015.
 */
public class SeleniumInitializer extends SeleniumSetup {

    /**
     * <p>This method set the values to initiate the driver with the proper values coming from the testng xml </p>
     * @param browserName Browser name
     * @param url url to connect
     */
    @Parameters({"browser_name","url"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browserName,String url){
        super.setUp(browserName);
        driver.get(url);
    }

    /**
     * This method overrides the quitBrowser method inherit from SeleniumSetup class
     */
    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        super.tearDown(); }

}
