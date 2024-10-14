package speakbutton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class speak {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		WebDriverWait speak = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement button1 = speak.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")));
		button1.click();

		Thread.sleep(1000);
		WebDriverWait speak1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement button2 = speak1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")));
		button2.click();

		Thread.sleep(3000);
		WebDriverWait speak2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement button3 = speak2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")));
		button3.click();

		Thread.sleep(5000);
		driver.quit();

	}

}
