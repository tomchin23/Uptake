package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by HARSHENDU on 9/4/16.
 */
public class HomePage {

    /* This class stores all locators for the Home page of http://uptake.com AND
     this class stores methods for elements of http://uptake.com */

    // Approach page locator.
    @FindBy(how = How.CSS, using = "div [class='primary-nav'] ul li:nth-child(1) a")
    private WebElement Approach_Page;

    // Platform page locator.
    @FindBy(how = How.XPATH, using = "//div[@class='primary-nav']/ul/li[2]/a")
    private WebElement Platform_Page;

    // Solutions page link.
    @FindBy(how = How.LINK_TEXT,using = "Solutions")
    private WebElement Solutions_Page;

    // People page link.
    @FindBy(how = How.CSS,using = "div [class='primary-nav'] ul li:nth-child(4) a")
    private WebElement People_Page;

    // Join Us page link
    @FindBy(how = How.XPATH,using = "//div[@class='primary-nav']/ul/li[5]/a")
    private WebElement JoinUs_Page;

    // Contact Us page link
    @FindBy(how = How.LINK_TEXT, using = "Contact Us")
    WebElement ContactUs_PopUp;

    // Blog page link
    @FindBy(how = How.XPATH,using = "//div[@class='primary-nav']/ul/li[7]/a")
    WebElement Blog_Page;


    // Methods for above elements.

    // Approaoch page method.
    public void goToApproach_Page() {
        Approach_Page.click();
    }

    // Platform page method.
    public void goToPlatform_Page() {
        Platform_Page.click();
    }

    // Solutions page method.
    public void goToSolutions_Page() {
        Solutions_Page.click();
    }

    // People page method
    public void goToPeople_Page() {
        People_Page.click();
    }

    // Join Us page method.
    public void goToJoinUs_Page() {
        JoinUs_Page.click();
    }

    // Contact Us Pop method.
    public void goToContactUs_PopUp() {
        ContactUs_PopUp.click();
    }

    public void goToBlog_Page() {
        Blog_Page.click();

    }

}
