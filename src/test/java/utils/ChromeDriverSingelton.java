package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// Singelton object to initialize selenium chrome driver

public class ChromeDriverSingelton {

    public static WebDriver driver;

    public  static WebDriver getdriverInstance(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
        }
        return driver;
    }
}
