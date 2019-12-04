import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

//Code adapted and referenced from https://www.guru99.com/first-webdriver-script.html
//Test for checking if the Table titles in the webpage have loaded correctly TC06
public class TC06_TableTitlesLoadTest {

    public static void main(String[] args) throws Exception {
        String baseUrl = "https://the-internet.herokuapp.com/challenging_dom";
        String actualTitle1 = "";
        String actualTitle2 = "";
        String actualTitle3 = "";
        String actualTitle4 = "";
        String actualTitle5 = "";
        String actualTitle6 = "";
        String actualTitle7 = "";

        //Arraylists for expected titles and actual titles for comparisons
        ArrayList<String> allExpectedTitles = new ArrayList<String>(Arrays.asList("Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action"));
        ArrayList<String> allActualTitles = new ArrayList<String>();

        //Locates chrome webdriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //driver goes to webpage
        driver.get(baseUrl);

        //Wait for page to load
        TimeUnit.SECONDS.sleep(2);

        //Each title is added to the arraylist
        actualTitle1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[1]")).getText();
        allActualTitles.add(actualTitle1);
        actualTitle2 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[2]")).getText();
        allActualTitles.add(actualTitle2);
        actualTitle3 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[3]")).getText();
        allActualTitles.add(actualTitle3);
        actualTitle4 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[4]")).getText();
        allActualTitles.add(actualTitle4);
        actualTitle5 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[5]")).getText();
        allActualTitles.add(actualTitle5);
        actualTitle6 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[6]")).getText();
        allActualTitles.add(actualTitle6);
        actualTitle7 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/table/thead/tr/th[7]")).getText();
        allActualTitles.add(actualTitle7);


        //Grabs arraylists for the table titles and compares them with the expected result
        if (allActualTitles.equals(allExpectedTitles)) {
            System.out.println("Message: Passed - Table Titles Found - Table Titles Loaded");
        } else {
            System.out.println("Message: Failed - Table Titles Not Found - Table Titles Not Loaded");
        }

        //After the result the driver is closed
        driver.close();
    }
}
