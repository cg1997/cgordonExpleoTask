import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Alert Button in the webpage has loaded correctly - TC04
public class TC04_AlertButtonLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedAlertButtonLabel = "button alert";
        String actualAlertButtonLabel = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from the alert button by finding it its xpath
        actualAlertButtonLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[2]")).getAttribute("class");

        //Checks if the expected alert button string matches the string from the actual alert button
        if (actualAlertButtonLabel.equals(expectedAlertButtonLabel)){
            System.out.println("Message: Passed - Alert Button Text Found - Alert Button Found");
        } else {
            System.out.println("Message: Failed - Alert Button Text Not Found - Alert Button Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
