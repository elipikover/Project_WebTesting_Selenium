package POM;

import org.openqa.selenium.By;
import utils.BasePage;

public class BuissinessPage extends BasePage {

    public void clickBuissiness(String buissiness) {clickelementJS(By.linkText(buissiness));}

    public void clickSubmit(){
        getWebElement(By.cssSelector("button[type=submit]")).click();
    }

    public void enterAmount(String amount){

        getWebElement(By.cssSelector("input[inputmode=decimal]")).sendKeys(amount);

    }
}