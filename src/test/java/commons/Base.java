package commons;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.Properties;

/**
 * Created by HarshenduBhardwaj on 6/30/16.
 */
public class Base {

    static WebDriver driver;

    static Properties prop;

    static WebElement logInName;

    static WebElement logInPwd;


    public static void loadProperties() throws IOException {


        // Read the Objects.properties.properties file from resources package.
        FileInputStream file = new FileInputStream(new File ("/Users/HarshenduBhardwaj/OCA/src/test/java/resources/Objects.properties"));
        Properties prop = new Properties();
        prop.load(file);

        // Launch Firefox with profile.
        ProfilesIni listProfiles = new ProfilesIni();
        FirefoxProfile profile = listProfiles.getProfile("Automation_Runs");
        driver = new FirefoxDriver(profile);

        // Point driver to values from Objects.properties.properties file.
        driver.navigate().to(prop.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }


    public static void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("/Users/HarshenduBhardwaj/Desktop/ss/screenshot.png"));

    }

    public static void End() {
        driver.close();
        driver.quit();
    }


}