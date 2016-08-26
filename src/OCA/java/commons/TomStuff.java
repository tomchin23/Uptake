package commons;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TomStuff {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.bloomberg.com/");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.cssSelector("span[class='bb-nav-search__icon"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);

        driver.close();
    }
}
