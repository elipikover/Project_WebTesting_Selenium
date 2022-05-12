import POM.BuissinessPage;
import POM.HomePage;
import POM.LoginOrRegisterPopup;
import POM.PurchaseAGiftPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ChromeDriverSingelton;
import utils.Constants;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//This is a suite of sanity tests for the BUYME website

public class BuyMeSanityTests {

    private WebDriver driver= ChromeDriverSingelton.getdriverInstance();


    @BeforeClass
    public void runBeforeTests(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

// Test of intro & registration flow

    @Test(priority = 1)
    public void introAndRegistration() {

//      Navigate to BUYME site URL
        driver.get("https://buyme.co.il/");

//      Open LoginOrRegister popup
        HomePage homepage = new HomePage();
        homepage.clickLoginOrRegister();

//      Click on Register flow
        LoginOrRegisterPopup registerPopup = new LoginOrRegisterPopup();
        registerPopup.clickFirstTimeRegister();

//      Fill in credentials
        registerPopup.enterLoginName(Constants.NAME_DEFAULT_USER);
        registerPopup.enterLoginEmail(Constants.EMAIL_DEFAULT_USER);
        registerPopup.enterLoginPass1(Constants.PASSWORD_DEFAULT_USER);
        registerPopup.enterLoginPass2(Constants.PASSWORD_DEFAULT_USER);

//        Verify that all texts appear in register fields as expected
        Assert.assertEquals(registerPopup.verifyTextInLoginName(),Constants.NAME_DEFAULT_USER);
        Assert.assertEquals(registerPopup.verifyTextInLoginEmail(),Constants.EMAIL_DEFAULT_USER);
        Assert.assertEquals(registerPopup.verifyTextInPass1(),Constants.PASSWORD_DEFAULT_USER);
        Assert.assertEquals(registerPopup.verifyTextInPass2(),Constants.PASSWORD_DEFAULT_USER);

//        Press register to BUYME
        registerPopup.clickSubmitRegistration();
    }

    @Test(priority = 2)
    public void Home() {

//      Prerequisite User is logged in
        new LoginOrRegisterPopup().loginToBuyMe(driver);
//On home page:
        HomePage homePage = new HomePage();
//      select amount
        homePage.clickSelectAmount();
//      select 500 -750שח
        homePage.select500();
//      Choose a location
        homePage.clickSelectLocation();
//      Select תל אביב והסביבה
        homePage.selectTelAviv();
//      Choose a category
        homePage.clickSelectCategory();
//      Choose מותגי אופנה
        homePage.selectFashionGiftCard();
//      Press find me a gift
        homePage.clickFindMyGift();


    }

    @Test(priority = 3)
    public void PickABusiness() throws InterruptedException {
//      Wait for URL to update - there is a lag on website
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains(Constants.GIFTSEARCHURL));
//      Verify the URL is as expected
        Assert.assertEquals(driver.getCurrentUrl(),Constants.GIFTSEARCHURL);
        BuissinessPage buissinessSearch = new BuissinessPage();
//        Choose buissiness - אופטיקנה
        buissinessSearch.clickBuissiness("אופטיקנה");
//        Select amount
        buissinessSearch.enterAmount("1000");
//        Submit
        buissinessSearch.clickSubmit();

    }


    @Test(priority = 4)
    public void SenderAndRecieverInformation() throws InterruptedException {
        PurchaseAGiftPage purchaseAGift = new PurchaseAGiftPage();
        purchaseAGift.toSomeoneElse();
        purchaseAGift.chooseAnEvent();
        purchaseAGift.enterRecieverName("John Smith");
        purchaseAGift.reasonForEvent();
        purchaseAGift.enterABlessing("❤❤❤ מזל טוב לחתונתכם ❤❤❤");
        purchaseAGift.scrollToContinueButton();
        purchaseAGift.uploadAnImage(Constants.SAMPLE_FILE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thumbnail")));
        purchaseAGift.clickContinueButton();
        purchaseAGift.pressNow();
        purchaseAGift.chooseEmail();
        purchaseAGift.enterEmail("Test@a.com");
        purchaseAGift.clearSenderName();
        purchaseAGift.enterSenderName("קטי סמיט׳");
        Assert.assertEquals(purchaseAGift.verifyEmail(),"Test@a.com");
        Assert.assertEquals(purchaseAGift.verifySenderName(),"קטי סמיט׳");
        purchaseAGift.clickPay();
    }

    @AfterClass
    public void runAfterTests() throws InterruptedException {
        driver.quit();
    }



    private static String takeScreenShot(WebDriver driver, String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}
