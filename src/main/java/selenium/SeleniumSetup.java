package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by He on 9/27/2015.
 */
public class SeleniumSetup {

    protected WebDriver driver;
    private String browser;


    /**
     * <p>This method creates the driver instant depends of the browser choice</p>
     * @param browserName Browser name
     */
    public void setUp(String browserName) {
        this.browser = browserName;
        if (browserName.equals("ie")) {
            DesiredCapabilities dc = new DesiredCapabilities().internetExplorer();
            dc.setCapability("requireWindowFocus", false);
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            //loginPage = PageFactory.initElements(driver, LoginPage.class);
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            //loginPage = PageFactory.initElements(driver, LoginPage.class);
        } else if (browserName.equals("firefox")) {
            FirefoxProfile profile = new FirefoxProfile();
            driver = new FirefoxDriver(profile);
            driver.manage().window().maximize();
            //loginPage = PageFactory.initElements(driver, LoginPage.class);
        }
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    /**
     * <p>This method returns the browser name in case any test case need it </p>
     * @return Browser selected
     */
    public String getBrowserName(){
        return this.browser;
    }

    /**
     * <p>This method close the driver before every test case run </p>
     */
    public void tearDown(){
        driver.quit();

    }

    protected WebDriver getDriverInstance(){
        return this.driver;
    }
}
