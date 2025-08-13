package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisabled {

	public static void main(String[] args) {
		System.out.println("Checking if Last Name text box is disabled...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement lastNameElement = driver.findElement(By.id("lname"));
			boolean isEnabled = lastNameElement.isEnabled();

			if (!isEnabled) {
				System.out.println("Last Name text box is disabled. Test Passed.");
			} else {
				System.out.println("Last Name text box is enabled. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Checking if Last Name text box is disabled...
// Last Name text box is disabled. Test Passed.
