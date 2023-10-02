package spicejetautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateSignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String url = "https://www.spicejet.com/";

    @BeforeTest
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver",
 "C:\\Users\\Kalpesh Patil\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        driver = new ChromeDriver();
        WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the SpiceJet website
        driver.get(url);
    }

    @Test
    public void signUpValidation() {
        // Find and click the "Login / Signup" link
        WebElement loginSignupLink = driver.findElement(By.id("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[3]/div[2]/div/a/div"));
        loginSignupLink.click();

        // Wait for the "signup" button to be present and clickable
        WebElement signUpButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("signup")));
        signUpButton.click();

        // Fill out mandatory fields
        WebElement titleDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle")));
        titleDropdown.sendKeys("Mr");

        WebElement firstNameField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxFirstName"));
        firstNameField.sendKeys("John");

        WebElement lastNameField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxLastName"));
        lastNameField.sendKeys("Doe");

        WebElement countryDropdown = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListCountry"));
        countryDropdown.sendKeys("United States");

        WebElement dobField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXDOB"));
        dobField.sendKeys("01/01/1990");

        WebElement mobileNumberField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINTLMOBILENUMBER"));
        mobileNumberField.sendKeys("1234567890");

        WebElement emailField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxEmail"));
        emailField.sendKeys("john.doe@example.com");

        WebElement passwordField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxPassword"));
        passwordField.sendKeys("Password123");

        WebElement confirmPasswordField = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TextBoxPasswordConfirm"));
        confirmPasswordField.sendKeys("Password123");

        // Check the "Terms and Conditions" checkbox
        WebElement termsCheckbox = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_CheckBoxAgree"));
        termsCheckbox.click();

        // Find and click the "Submit" button
        WebElement submitButton = driver.findElement(By.id("CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_ButtonSubmit"));
        submitButton.click();

        // Add validation logic for successful signup (e.g., verify a confirmation message)
        WebElement confirmationMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("confirmationMessage")));
        Assert.assertTrue(confirmationMessage.getText().contains("Registration successful"));

        // You can also add further validation based on the behavior after submitting the form.
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
