package POM;

import org.openqa.selenium.By;
import utils.BasePage;


public class HomePage extends BasePage {

    public void clickLoginOrRegister(){clickElement(By.className("notSigned"));}

    public void clickSelectAmount(){clickelementJS(By.cssSelector("span[alt=סכום]"));}

    public void select500(){clickelementJS(By.cssSelector("li[value='5']"));}

    public void clickSelectLocation(){clickelementJS(By.cssSelector("span[alt=אזור]"));}

    public void selectTelAviv(){clickelementJS(By.cssSelector("li[value='13']"));}

    public void clickSelectCategory(){clickelementJS(By.cssSelector("span[alt=קטגוריה]"));}

    public void selectFashionGiftCard(){clickelementJS(By.cssSelector("li[value='22']"));}

    public void clickFindMyGift(){clickelementJS(By.cssSelector("a[rel=nofollow]"));}

}
