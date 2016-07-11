package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import resources.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static resources.Drivers.driver;

/**
 * Created by HarshenduBhardwaj on 6/30/16.
 */
public class LogIn  {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(new File ("C:\\Users\\hbhardwa\\OCA\\src\\test\\java\\resources\\Objects.properties"));
        Properties prop = new Properties();
        prop.load(file);

        ProfilesIni listProfiles = new ProfilesIni();
        FirefoxProfile profile = listProfiles.getProfile("Automation_Runs");
        driver = new FirefoxDriver(profile);

        driver.navigate().to(prop.getProperty("baseUrl"));

        System.out.println("Current page being displayed is " + driver.getCurrentUrl());

        // Enter UserName
        driver.findElement(By.name(prop.getProperty("usernameLocator"))).sendKeys(prop.getProperty("userName"));

        // Enter Password
        // driver.findElement(By.name(prop.getProperty("passWordLocator"))).sendKeys(prop.getProperty("passWord"));

        driver.findElement(By.name(prop.getProperty("passWordLocator"))).sendKeys(prop.getProperty("passWord"));

        // Click on Submit button.
        driver.findElement(By.name(prop.getProperty("submitButtonLocator"))).click();

        // Take screenshot
        Util.getScreenShot();

        // Verify title of the page.
          if (
                driver.getTitle().contains(prop.getProperty("pageTitle")))
            System.out.println("Login Successful!");

        else
            System.out.println("Login Unsuccessful!");

        // End session.
        Util.End();
    }
}