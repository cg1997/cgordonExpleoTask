import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the first row has deleted correctly - TC14
public class TC14_DeleteRowTest {
    public static void main(String[] args) throws Exception{

        String pageURL = "https://the-internet.herokuapp.com/challenging_dom";
        String originalRowOne = "Iuvaret0";
        String newRowOne = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(pageURL);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        WebElement deleteLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]"));
        deleteLink.click();

        //Grabs string value from new first row element by finding it by its xpath
        newRowOne = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();

        //Checks if row was deleted by comparing the strings for the new first row with the original one
        if (!newRowOne.equals(originalRowOne)){
            System.out.println("Message: Passed - Row Deleted");
        } else {
            System.out.println("Message: Failed - Row Not Deleted");
        }

        //After the result the driver is closed
        driver.close();

    }
}
