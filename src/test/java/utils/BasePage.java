package utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BasePage {


//    Methods that finds an element by locator
    public WebElement getWebElement(By locator) {
        WebElement element = null;
        try {
            element = DriverSingelton.getdriverInstance().findElement(locator);
        } catch (NoSuchElementException e) {
            Report.test.info("Element can't be found", MediaEntityBuilder.createScreenCaptureFromPath(Report.takeScreenShot(DriverSingelton.getdriverInstance(), "picName")).build());

        }
        return element;
    }

//  Methods to perform actions on elements
    public void clickElement(By locator){getWebElement(locator).click();}

    public void sendKeysToElement(By locator, String Keyz){getWebElement(locator).sendKeys(Keyz);}

    public String getTextFromElement(By locator){return getWebElement(locator).getAttribute(("value"));}

    public void clearElement(By locator){getWebElement(locator).clear();}

    // Click element via JS
    public void clickelementJS(By locator){ WebElement elementToClick = getWebElement(locator);
        ((JavascriptExecutor) DriverSingelton.getdriverInstance()).executeScript("arguments[0].click();", elementToClick);}

    //    Scroll to element via JS
    public void scrollToElement(By locator){WebElement element = getWebElement(locator);
        ((JavascriptExecutor) DriverSingelton.getdriverInstance()).executeScript("arguments[0].scrollIntoView(true);", element);}






}
