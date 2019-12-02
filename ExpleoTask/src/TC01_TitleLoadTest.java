import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
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

        //Grabs string value from title element by finding it by the xpath
        actualPageTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();

        //Checks if the expected string matches the string from the page title
        if (actualPageTitle.equals(expectedPageTitle)){
            System.out.println("Message: Passed! - Title Text Found");
        } else {
            System.out.println("Message: Failed - Title Text Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
