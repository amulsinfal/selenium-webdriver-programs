package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentUrlCommand {
	public static void main(String[] args) {
		System.out.println("Program to get Current Url...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.google.com/";

		try {
			driver.get(url);
			String actualcurrentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://www.google.com/";

			if (actualcurrentUrl.equals(expectedUrl)) {
				System.out.println("Current URL is as expected: " + actualcurrentUrl + ". Test Passed.");
			} else {
				System.out.println("Expected URL: " + expectedUrl + ", but found: " + actualcurrentUrl + ". Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to get Current Url...
// Current URL is as expected: https://www.google.com/. Test Passed.
