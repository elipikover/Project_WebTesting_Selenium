import POM.BuissinessPage;
import POM.HomePage;
import POM.LoginOrRegisterPopup;
import POM.PurchaseAGiftPage;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.*;

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
//        fgsdgsd

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        Report.extent.attachReporter(htmlReporter);
        Report.extent.setSystemInfo("OS", "Mac Menterey");
        Report.extent.setSystemInfo("Environment", "QA");

    }


    /**
     * Test of intro & registration flow
     */

    @Test(priority = 1)
    public void introAndRegistration() {


        try {
            driver.get(XMLConfig.getURL());
        } catch (Exception e) {
            e.printStackTrace();
        }

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


    }

    /**
     * Test of Home screen flow
     */

    @Test(priority = 2)
    public void Home() {

    new LoginOrRegisterPopup().loginToBuyMe(driver);
    Report.passedTest("Login user");

    HomePage homePage = new HomePage();
    homePage.clickSelectAmount();
    Report.passedTest("Pick price point");

    homePage.select500();
    Report.passedTest("Pick 500-750שח");

    homePage.clickSelectLocation();
    Report.passedTest("Pick Region");

    homePage.selectTelAviv();
    Report.passedTest("Select תל אביב והסביבה");

    homePage.clickSelectCategory();
    Report.passedTest("Pick Category");

    homePage.selectFashionGiftCard();
    Report.passedTest("Select מותגי אופנה");

    homePage.clickFindMyGift();
    Report.passedTest("Press תמצאו לי מתנה״");





    }

    /**
     * Test of pick a buissiness flow
     */

    @Test(priority = 3)
    public void PickABusiness() {


//      Wait for URL to update - there is a lag on website
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.urlContains(Constants.GIFTSEARCHURL));

            Assert.assertEquals(driver.getCurrentUrl(), Constants.GIFTSEARCHURL);
            BuissinessPage buissinessSearch = new BuissinessPage();
            Report.passedTest("Assert website URL");

            buissinessSearch.clickBuissiness("אופטיקנה");
            Report.passedTest("Pick buissiness - אופטיקנה");

            buissinessSearch.enterAmount("1000");
            Report.passedTest("Choose a price");

            buissinessSearch.clickSubmit();
            Report.passedTest("Press  לבחירה״");

    }

    /**
     * Test of Sender And Reciever Information flow
     */

    @Test(priority = 4)
    public void SenderAndRecieverInformation() {

            PurchaseAGiftPage purchaseAGift = new PurchaseAGiftPage();

            purchaseAGift.toSomeoneElse();
            Report.passedTest("Press button  למישהו אחר״");

            purchaseAGift.enterRecieverName("John Smith");
            Report.passedTest("Enter Receiver name");

            Assert.assertEquals(purchaseAGift.verifyReceiverName(), "John Smith");
            Report.passedTest("Assert Receiver name in field");

            purchaseAGift.chooseAnEvent();
            Report.passedTest("Pick an event");

            purchaseAGift.reasonForEvent();
            Report.passedTest("Pick reason an event");

            purchaseAGift.enterABlessing("❤❤❤ מזל טוב לחתונתכם ❤❤❤");
            Report.passedTest("Enter blessing");

            purchaseAGift.scrollToContinueButton();

            purchaseAGift.uploadAnImage(Constants.SAMPLE_FILE);
            Report.passedTest("upload an image");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("thumbnail")));
            purchaseAGift.clickContinueButton();
            Report.passedTest("Press המשך button");


            purchaseAGift.pressNow();
            Report.passedTest("Press עכשיו button");


            purchaseAGift.chooseEmail();
            Report.passedTest("Pick email/SMS");


            purchaseAGift.enterEmail("Test@a.com");
            Report.passedTest("Enter an email address/phone numebr");


            purchaseAGift.clearSenderName();
            purchaseAGift.enterSenderName("קטי סמיט׳");
            Report.passedTest("Enter sender name");


            Assert.assertEquals(purchaseAGift.verifySenderName(), "קטי סמיט׳");
            Report.passedTest("Assert sander name");

            purchaseAGift.clickPay();
            Report.passedTest("Press תשלום״");


    }

    @AfterClass
    public void runAfterTests() {
        driver.quit();
        Report.extent.flush();
    }

}
