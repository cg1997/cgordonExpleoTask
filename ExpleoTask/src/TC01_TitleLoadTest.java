import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Title in the webpage has loaded correctly - TC01
public class TC01_TitleLoadTest {

    public static void main(String[] args) throws Exception{

        String pageURL = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedPageTitle = "Challenging DOM";
        String actualPageTitle = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(pageURL);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from the title by finding it by its xpath
        actualPageTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();

        //Checks if the expected title string matches the actual string from the page title
        if (actualPageTitle.equals(expectedPageTitle)){
            System.out.println("Message: Passed - Title Text Found - Title Loaded");
        } else {
            System.out.println("Message: Failed - Title Text Not Found - Title Not Loaded");
        }

        //After the result the driver is closed
        driver.close();

    }
}
