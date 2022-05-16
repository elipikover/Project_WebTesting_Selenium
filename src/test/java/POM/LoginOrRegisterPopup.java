package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;
import utils.Constants;

public class LoginOrRegisterPopup extends BasePage {

        public void clickFirstTimeRegister(){
            clickElement(By.className("text-link"));
        }

        public void enterLoginName(String string){sendKeysToElement(By.cssSelector("input[type=text]"),string);}

        public String verifyTextInLoginName(){return getTextFromElement(By.cssSelector("input[type=text]"));}

        public void enterLoginEmail(String string){sendKeysToElement(By.cssSelector("input[type=email]"),string);}

        public String verifyTextInLoginEmail(){
        return getTextFromElement(By.cssSelector("input[type=email]"));
    }

        public void enterLoginPass1(String string){sendKeysToElement(By.cssSelector("input[placeholder='סיסמה']"), string);}

        public void enterLoginPass2(String string){sendKeysToElement(By.cssSelector("input[placeholder='אימות סיסמה']"), string);}

        public String verifyTextInPass1(){return getTextFromElement(By.cssSelector("input[placeholder='סיסמה']"));}

        public String verifyTextInPass2(){return getTextFromElement(By.cssSelector("input[placeholder='אימות סיסמה']"));}

        public void clickSubmitRegistration(){
            clickElement(By.cssSelector("button[type=submit]"));
        }


    //Method of full login to a default user that arrives at the home page

    public void loginToBuyMe(WebDriver driver){
        driver.get("https://buyme.co.il/?modal=login");
        LoginOrRegisterPopup registerPopup = new LoginOrRegisterPopup();
        registerPopup.enterLoginEmail(Constants.EMAIL_DEFAULT_USER);
        registerPopup.enterLoginPass1(Constants.PASSWORD_DEFAULT_USER);
        registerPopup.clickSubmitRegistration();

    }
}
