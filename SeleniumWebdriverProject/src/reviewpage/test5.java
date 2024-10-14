package reviewpage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
		driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
		driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();
		
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[2]/div[1]/div")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]")));
		page.click();
		
		WebElement page1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[3]")));
		page1.click();
		
		WebElement audiobutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/div/div[1]")));
		audiobutton.click();
		
		WebElement export = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[4]")));
		export.click();
		
		
		WebElement word = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div")));
		word.click();
		
		
		WebElement phrase = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div")));
		phrase.click();
		
		
		WebElement active = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[4]/div")));
		active.click();
		
		WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/button")));
		back.click();
		
		
		Thread.sleep(8000);
		driver.quit();

	}

}
