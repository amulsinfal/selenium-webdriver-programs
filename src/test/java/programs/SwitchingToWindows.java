package programs;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingToWindows {

	public static void main(String[] args) {
		System.out.println("Program to switch to new tab/window...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			String parentWindow = driver.getWindowHandle();
			System.out.println("Parent window ID: " + parentWindow);

			WebElement tryItButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Try it']")));
			tryItButton.click();

			wait.until(ExpectedConditions.numberOfWindowsToBe(2));

			Set<String> windowHandles = driver.getWindowHandles();
			for (String childWindow : windowHandles) {
				if (!childWindow.equals(parentWindow)) {
					driver.switchTo().window(childWindow);
					System.out.println("Switched to child window: " + childWindow);
					String pageTitle = driver.getTitle();
					if (pageTitle.equals("W3Schools Online Web Tutorials")) {
						System.out.println("Page title displayed: '" + pageTitle + "'. Test Passed.");
					} else {
						System.out.println("Unexpected Page title: '" + pageTitle + "'. Test Failed.");
					}
					driver.close();
				}
			}

			driver.switchTo().window(parentWindow);
			System.out.println("Switched back to parent window: " + parentWindow);

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
//Program to switch to new tab/window...
//Parent window ID: 545072C83284B24CF8F1A5B10526311A
//Switched to child window: 433E85645347C8274F69C8D3963DC51E
//Page title displayed: 'W3Schools Online Web Tutorials'. Test Passed.
//Switched back to parent window: 545072C83284B24CF8F1A5B10526311A
