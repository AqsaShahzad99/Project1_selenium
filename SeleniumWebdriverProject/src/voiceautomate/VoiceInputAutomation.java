package voiceautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VoiceInputAutomation {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium webdriver\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://staging.yourteacher.ai/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[placeholder=\"Example@email.com\"]")).sendKeys("maaza987@gmail.com");
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Test12345");
        driver.findElement(By.cssSelector("button[color=\"blue\"]")).click();

        // Find and click the "speak" button
        Thread.sleep(3000);
        WebElement speakButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")); 
        speakButton.click();

        // Wait for the microphone to activate (simulate)
       
        TimeUnit.SECONDS.sleep(5); // Wait for 5 seconds (adjust as needed)
        

        // Simulate voice input by playing a pre-recorded audio file
        String audioFilePath = "C:\\Users\\Wajiz.pk\\Downloads\\Record (online-voice-recorder.com) (3).mp3"; // Replace with actual audio file path
        playAudio(audioFilePath);

        // Wait for the response
        WebDriverWait speak1 = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement responseElement = speak1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")));
        responseElement.click();

        // Close the browser
        
        Thread.sleep(8000);
        driver.quit();
    }

    // Method to play audio using command-line tool (e.g., VLC)
    private static void playAudio(String audioFilePath) {
        String vlcPath = "\"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe\"";
        String vlcCommand = vlcPath + " --play-and-exit \"" + audioFilePath + "\""; // Adjust command as per your media player
        try {
            Process process = Runtime.getRuntime().exec(vlcCommand);
            process.waitFor(); // Wait for the audio to finish playing
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
