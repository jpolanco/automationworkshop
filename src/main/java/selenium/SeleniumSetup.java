package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by Keylin on 24/10/2015.
 */
public class SeleniumSetup {

    protected WebDriver driverInstance;
    private String browserName;

    /**
     * This method creates and configures the browser
     * @param browserName Browser name
     */
    public void setUp(String browserName){
        this.browserName = browserName;

        //Creating the browser depending on the browser choice
        if(browserName.equals("ie")){
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("requireWindowsFocus", false);
            driverInstance = new InternetExplorerDriver();
        } else if(browserName.equals("chrome")){
            driverInstance = new ChromeDriver();
        } else if(browserName.equals("ff")){
            FirefoxProfile profile = new FirefoxProfile();
            driverInstance = new FirefoxDriver(profile);
        }

        System.out.println(driverInstance.getClass());

        // Configuring the browser
        driverInstance.manage().window().maximize();
        driverInstance.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driverInstance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverInstance.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driverInstance.manage().deleteAllCookies();
    }

    /**
     * <p>This method returns the browser's name</p>
      * @return browser's name
     */
    public  String getBrowserName (){
        return this.browserName;
    }

    /**
     * Closing the browser instance before every test case run
     */
    public void tearDown(){
        driverInstance.quit();
    }

    /**
     * This method returns the browser instance
     * @return browser instance
     */
    protected WebDriver getDriverInstance(){
        return this.driverInstance;
    }
}
