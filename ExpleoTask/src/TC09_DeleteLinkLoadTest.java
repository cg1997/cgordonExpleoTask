import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the table delete link in the webpage has loaded correctly - TC09
public class TC09_DeleteLinkLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedRowValue = "delete";
        String actualRowValue = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Grabs string value from table delete link element by finding it by its xpath
        actualRowValue = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[7]/a[2]")).getText();

        //Checks if the expected string matches the string from the table delete link
        if (actualRowValue.contentEquals(expectedRowValue)){
            System.out.println("Message: Passed - Delete Link Found - Delete Link Loaded");
        } else {
            System.out.println("Message: Failed - Delete Link Not Found - Delete Link Not Loaded");
        }

        //After the result the driver is closed
        driver.close();

    }
}
