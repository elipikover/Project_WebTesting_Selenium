package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Report {
    public static ExtentReports extent= new ExtentReports();
    public static ExtentTest test = extent.createTest("Intro & registration flow", "Test Register Flow");
    public static ExtentTest test2 = extent.createTest(" Home screen", "Test Home Page");
    public static ExtentTest test3 = extent.createTest("Pick a Buissiness", "Test Pick a Buissiness");
    public static ExtentTest test4 = extent.createTest("Sender & Receiver information", "Sender & Receiver information screen");


    /**
     * |Methods print to log of Extent reports PASS vs FAIL
     */
    public static void passedTest(String details){ test.log(Status.PASS, details);}

    public static void passedTest2(String details){ test2.log(Status.PASS, details);}

    public static void passedTest3(String details){ test3.log(Status.PASS, details);}

    public static void passedTest4(String details){ test4.log(Status.PASS, details);}

    public static void failedTest(String details){ test.log(Status.FAIL, details);}

    public static void failedTest2(String details){ test2.log(Status.FAIL, details);}

    public static void failedTest3(String details){ test3.log(Status.FAIL, details);}

    public static void failedTest4(String details){ test4.log(Status.FAIL, details);}


    /**
     * |Method that  takes a screenshot
     */

    public static String takeScreenShot(WebDriver driver, String ImagesPath) {
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
