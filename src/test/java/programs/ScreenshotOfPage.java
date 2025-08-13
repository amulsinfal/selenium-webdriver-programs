package programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotOfPage {
	
	public static void main(String[] args) {
		System.out.println("Program to take a screenshot of a web page...");
		
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        String url = "https://www.w3schools.com/W3CSS/tryw3css_examples_pricing_tables.htm";	
		
        try {
			driver.get(url);
		
			new File("screenshots").mkdirs();
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir")+"/screenshots/PageScreenshot.png");
			FileHandler.copy(source, destination);
			
			System.out.println("Screenshot of the page taken successfully and saved at: " + destination.getAbsolutePath());
			
		}catch(Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to take a screenshot of a web page...
// Screenshot of the page taken successfully and saved at: C:\Software_Testing\Automation_Testing\selenium-programs\eclipse-workspace\selenium-programs\screenshots\PageScreenshot.png
