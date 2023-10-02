package spicejetautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginDummyAndClickLogin {
    private WebDriver driver;
    private final String url = "https://www.spicejet.com/";

    @BeforeTest
    public void setUp() throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
 "C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the SpiceJet website
        driver.get(url);
        Thread.sleep(5000);
    }

    @Test
    public void loginTest() throws InterruptedException {
        // Click the "Login / Signup" link at the top of the page
        WebElement loginLink = driver.findElement(By.xpath("//div[text()=\"Login\"]"));
        loginLink.click();
        Thread.sleep(5000);

        // Switch to the login frame if it's in an iframe (if not, skip this step)
        // driver.switchTo().frame("frameName");

        // Find the email ID and password fields and enter dummy values
        WebElement emailCheckbox = driver.findElement(By.xpath("//div[text()=\"Email\"]"));
        emailCheckbox.click();
        Thread.sleep(5000);
        
        WebElement emailField = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        emailField.sendKeys("kalpeshpatil028@gmail.com");
        Thread.sleep(4000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        passwordField.sendKeys("Kalpesh@1");
        Thread.sleep(2000);

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//div[text()=\"Login\"]"));
        loginButton.click();
        System.out.println("Clicked on login button");
        Thread.sleep(5000);

        // You can add validation logic here to check if the login was successful or not
        // For example, you can check for a welcome message or an error message.

    }

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
