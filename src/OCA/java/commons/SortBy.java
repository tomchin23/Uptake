package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import resources.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static resources.Drivers.driver;

/**
 * Created by HARSHENDU on 7/10/16.
 */
public class SortBy {

    public static void main(String[] args) /*throws IOException*/ {

        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("C:\\Users\\hbhardwa\\OCA\\src\\test\\java\\resources\\Proj2.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop2 = new Properties();
        try {
            prop2.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Go To Home Page.
        driver.navigate().to(prop2.getProperty("baseUrl"));

        // Go To Mobile Page.
        driver.findElement(By.xpath("//a[@href = 'http://live.guru99.com/index.php/mobile.html']")).click();

        // Verify Title.
        if (driver.getCurrentUrl().equals(prop2.getProperty("pageVerifyUrl")) ) {
            System.out.println("Page Title Verified");
        }
            else
            System.out.println("Page Title NOT Verified");

        // Select 'name' From Dropdown.
        Select select = new Select(driver.findElement(By.xpath(prop2.getProperty("dropDownXpath"))));
        select.selectByVisibleText("Name");

        try {
            Util.getScreenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // *********************CheckPrice****************** //

        // Get Price For Sony Xperia Displayed On Mobile Page.
        WebElement firstPrice = driver.findElement(By.xpath(prop2.getProperty("xperiaMobilePagePrice")));
        System.out.println("First Price Is " + firstPrice.getText());

        // Get Price For Sony Xperia Displayed In Item Description.

        WebElement secondPrice = driver.findElement(By.xpath(prop2.getProperty("xperiaMobileDescPrice")));
        System.out.println("Second Price Is " + secondPrice.getText());

        if(secondPrice.equals(firstPrice)) {
            System.out.println("Price Check Guaranteed");
        }
        else
            System.out.println("Price Check NOT Guaranteed");

        // End Session.
        Util.End();

    }

}
