import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Hyperlink in the webpage has loaded correctly TC11
public class TC11_HyperlinkLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedHyperlink = "http://elementalselenium.com/";
        String actualHyperlink = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from the Hyperlink element by finding it by its xpath
        actualHyperlink = driver.findElement(By.xpath("/html/body/div[3]/div/div/a")).getAttribute("href");

        //Checks if the expected hyperlink matches the string from the success button
        if (actualHyperlink.contentEquals(expectedHyperlink)){
            System.out.println("Message: Passed - Hyperlink Found - Hyperlink Loaded");
        } else {
            System.out.println("Message: Failed - Hyperlink Not Found - Hyperlink Not Loaded");
        }

        //After the result the driver is closed
        driver.close();

    }
}
