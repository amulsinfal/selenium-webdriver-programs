package programs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {

		System.out.println("Program to demonstrate navigation in Selenium WebDriver...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.google.com/";

		try {
			driver.get(url);
			System.out.println("Navigated to: " + url);
			System.out.println("Current Title: " + driver.getTitle());

			// Navigate to gmail URL
			driver.navigate().to("https://www.gmail.com/");
			System.out.println("Navigated to: https://www.gmail.com/");
			String gmailTitle = driver.getTitle();
			System.out.println("Current Title: " + gmailTitle);

			// Navigate back
			driver.navigate().back();
			System.out.println("Navigated back.");
			String googleTitle = driver.getTitle();
			System.out.println("Current Title after navigating back: " + googleTitle);

			// Navigate forward
			driver.navigate().forward();
			System.out.println("Navigated forward.");
			String currentTitle = driver.getTitle();
			System.out.println("Current Title after navigating forward: " + currentTitle);

			// Refresh the page
			driver.navigate().refresh();
			System.out.println("Page refreshed.");
			String refreshedTitle = driver.getTitle();
			System.out.println("Current Title after refresh: " + refreshedTitle);

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}
}

// Output:
// Program to demonstrate navigation in Selenium WebDriver...
// Navigated to: https://www.google.com/
// Current Title: Google
// Navigated to: https://www.gmail.com/
// Current Title: Gmail: Private and secure email at no cost | Google Workspace
// Navigated back.
// Current Title after navigating back: Google
// Navigated forward.
// Current Title after navigating forward: Gmail: Private and secure email at no cost | Google Workspace
// Page refreshed.
// Current Title after refresh: Gmail: Private and secure email at no cost | Google Workspace
