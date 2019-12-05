import com.sun.source.tree.IfTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the initial row allows the user to edit it - TC13
public class TC13_EditRowTest {
    public static void main(String[] args) throws Exception{

        String pageURL = "https://the-internet.herokuapp.com/challenging_dom";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(pageURL);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Finds the edit button and clicks it
        WebElement editLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]"));
        editLink.click();

        //Checks if input field is there or not
        Boolean check = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/input[1]")).isDisplayed();


        //Checks if row was editable by checking if a input field was there or not by checking the boolean check
        if (check == true){
            System.out.println("Message: Passed - Row Deleted");
        } else {
            System.out.println("Message: Failed - Row Not Deleted");
        }

        //After the result the driver is closed
        driver.close();

    }

}
