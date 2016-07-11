package resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;
import java.io.IOException;
import java.util.Random;


import static resources.Drivers.driver;

/**
 * Created by HarshenduBhardwaj on 6/30/16.
 */
public class Util {

    static Random randInt = new Random();

    public static void getScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File("/Users/HARSHENDU/Desktop/workspace/ScreenShots/ScreenShot_" + randInt.nextInt(1000) + ".png"));
    }

    public static void End() {

        driver.close();
        driver.quit();

    }

}
