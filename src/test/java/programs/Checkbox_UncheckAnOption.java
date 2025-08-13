package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox_UncheckAnOption {

	public static void main(String[] args) {
		System.out.println("Program to uncheck if a checkbox is selected...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_checked";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement boatCheckboxOption = driver.findElement(By.xpath("//input[@value='Boat']"));
			System.out.println("\"I have a boat\" Checkbox initially checked: " + boatCheckboxOption.isSelected());
			boatCheckboxOption.click();

			boolean result = boatCheckboxOption.isSelected();

			if (!result) {
				System.out.println("\"I have a boat\" Checkbox not checked. Test Passed.");
			} else {
				System.out.println("\"I have a boat\" Checkbox is checked. Test Failed.");
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
// Program to check if a checkbox is selected...
// "I have a boat" Checkbox is checked. Test Passed.
