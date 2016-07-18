package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static resources.Drivers.driver;

/**
 * Created by hbhardwa on 7/18/2016.
 */
public class WebTables {

    public static void main(String[] args) {
            WebDriver driver = new FirefoxDriver();
            driver.navigate().to("http://www.bloomberg.com/markets/commodities/futures/agriculture");

            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='data-tables first']/div/table/tbody/tr"));
        System.out.println("No. of rows in this table are: " + rows.size());
            for (int rowNum = 0; rowNum < rows.size(); rowNum++) {
                System.out.print(rows.get(rowNum).getText() + " ");
                List<WebElement> columns = driver.findElements(By.tagName("td"));
                for (int colNum = 0; colNum < columns.size(); colNum++) {
                    System.out.print(columns.get(colNum).getText() + " ");
                }
                System.out.println(" ");
            }
        driver.close();
        driver.quit();
        }
    }