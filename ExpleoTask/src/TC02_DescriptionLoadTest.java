import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_DescriptionLoadTest {

    public static void main(String[] args) throws Exception{

        String pageURL = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedPageDescription = "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element.";
        String actualPageDescription = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Resources\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(pageURL);

        //Grabs string value from title element by finding it by the xpath
        actualPageDescription = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")).getText();

        //Checks if the expected string matches the string from the page title
        if (actualPageDescription.equals(expectedPageDescription)){
            System.out.println("Message: Passed - Description Text Found");
        } else {
            System.out.println("Message: Failed - Description Text Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
