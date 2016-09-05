package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by HARSHENDU on 9/4/16.
 */
public class BrowserFactory {

    static WebDriver driver;


    public static WebDriver startBrowser(String browserName, String url) {

        if (browserName.equalsIgnoreCase("Firefox")) {
            driver= new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.navigate().to(url);
        return driver;

    }


}
