package msgdynamic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicConversation {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
        // Set up the WebDriver and navigate to the chat page
    	System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://develop.yourteacher.ai/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa26@mailinator.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textarea = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder='Hi there, talk to me...']")));

		textarea.sendKeys("Hello!");

		Thread.sleep(10000);

		// Close Payment Modal
		// driver.findElement(By.cssSelector("svg.close")).click();

		driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div/div[1]/button")).click();

		Thread.sleep(5000);

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// stripe code

		String currentUrl = driver.getCurrentUrl();

		WebDriverWait wait0 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait0.until(ExpectedConditions.urlContains(currentUrl)); // Adjust the URL condition as needed

		// Switch to the new window handle if the Stripe page opens in a new window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(5000);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement button0 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#cardNumber")));
		button0.sendKeys("4242 4242 4242 4242");

		// WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement button1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#cardExpiry")));
		button1.sendKeys("01/28");

		// WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement button2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#cardCvc")));
		button2.sendKeys("123");

		// WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement button3 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder=\"Full name on card\"]")));
		button3.sendKeys("abcd");

		// WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement button4 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.SubmitButton-IconContainer")));
		button4.click();

        
        

        // Locators for the text area and the send button
        By textAreaLocator = By.cssSelector("textarea[placeholder=\"Hi there, talk to me...\"]");
        By sendButtonLocator = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]");
        By messageReceivedLocator = By.xpath("//*[@id=\"response-box\"]"); // Adjust based on actual HTML

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Define the conversation flow
        String[] responses = {"Hello", "I'm good, thank you!", "Not much, just chatting.", "Yes, I'm here.", "Goodbye"};
        int responseIndex = 0;

        // Initial message to start the conversation
        sendMessage(driver, wait, textAreaLocator, sendButtonLocator, responses[responseIndex++]);

        // Continue the conversation based on received messages
        while (responseIndex < responses.length) {
            String latestMessage = getLatestMessage(driver, wait, messageReceivedLocator);

            // Determine the response based on the received message
            if (latestMessage.contains("How are you")) {
                sendMessage(driver, wait, textAreaLocator, sendButtonLocator, responses[responseIndex++]);
            } else if (latestMessage.contains("What's up")) {
                sendMessage(driver, wait, textAreaLocator, sendButtonLocator, responses[responseIndex++]);
            } else if (latestMessage.contains("Are you there")) {
                sendMessage(driver, wait, textAreaLocator, sendButtonLocator, responses[responseIndex++]);
            } else if (latestMessage.contains("Goodbye")) {
                sendMessage(driver, wait, textAreaLocator, sendButtonLocator, responses[responseIndex++]);
                break;
            }
            // Add more conditions as needed
        }

        // Close the browser
        driver.quit();
    }

    // Function to read the latest received message
    private static String getLatestMessage(WebDriver driver, WebDriverWait wait, By messageLocator) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(messageLocator));
        return messageElement.getText();
    }

    // Function to send a message
    private static void sendMessage(WebDriver driver, WebDriverWait wait, By textAreaLocator, By sendButtonLocator, String message) {
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
        textArea.clear();
        textArea.sendKeys(message);
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
        sendButton.click();
    }
}
