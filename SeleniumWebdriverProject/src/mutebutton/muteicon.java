package mutebutton;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class muteicon {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement textarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea[placeholder='Hi there, talk to me...']")));

		textarea.sendKeys("Hello!");

		Thread.sleep(5000);

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

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		
		
		
		WebDriverWait mute = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement element0 = mute.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]")));
		element0.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]")).click();
		
		
		
		Thread.sleep(5000);
		driver.quit();

	}

}
