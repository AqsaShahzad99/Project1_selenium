package logingoogle;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class test3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.yourteacher.ai/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[6]/button")).click();
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/div/div/div/div[10]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/div/div/div/label[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]")).click();

		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/div/div/input")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/div/div/input")).sendKeys("pk");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/div/div/input")).sendKeys("career");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[1]/section/div/button")).click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
