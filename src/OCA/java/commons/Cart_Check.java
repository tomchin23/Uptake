package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import static org.testng.AssertJUnit.assertEquals;
import static resources.Drivers.driver;

/**
 * Created by hbhardwa on 7/13/2016.
 *
 * This class validates that a quantity higher than available inventory cannot be ordered.
 * Available inventory is 500 units. Test will be for 501 units of Sony Xperia.
 */
public class Cart_Check {

    public static void main(String[] args) {

        FileInputStream file2 = null;
        try {
             file2 = new FileInputStream(new File("C:\\Users\\hbhardwa\\OCA\\src\\test\\java\\resources\\Proj2.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties prop3 = new Properties();
        try {
            prop3.load(file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
            // Go to Mobile page.

        driver.navigate().to(prop3.getProperty("mobilePageUrl"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

            // Click on add to cart for Sony Xperia.
            driver.findElement(By.xpath(prop3.getProperty("addToCartButtonXpath"))).click();

            // Change purchase quantity.
            WebElement purcQuantity = driver.findElement(By.xpath(prop3.getProperty("quantityChangeXpath")));
            purcQuantity.click();
            purcQuantity.clear();
            purcQuantity.sendKeys(prop3.getProperty("quantChangeValue"));

            // Explicit WebDriverWait for Update button to be displayed.
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop3.getProperty("updateButtonXpath")))).click();

            // Update quantity.
            //driver.findElement(By.xpath(prop3.getProperty("updateButtonXpath"))).click();

        String errorMsg = "EMPTY CART";
        String getErrorMsg = driver.findElement(By.xpath(prop3.getProperty("emptyCartMsgXpath"))).getText();

        if (errorMsg.equals(getErrorMsg)){
            System.out.println("Cart is empty");
        }else
            System.out.println("Cart is NOT empty");

        try {
            assertEquals(errorMsg, getErrorMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            Util.End();
        }

        }
}
