package POM;

import org.openqa.selenium.By;
import utils.BasePage;

public class PurchaseAGiftPage extends BasePage {

    public  void toSomeoneElse(){clickelementJS(By.xpath("//*[text()='למישהו אחר']"));}

    public void enterRecieverName(String name){getWebElement(By.cssSelector("input[type=text]")).sendKeys(name);}

    public void chooseAnEvent(){clickelementJS(By.className("selected-name"));}

    public  void reasonForEvent(){clickelementJS(By.cssSelector("li[value='14']"));}

    public void enterABlessing(String blessing){getWebElement(By.cssSelector("textarea[rows='4']")).sendKeys(blessing);}

    public void uploadAnImage(String pathToFile){getWebElement(By.cssSelector("input[type=file]")).sendKeys(pathToFile);}

    public void scrollToContinueButton(){scrollToElement(By.cssSelector("button[gtm=המשך]"));}

    public void clickContinueButton(){clickelementJS(By.cssSelector("button[gtm=המשך]"));}

    public void pressNow(){getWebElement(By.cssSelector("svg[viewBox='0 0 20 20']")).click();}

    public void chooseEmail() {getWebElement(By.cssSelector("svg[gtm=method-email]")).click();}

    public void enterEmail(String email){getWebElement(By.cssSelector("input[type=email]")).sendKeys(email);}

    public void clearSenderName(){getWebElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).clear();}

    public void enterSenderName(String name){getWebElement(By.cssSelector("input[placeholder='שם שולח המתנה']")).sendKeys(name);}

    public String verifyEmail(){return getTextFromElement(By.cssSelector("input[name=email]"));}

    public String verifySenderName(){return getTextFromElement(By.cssSelector("input[placeholder='שם שולח המתנה']"));}

    public void clickPay() {getWebElement(By.cssSelector("svg[gtm=method-email]")).click();}
    }

