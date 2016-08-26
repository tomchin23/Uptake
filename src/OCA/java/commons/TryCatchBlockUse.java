package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by hbhardwa on 8/25/2016.
 */
public class TryCatchBlockUse {

    static FirefoxProfile profile = new FirefoxProfile();

    static WebDriver driver;

     // static Logger lgr = Logger.getLogger(TryCatchBlockUse.class.getName());

    public static void main(String[] args) {
        try {

            profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");

            driver = new FirefoxDriver(profile);
            //lgr.info("Driver instaniated");

            // In Firfox browser settings, following is applied in order to stop the windows based popup
            // asking to save or cancel the download. With this setting, the download begins directly.

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            driver.navigate().to("http://www.filehippo.com/download_adobe_reader");
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, "http://www.filehippo.com/download_adobe_reader");
        } catch (Error e) {
            System.out.print(e.fillInStackTrace());
        }
        // This commences download.
        //driver.findElement(By.xpath("http://www.filehippo.com/download_adobe_reader")).click();

        finish();
    }

    public static void finish() {

        driver.close();
        driver.quit();
        //lgr.info("Driver instance closed");
    }
}
