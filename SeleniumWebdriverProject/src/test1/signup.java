package test1;

//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class signup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[7]/h2/span")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/button[1]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/div[10]/div/div/div")).click();
		
		Thread.sleep(1000);
		WebElement nextbutton= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button"));// Replace with your
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextbutton);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbutton);

		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='root']/div/div/div/div/div[2]/div/div[2]/button")).click();
		
		
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/label[7]")).click();
        
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[3]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/label[3]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[3]/button")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/label[2]")).click();
		WebElement nextbutton1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", nextbutton1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextbutton1);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/label[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your name\"]")).sendKeys("aqsa");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/div/input")).sendKeys("pk");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("aqsa15@mailinator.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder=\"Enter your password\"]")).sendKeys("Test12345");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[1]/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[2]/section/div/div/div/div[2]/button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div/div/div/div/div/div[2]/button")).click();
		
		Thread.sleep(5000);

		driver.quit();
	}

}
