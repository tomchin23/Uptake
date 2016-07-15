package commons;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Util;

import java.util.concurrent.TimeUnit;

import static resources.Drivers.driver;

/**
 * Created by hbhardwa on 7/15/2016.
 */
public class PopUp {



    @BeforeTest
    public void startBrowser() {
        driver.navigate().to("http://live.guru99.com/index.php/mobile.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void compare2Prods() {
        // Select first product 'Add to Compare'.
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();

        // Select second product 'Add to Compare'.
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();

        // Click compare button
        driver.findElement(By.xpath("//button[@title='Compare']")).click();

        // Switch to popUp window.
        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
            driver.close();
        }

        // Close popUp window
        driver.findElement(By.xpath(("//button[@title='Close Window']"))).click();

        // Switch back to original winodw
        for (String handle2 : driver.getWindowHandles()) {
            driver.switchTo().window(handle2);
        }

        }
    @AfterTest
        public void End() {
            Util.End();
    }
}
