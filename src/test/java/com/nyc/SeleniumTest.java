package com.nyc;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    // Set up the WebDriver and open the page
    @BeforeClass
    public void setup() {
        // Set the Chrome driver location (make sure you have downloaded the correct version of chromedriver)
        System.setProperty("webdriver.chrome.driver", "C:/Users/vinay/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

        // Create an instance of ChromeDriver (you can use other browsers too)
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-proxy-server");

        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);




        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Open the HTML page (use your local file path or a URL if it's hosted)
        //driver.get("www.google.com");  // Update this with your actual local path or URL
    }

    // Test the name concatenation functionality
    //@Test
    public void testConcatenateNames() {
        // Declare the names to be entered
        String name1 = "Haritha";
        String name2 = "Morramreddy";

        // Find the input fields for first and last names by their IDs
        WebElement name1Field = driver.findElement(By.id("name1"));
        WebElement name2Field = driver.findElement(By.id("name2"));

        // Enter the names in the input fields
        name1Field.sendKeys(name1);
        name2Field.sendKeys(name2);

        // Find and click the Submit button
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitButton.click();

        // Wait for the result (you can use WebDriverWait here if you need more control over waiting)
        try {
            Thread.sleep(2000); // Sleep for 2 seconds to allow the result to show (replace with WebDriverWait for better handling)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the concatenated full name displayed in the paragraph
        WebElement fullName = driver.findElement(By.id("fullName"));
        String fullNameText = fullName.getText();

        // Assert that the full name is correct
        String expectedFullName = name1 + " " + name2;
        Assert.assertEquals(fullNameText, expectedFullName, "Full name does not match!");

        // Print the result to console (optional)
        System.out.println("Full Name: " + fullNameText);
    }
  @Test
   public void googlesearch() {
        driver.get("http://www.google.com");

      WebElement googlesearchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
      googlesearchbox.sendKeys("Haritha");
      WebElement googlesubmitButton = driver.findElement(By.name("btnK"));
      googlesubmitButton.click();

  }
    @Test
    public void googletext() {
        driver.get("http://www.google.com");

        WebElement googlesearchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
        googlesearchbox.sendKeys("Haritha");
        WebElement googlesubmitButton = driver.findElement(By.name("btnK"));
        googlesubmitButton.click();
    }
    // Close the browser after tests are done
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
