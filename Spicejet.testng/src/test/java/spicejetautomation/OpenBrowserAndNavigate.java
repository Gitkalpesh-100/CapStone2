package spicejetautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowserAndNavigate {
    private WebDriver driver;
    private final String url = "https://www.spicejet.com/";

    @BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
 "C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        
        // Initialize ChromeDriver
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void openSpiceJetWebsite() {
        // Navigate to the SpiceJet website
        driver.get(url);
        
    
    }
    

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
