package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsEnabled {

	public static void main(String[] args) {
		System.out.println("Checking if First Name text box is enabled...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement firstNameElement = driver.findElement(By.id("fname"));
			boolean isEnabled = firstNameElement.isEnabled();

			if (isEnabled) {
				System.out.println("First name text box is enabled. Test Passed.");
			} else {
				System.out.println("First name text box is disabled. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed: " + e.getMessage(), e);
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Checking if First Name text box is enabled...
// First name text box is enabled. Test Passed.
