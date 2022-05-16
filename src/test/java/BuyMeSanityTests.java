import POM.BuissinessPage;
import POM.HomePage;
import POM.LoginOrRegisterPopup;
import POM.PurchaseAGiftPage;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverSingelton;
import utils.XMLConfig;
import utils.Constants;
import utils.Report;
import java.time.Duration;


/**
 * This is a suite of sanity tests for the BUYME website
 */

public class BuyMeSanityTests {

    private final WebDriver driver= DriverSingelton.getdriverInstance();

    /**
     * Set up tests, waits, browser window and reporting system
     */

    @BeforeClass
    public void runBeforeTests(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        Report.extent.attachReporter(htmlReporter);
    }



    /**
     * Test of intro & registration flow
     */

    @Test(priority = 1)
    public void introAndRegistration() {

    try {

        driver.get(XMLConfig.getURL());

        Report.passedTest(" Enter BuyMe website");

        HomePage homepage = new HomePage();
        homepage.clickLoginOrRegister();

        Report.passedTest("Press כניסה והרשמה");

        LoginOrRegisterPopup registerPopup = new LoginOrRegisterPopup();
        registerPopup.clickFirstTimeRegister();

        Report.passedTest("Press הרשמה");

        registerPopup.enterLoginName(Constants.NAME_DEFAULT_USER);

        Report.passedTest("Enter First Name");

        registerPopup.enterLoginEmail(Constants.EMAIL_DEFAULT_USER);

        Report.passedTest("Enter valid email address");

        registerPopup.enterLoginPass1(Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Enter password");

        registerPopup.enterLoginPass2(Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Re-Enter password");


        Assert.assertEquals(registerPopup.verifyTextInLoginName(), Constants.NAME_DEFAULT_USER);

        Report.passedTest("Assert text entered in first name field");

        Assert.assertEquals(registerPopup.verifyTextInLoginEmail(), Constants.EMAIL_DEFAULT_USER);

        Report.passedTest("Assert text entered in email field");

        Assert.assertEquals(registerPopup.verifyTextInPass1(), Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Assert text entered in first password field");

        Assert.assertEquals(registerPopup.verifyTextInPass2(), Constants.PASSWORD_DEFAULT_USER);

        Report.passedTest("Assert text entered in second password field");

        registerPopup.clickSubmitRegistration();

        Report.passedTest("Press הרשמה");

    } catch (NoSuchElementException e){
        Report.failedTest("Intro & Registration flow Failed");
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    /**
     * Test of Home screen flow
     */

    @Test(priority = 2)
    public void Home() {
try {

    new LoginOrRegisterPopup().loginToBuyMe(driver);
    Report.passedTest2("Login user");

    HomePage homePage = new HomePage();
    homePage.clickSelectAmount();
    Report.passedTest2("Pick price point");

    homePage.select500();
    Report.passedTest2("Pick 500-750שח");

    homePage.clickSelectLocation();
    Report.passedTest2("Pick Region");

    homePage.selectTelAviv();
    Report.passedTest2("Select תל אביב והסביבה");

    homePage.clickSelectCategory();
    Report.passedTest2("Pick Category");

    homePage.selectFashionGiftCard();
    Report.passedTest2("Select מותגי אופנה");

    homePage.clickFindMyGift();
    Report.passedTest2("Press תמצאו לי מתנה״");

} catch (NoSuchElementException e){
    Report.failedTest2("Home screen flow failed");

        }

    }

    /**
     * Test of pick a buissiness flow
     */

    @Test(priority = 3)
    public void PickABusiness() {


        try {
//      Wait for URL to update - there is a lag on website
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.urlContains(Constants.GIFTSEARCHURL));

            Assert.assertEquals(driver.getCurrentUrl(), Constants.GIFTSEARCHURL);
            BuissinessPage buissinessSearch = new BuissinessPage();
            Report.passedTest3("Assert website URL");

            buissinessSearch.clickBuissiness("אופטיקנה");
            Report.passedTest3("Pick buissiness - אופטיקנה");

            buissinessSearch.enterAmount("1000");
            Report.passedTest3("Choose a price");

            buissinessSearch.clickSubmit();
            Report.passedTest3("Press  לבחירה״");

        }catch(NoSuchElementException e){
            Report.failedTest3("Pick a buissiness flow failed");
        }

    }

    /**
     * Test of Sender And Reciever Information flow
     */

    @Test(priority = 4)
    public void SenderAndRecieverInformation() {

        try {
            PurchaseAGiftPage purchaseAGift = new PurchaseAGiftPage();

            purchaseAGift.toSomeoneElse();
            Report.passedTest4("Press button  למישהו אחר״");

            purchaseAGift.enterRecieverName("John Smith");
            Report.passedTest4("Enter Receiver name");

            Assert.assertEquals(purchaseAGift.verifyReceiverName(), "John Smith");
            Report.passedTest4("Assert Receiver name in field");

            purchaseAGift.chooseAnEvent();
            Report.passedTest4("Pick an event");

            purchaseAGift.reasonForEvent();
            Report.passedTest4("Pick reason an event");

            purchaseAGift.enterABlessing("❤❤❤ מזל טוב לחתונתכם ❤❤❤");
            Report.passedTest4("Enter blessing");

            purchaseAGift.scrollToContinueButton();

            purchaseAGift.uploadAnImage(Constants.SAMPLE_FILE);
            Report.passedTest4("upload an image");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thumbnail")));
            purchaseAGift.clickContinueButton();
            Report.passedTest4("Press המשך button");


            purchaseAGift.pressNow();
            Report.passedTest4("Press עכשיו button");


            purchaseAGift.chooseEmail();
            Report.passedTest4("Pick email/SMS");


            purchaseAGift.enterEmail("Test@a.com");
            Report.passedTest4("Enter an email address/phone numebr");


            purchaseAGift.clearSenderName();
            purchaseAGift.enterSenderName("קטי סמיט׳");
            Report.passedTest4("Enter sender name");


            Assert.assertEquals(purchaseAGift.verifySenderName(), "קטי סמיט׳");
            Report.passedTest4("Assert sander name");

            purchaseAGift.clickPay();
            Report.passedTest4("Press תשלום״");


        }catch (NoSuchElementException e){
            Report.failedTest4("Sender & Reciever Information flow Failed");

        }
    }

    @AfterClass
    public void runAfterTests() {
        driver.quit();
        Report.extent.flush();
    }

}
