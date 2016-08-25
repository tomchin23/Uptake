package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.util.concurrent.TimeUnit;

/**
 * Created by hbhardwa on 8/25/2016.
 */
public class Download_Files {



    public static void main(String[] args) {
//        try {
            FirefoxProfile profile = new FirefoxProfile();


            // In Firfox browser settings, following is applied in order to stop the windows based popup
            // asking to save or cancel the download. With this setting, the download begins directly.

            profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");

            WebDriver driver = new FirefoxDriver(profile);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.navigate().to("http://filehippo.com/search?q=adobe+reader");
//        } catch (Throwable t) {
//            System.out.print(t.fillInStackTrace());
//        }
        // This commences download.
        //driver.findElement(By.xpath("http://www.filehippo.com/download_adobe_reader")).click();



    }
}
