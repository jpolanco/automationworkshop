package selenium;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by He on 9/27/2015.
 */
public class WebDriverCommands {

    private WebDriver driver;

    public WebDriverCommands(WebDriver driver){
        this.driver = driver;
    }


    public boolean waitForElement(final By byElement) {
        boolean isElementPresent = true;
        WebDriverWait wait = new WebDriverWait(this.driver, 7000);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (TimeoutException e) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public boolean waitForElement(final By byElement,int timeOut) {
        boolean isElementPresent = true;
        WebDriverWait wait = new WebDriverWait(this.driver, (timeOut*1000));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (TimeoutException e) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public boolean waitForElementPresent(final By byElement) {
        boolean isElementPresent = true;


        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(5, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement we = d.findElement(byElement);
                    return we;
                }
            });

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;
    }


    public boolean waitForElementPresent(final By byElement, int noOfSecToWait) {
        boolean isElementPresent = true;


        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    .withTimeout(noOfSecToWait, TimeUnit.SECONDS)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
                    WebElement we = d.findElement(byElement);
                    return we;
                }
            });

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;
    }

    /**
     * This method has the intention to verify if the page is already loaded
     * @return boolean
     */
    public boolean waitForPageLoad(){
        boolean isLoaded = true;
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60000);
        try {
            wait.until(pageLoadCondition);
        }catch (TimeoutException e){
            isLoaded = false;
        }

        return isLoaded;
    }

    /**
     * This method clear the text fields
     * @param webElement editable web element to clear
     */
    public void clear(By webElement){

        if(waitForElementPresent(webElement)){
            driver.findElement(webElement).clear();

        }

    }

    /**
     * This method sends text values to add in the textfields
     * @param webElement editable web element to clear
     * @param text text to send into an editable web element
     */
    public void sendKeys(By webElement, String text){
        if (waitForElementPresent(webElement)){
            driver.findElement(webElement).sendKeys(text);
        }
    }

    /**
     * This method clicks on clickable web elements
     * @param webElement clickable web element
     */
    public void click(By webElement){
        if (waitForElementPresent(webElement)) {
            driver.findElement(webElement).click();
        }
    }

    /**
     * This method return the text values of the web elements
     * @param webElement web element to get text
     * @return String
     */
    public String getText(By webElement){
        String elementText = "";
        if(waitForElement(webElement)){
            elementText = driver.findElement(webElement).getText();
        }
        return  elementText;
    }


}

