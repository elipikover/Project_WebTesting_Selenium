package POM;

import org.openqa.selenium.By;
import utils.BasePage;

public class BuissinessPage extends BasePage {

    public void clickBuissiness(String buissiness) {clickelementJS(By.linkText(buissiness));}

    public void clickSubmit(){
        clickElement(By.cssSelector("button[type=submit]"));
    }

    public void enterAmount(String amount){sendKeysToElement(By.cssSelector("input[inputmode=decimal]"),amount);}
}