import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the first Button in the webpage has loaded correctly TC03
public class TC03_ButtonLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedButtonLabel = "button";
        String actualButtonLabel = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from the button by finding it by its xpath
        actualButtonLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[1]")).getAttribute("class");

        //Checks if the expected string matches the string from the button
        if (actualButtonLabel.equals(expectedButtonLabel)){
            System.out.println("Message: Passed - Button Text Found - Button Loaded");
        } else {
            System.out.println("Message: Failed - Button Text Not Found - Button Not Loaded");
        }

        //After the result the driver is closed
        driver.close();

    }
}
