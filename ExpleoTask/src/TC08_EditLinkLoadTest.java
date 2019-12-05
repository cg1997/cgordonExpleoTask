import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the initial table row edit link in the webpage has loaded correctly - TC08
public class TC08_EditLinkLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedRowValue = "edit";
        String actualRowValue = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from table edit link element by finding it by its xpath
        actualRowValue = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[1]")).getText();

        //Checks if the expected string matches the string from the table edit link
        if (actualRowValue.contentEquals(expectedRowValue)){
            System.out.println("Message: Passed - Edit Link Found - Edit Link Loaded");
        } else {
            System.out.println("Message: Failed - Edit Link Not Found - Edit Link Not Loaded");
        }

        //After the result the driver is closed
        driver.close();

    }
}
