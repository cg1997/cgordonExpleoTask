import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Success Button in the webpage has loaded correctly TC05
public class TC05_SuccessButtonLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedSuccessButton = "button success";
        String actualSuccessButton = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Grabs string value from the alert button element by finding it by the xpath
        actualSuccessButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/a[3]")).getAttribute("class");

        //Checks if the expected string matches the string from the success button
        if (actualSuccessButton.equals(expectedSuccessButton)){
            System.out.println("Message: Passed - Success Button Text Found");
        } else {
            System.out.println("Message: Failed - Success Button Text Not Found");
        }

        //After the result the driver is closed
        driver.close();

    }
}
