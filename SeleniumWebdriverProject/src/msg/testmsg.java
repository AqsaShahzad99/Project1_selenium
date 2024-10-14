package msg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testmsg {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://develop.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa22@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder='Hi there, talk to me...']")));

		textarea.sendKeys("Hello!");

		Thread.sleep(8000);

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
	 
		
		//code for sending message to teacher

		
//		  WebDriverWait wait6= new WebDriverWait(driver, Duration.ofSeconds(30));
//		  WebElement text0 =wait6.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder=\"Hi there, talk to me...\"]")));
//		  text0.sendKeys("hello");
//		  
//		  
//		  WebDriverWait wait7= new WebDriverWait(driver, Duration.ofSeconds(30));
//		  WebElement text1 =wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]")));
//		  text1.click();
		
		String[] messages = {"Hello", "How are you?", "What's up?", "Are you there?", "Goodbye"};

        // Locator for the text area and the send button
        By textAreaLocator = By.cssSelector("textarea[placeholder=\"Hi there, talk to me...\"]");
        By sendButtonLocator = By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]");

        WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Send each message with a wait in between
        for (String message : messages) {
            WebElement textArea = wait9.until(ExpectedConditions.visibilityOfElementLocated(textAreaLocator));
            textArea.clear();
            textArea.sendKeys(message);

            WebElement sendButton = wait9.until(ExpectedConditions.elementToBeClickable(sendButtonLocator));
            sendButton.click();

            // Wait for a few seconds before sending the next message
            
		
		  Thread.sleep(15000);
		 
        }
		// Code for play button

		
		  WebDriverWait play = new WebDriverWait(driver, Duration.ofSeconds(30));
		  WebElement playbutton =play.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"response-box\"]/div[2]/div[1]/div[1]"))); 
		  playbutton.click();
		 

		// Code for translate button

		
		  WebDriverWait translate = new WebDriverWait(driver, Duration.ofSeconds(30));
		  WebElement translatebutton =translate.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"response-box\"]/div[2]/div[1]/div[2]")));
		  translatebutton.click();
		 
		// Code for copy button

		
		  WebDriverWait copy = new WebDriverWait(driver, Duration.ofSeconds(30));
		  WebElement copybutton =copy.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.copy__icon")));
		  copybutton.click();
		 

		  Thread.sleep(5000);
		  driver.quit();
	}

	}


