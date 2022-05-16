package POM;

import org.openqa.selenium.By;
import utils.BasePage;

public class PurchaseAGiftPage extends BasePage {

    public  void toSomeoneElse(){clickelementJS(By.xpath("//*[text()='למישהו אחר']"));}

    public void enterRecieverName(String name){
        sendKeysToElement(By.cssSelector("input[type=text]"),name );}

    public void chooseAnEvent(){clickelementJS(By.className("selected-name"));}

    public  void reasonForEvent(){clickelementJS(By.cssSelector("li[value='14']"));}

    public void enterABlessing(String blessing){
        sendKeysToElement(By.cssSelector("textarea[rows='4']"), blessing);}

    public void uploadAnImage(String pathToFile){
        sendKeysToElement(By.cssSelector("input[type=file]"), pathToFile);}

    public String verifyReceiverName(){return getTextFromElement(By.cssSelector("input[data-parsley-required-message=\"מי הזוכה המאושר? יש להשלים את שם המקבל/ת\"]"));}

    public void scrollToContinueButton(){scrollToElement(By.cssSelector("button[gtm='המשך']"));}

    public void clickContinueButton(){clickelementJS(By.cssSelector("button[gtm='המשך']"));}

    public void pressNow(){clickElement(By.cssSelector("svg[viewBox='0 0 20 20']"));}

    public void chooseEmail() {clickElement(By.cssSelector("svg[gtm=method-email]"));}

    public void enterEmail(String email){
        sendKeysToElement(By.cssSelector("input[type=email]"), email);}

    public void clearSenderName(){clearElement(By.cssSelector("input[placeholder='שם שולח המתנה']"));}

    public void enterSenderName(String name){
        sendKeysToElement(By.cssSelector("input[placeholder='שם שולח המתנה']"), name);}


    /**
     * @return email field content
     *
     *
     */
    public String verifyEmail(){return getTextFromElement(By.cssSelector("input[name=email]"));}

    public String verifySenderName(){return getTextFromElement(By.cssSelector("input[placeholder='שם שולח המתנה']"));}

    public void clickPay() {clickElement(By.cssSelector("svg[gtm=method-email]"));}

    }

