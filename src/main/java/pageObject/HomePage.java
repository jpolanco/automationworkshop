package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Keylin on 29/10/2015.
 */
public class HomePage extends PageObject {

    /**
     * Message signed in successfully
     */
    private final By pageLoaded = By.xpath("//div[@id='content']/p[text()='Signed in successfully.']");
    private final By adminUsersTab = By.xpath("//div[@id='menubar']//a[contains(text(),'Administrative Users')]");
    private final By myAccount = By.xpath("//div[@id='menubar']//a[contains(text(),'My Account')]");
    private final By employeesInfornation = By.xpath("//div[@id='menubar']//a[contains(text(),'Employees Information')]");

    /**
     * Page constructor method
     * @param webDriver Driver where the tests will run
     */
    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * This method confirms if the page was loaded
     * @return True if the page was loaded, false if the page was not loaded.
     */
    public boolean isPageLoaded(){
        return webDriverCommands.waitForElement(pageLoaded, 15);
    }

    /**
     * This method clicks a tab depending on with name is received as a parameter
     * @param tab Tab option
     * @return Depending on which tab is clicked, the class is returned to check if the tab's title was displayed
     */
    public Object clickMenuTab (String tab){
        Object page = new Object();

        if(tab.equals("AdminUser")){
            webDriverCommands.click(adminUsersTab);
            page = PageFactory.initElements(webDriver, AdminUsersTab.class);
        } else if(tab.equals("MyAccount")){
            webDriverCommands.click(myAccount);
            page = PageFactory.initElements(webDriver, MyAccountTab.class);
        } else if(tab.equals("EmployeesInformation")){
            webDriverCommands.click(employeesInfornation);
            page = PageFactory.initElements(webDriver, EmployeesInformationTab.class);
        }

        return page;
    }
}
