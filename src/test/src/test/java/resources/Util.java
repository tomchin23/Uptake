package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * Created by HarshenduBhardwaj on 6/30/16.
 */
public class Util {

    static WebDriver driver = new FirefoxDriver();

    public static void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("/Users/HarshenduBhardwaj/Desktop/ss/screenshot.png"));
    }

    public static void End() {
        driver.close();
        driver.quit();
    }

}
