package testScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageFactory.BrowserFactory;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static testData.pageUrls.*;

/**
 * Created by HARSHENDU on 9/4/16.
 */
public class Verify_Navigation {

    // This class verifies that navigation between Homepage and all other pages listed on HomePage.java is working.

    WebDriver driver = BrowserFactory.startBrowser("firefox", Homepage_Url);
    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    public static Logger log = Logger.getLogger(Verify_Navigation.class.getName());


    @Test(priority = 0)
    public void navigateToApproachPage() {

        homePage.goToApproach_Page();

        Assert.assertEquals(driver.getCurrentUrl(), Approach_PageUrl);
        log.info("Approach Page is displayed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void navigateToPlatformPage() {

        homePage.goToPlatform_Page();

        Assert.assertEquals(driver.getCurrentUrl(), Platform_PageUrl);
        log.info("Platform page is displayed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void navigateToSolutionsPage() {

        homePage.goToSolutions_Page();

        Assert.assertEquals(driver.getCurrentUrl(), Solutions_PageUrl);
        log.info("Solutions page is displayed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 3)
    public void navigateToPeoplePage() {

        homePage.goToPeople_Page();

        Assert.assertEquals(driver.getCurrentUrl(), People_pageUrl);
        log.info("People page is displayed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 4)
    public void navigateToJoinUsPage() {

        homePage.goToJoinUs_Page();

        Assert.assertEquals(driver.getCurrentUrl(), JoinUs_pageUrl);
        log.info("JoinUs page is displayed");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().back();
        log.info("Go back to home page");
    }

        @Test(priority = 5)
        public void navigateToContactUsPage() {

        homePage.goToContactUs_PopUp();

        log.info("Contact Us page is displayed");

        driver.navigate().refresh();
    }

        @Test(priority = 6)
        public void navigateToBlogPage() {

            homePage.goToBlog_Page();

            log.info("Blog page is displayed");

    }
    @AfterClass
    public void endSession() {
        driver.close();
        driver.quit();
    }


}
