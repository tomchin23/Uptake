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
public class Make_Account {

@BeforeTest
    public void startBrowser() {
        driver.navigate().to("http://live.guru99.com/index.php/mobile.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

@Test
    public void createAccount() {
    // Click on 'Account'
    driver.findElement(By.xpath("//div[@class='account-cart-wrapper']/a/span[2][(text() = 'Account')]")).click();
    // Click on 'Register'
    driver.findElement(By.xpath("//a[@title='Register']"));

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@AfterTest
    public void End() {
        Util.End();
    }
}
