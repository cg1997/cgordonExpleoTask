import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the inital table row in the webpage has loaded correctly - TC07
public class TC07_TableRowLoadTest {

    public static void main(String[] args) throws Exception {
        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String actualColumnValue1 = "";
        String actualColumnValue2 = "";
        String actualColumnValue3 = "";
        String actualColumnValue4 = "";
        String actualColumnValue5 = "";
        String actualColumnValue6 = "";

        //Arraylists for expected row values and actual row values for comparisons
        ArrayList<String> allExpectedColumnValues = new ArrayList<String>(Arrays.asList("Iuvaret0", "Apeirian0", "Adipisci0", "Definiebas0", "Consequuntur0", "Phaedrum0"));
        ArrayList<String> allActualColumnValues = new ArrayList<String>();

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Each row value is added to the arraylist
        actualColumnValue1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[1]")).getText();
        allActualColumnValues.add(actualColumnValue1);
        actualColumnValue2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
        allActualColumnValues.add(actualColumnValue2);
        actualColumnValue3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[3]")).getText();
        allActualColumnValues.add(actualColumnValue3);
        actualColumnValue4 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[4]")).getText();
        allActualColumnValues.add(actualColumnValue4);
        actualColumnValue5 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[5]")).getText();
        allActualColumnValues.add(actualColumnValue5);
        actualColumnValue6 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[6]")).getText();
        allActualColumnValues.add(actualColumnValue6);


        //Grabs arraylists for the found row values and compares them with the expected row result arraylist
        if (allActualColumnValues.equals(allExpectedColumnValues)) {
            System.out.println("Message: Passed - Row Text Found - Initial Row Loaded");
        } else {
            System.out.println("Message: Failed - Row Text Not Found - Initial Row Not Loaded");
        }

        //After the result the driver is closed
        driver.close();
    }
}
