import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Answer Box in the webpage has loaded correctly - TC10
public class TC10_AnswerBoxLoadTest {

    public static void main(String[] args) throws Exception{

        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String expectedCanvasId = "canvas";
        String actualCanvasId = "";

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Grabs string value from the Answer Box element by finding it by its xpath
        actualCanvasId = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/div/canvas")).getAttribute("id");

        //Checks if the expected string matches the string from the Answer Box
        if (actualCanvasId.equals(expectedCanvasId)){
            System.out.println("Message: Passed - Answer Box Text Found - Answer Box Loaded");
        } else {
            System.out.println("Message: Failed - Answer Box Text Not Found - Answer Box Not Loaded");
        }

        //After the result the driver is closed
        driver.close();
    }
}
