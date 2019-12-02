import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        //Grabs string value from button element by finding it by the xpath
        actualButtonLabel = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[1]")).getAttribute("class");

        if (actualButtonLabel.contentEquals(expectedButtonLabel)){
            System.out.println("Message: Passed! - Text Found");
        } else {
            System.out.println("Message: Failed - Text Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
