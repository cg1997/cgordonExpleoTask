import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the link takes the user to the hyperlinked page - TC12
public class TC12_HyperlinkNewPageTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String linkToPage = "";
        String newPageLink = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Writes link to linkToPage string for comparison later
        linkToPage = driver.findElement(By.xpath("/html/body/div[3]/div/div/a")).getAttribute("href");

        //Instance of link created
        WebElement link = driver.findElement(By.xpath("/html/body/div[3]/div/div/a"));

        //Link clicked
        link.click();

        //Wait for page to load
        TimeUnit.SECONDS.sleep(5);

        //Switch focus to current tab
        driver.switchTo().activeElement();

        //Get current URL
        newPageLink = driver.getCurrentUrl();

        System.out.println(linkToPage);
        System.out.println(newPageLink);

        //Checks if the link from the current page matches
        if (newPageLink.contentEquals(linkToPage)){
            System.out.println("Message: Passed - Link Matches");
        } else {
            System.out.println("Message: Failed - Link Does Not Match");
        }

        //After the result the driver is closed
        driver.close();
    }
}
