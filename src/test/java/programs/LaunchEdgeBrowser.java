package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdgeBrowser {
	public static void main(String[] args) {
		System.out.println("Program to launch Edge browser...");

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.google.com/";

		try {
			driver.get(url);

			String actualTitle = driver.getTitle();
			String expectedTitle = "Google";

			if (actualTitle.equals(expectedTitle)) {
				System.out.println("Current Title is as expected: " + actualTitle + ". Test Passed.");
			} else {
				System.out.println("Expected Title: " + expectedTitle + ", but found: " + actualTitle + ". Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to launch Edge browser...
// Current Title is as expected: Google. Test Passed.
