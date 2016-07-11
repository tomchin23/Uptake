package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import resources.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static resources.Drivers.driver;

/**
 * Created by HARSHENDU on 7/10/16.
 */
public class SortBy {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(new File("/Users/HARSHENDU/IdeaProjects/OCA/src/test/java/resources/Proj2.properties"));
        Properties prop = new Properties();
        prop.load(file);

        // Go To Home Page.
        driver.navigate().to(prop.getProperty("baseUrl"));

        // Go To Mobile Page.
        driver.findElement(By.xpath("//a[@href = 'http://live.guru99.com/index.php/mobile.html']")).click();

        // Verify Title.
        if (driver.getCurrentUrl().equals(prop.getProperty("pageVerifyUrl")) ) {
            System.out.println("Page Title Verified");
        }
            else
            System.out.println("Page Title NOT Verified");

        // Select 'name' From Dropdown.
        Select select = new Select(driver.findElement(By.xpath(prop.getProperty("dropDownXpath"))));
        select.selectByVisibleText("Name");

        Util.getScreenShot();
        Util.End();

    }

}
