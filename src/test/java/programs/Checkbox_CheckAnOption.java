package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkbox_CheckAnOption {

	public static void main(String[] args) {
		System.out.println("Program to check a checkbox...");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_display_checkbox_text";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement checkboxOption = driver.findElement(By.id("myCheck"));
			checkboxOption.click();

			WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text")));
			if (result.getText().equals("Checkbox is CHECKED!")) {
				System.out.println("Checkbox is checked. Test Passed.");
			} else {
				System.out.println("Checkbox is not checked. Test Failed.");
			}

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to check a checkbox...
// Checkbox is checked. Test Passed.
