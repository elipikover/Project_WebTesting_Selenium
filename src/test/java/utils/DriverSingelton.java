package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * |Singelton object to initialize selenium chrome driver
 */

public class DriverSingelton {

    public static WebDriver driver;

    public  static WebDriver getdriverInstance(){
        if (driver == null){
            if (getBrowser().equals("webdriver.gecko.driver")){
                System.setProperty(getBrowser(), Constants.FIREFOXDRIVER_PATH);
                driver = new FirefoxDriver();
            }else {
                System.setProperty(getBrowser(), Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
    public static String getBrowser() {
        try {
            return XMLConfig.getBrowser();
        }catch (Exception e){
            e.printStackTrace();
        }
            return "webdriver.chrome.driver";
    }
}
