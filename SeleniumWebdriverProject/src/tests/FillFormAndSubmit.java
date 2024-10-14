package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FillFormAndSubmit {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to your chromedriver executable
    	System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the target webpage
        	driver.get("https://staging.yourteacher.ai/");
    		driver.manage().window().maximize();
    		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
    		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
    		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
    		
    		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    		WebElement textarea = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder='Hi there, talk to me...']")));

    		textarea.sendKeys("Hello!");
    		Thread.sleep(5000);
    		driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div/div[1]/button")).click();

    		Thread.sleep(5000);

            // Create a WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

            // Fill out the form
            sendKeysToElement(wait, By.cssSelector("input#cardNumber"), "4242 4242 4242 4242");
            sendKeysToElement(wait, By.cssSelector("input#cardExpiry"), "01/28");
            sendKeysToElement(wait, By.cssSelector("input#cardCvc"), "123");
            sendKeysToElement(wait, By.cssSelector("input[placeholder=\"Full name on card\"]"), "abcd");

            // Click the submit button
            clickElement(wait, By.cssSelector("div.SubmitButton-IconContainer"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
        	Thread.sleep(8000);
            driver.quit();
        }
    }

    // Helper method to send keys to an element
    private static void sendKeysToElement(WebDriverWait wait, By locator, String keys) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(keys);
    }

    // Helper method to click an element
    private static void clickElement(WebDriverWait wait, By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }
}
