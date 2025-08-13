package programs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown_SelectByVisibleText {

	public static void main(String[] args) {
		System.out.println("Program to select dropdown value by visible text...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement carsList = wait.until(ExpectedConditions.elementToBeClickable(By.id("cars")));
			Select select = new Select(carsList);

			select.selectByVisibleText("Opel");
			System.out.println("Option selected: '" + select.getFirstSelectedOption().getText() + "'");

			WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
			submitButton.click();

			WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w3-container w3-large w3-border']")));
			String actualText = result.getText().trim();
			String expectedText = "cars=opel";

			if (actualText.equals(expectedText)) {
				System.out.println("Text displayed: '" + actualText + "'. Test Passed.");
			} else {
				System.out.println("Expected: '" + expectedText + "', but found: '" + actualText + "'. Test Failed.");
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
//Program to select dropdown value by visible text...
//Option selected: 'Opel'
//Text displayed: 'cars=opel'. Test Passed.
