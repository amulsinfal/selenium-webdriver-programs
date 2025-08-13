package programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotOfSection {

	public static void main(String[] args) {
		System.out.println("Program to take a screenshot of a specific section on the page...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/W3CSS/tryw3css_examples_pricing_tables.htm";

		try {
			driver.get(url);

			WebElement sectionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class='w3-ul w3-border w3-center w3-hover-shadow'])[2]")));

			new File("screenshots").mkdirs();
			File source = sectionElement.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir") + "/screenshots/SectionScreenshot.png");
			FileHandler.copy(source, destination);

			System.out.println("Screenshot of the section taken successfully and saved at: " + destination.getAbsolutePath());

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to take a screenshot of a specific section on the page...
// Screenshot of the section taken successfully and saved at: C:\Software_Testing\Automation_Testing\selenium-programs\eclipse-workspace\selenium-programs\screenshots\SectionScreenshot.png
