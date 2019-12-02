import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //Grabs string value from the alert button element by finding it by the xpath
        actualHyperlink = driver.findElement(By.xpath("/html/body/div[3]/div/div/a")).getAttribute("href");

        //Checks if the expected hyperlink matches the string from the success button
        if (actualHyperlink.contentEquals(expectedHyperlink)){
            System.out.println("Message: Passed - Hyperlink Found");
        } else {
            System.out.println("Message: Failed - Hyperlink Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
