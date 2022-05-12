package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class BasePage {


//    Methods that finds an element by locator
    public WebElement getWebElement(By locator){return ChromeDriverSingelton.getdriverInstance().findElement(locator);}


//  Methods to perform actions on elements
    public void clickElement(By locator){getWebElement(locator).click();}

    public void SendKeysToElement(By locator,String Keyz){getWebElement(locator).sendKeys(Keyz);}

    public String getTextFromElement(By locator){return getWebElement(locator).getAttribute(("value"));}



    // Click element via JS
    public void clickelementJS(By locator){ WebElement elementToClick = getWebElement(locator);
        ((JavascriptExecutor) ChromeDriverSingelton.getdriverInstance()).executeScript("arguments[0].click();", elementToClick);}

    //    Scroll to element via JS
    public void scrollToElement(By locator){WebElement element = getWebElement(locator);
        ((JavascriptExecutor) ChromeDriverSingelton.getdriverInstance()).executeScript("arguments[0].scrollIntoView(true);", element);}




    //  Methods to perform checks on elements
    public boolean isElementVisible(By locator){return getWebElement(locator).isDisplayed();}





}
