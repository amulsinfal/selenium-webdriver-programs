package programs;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseAction_RightClick{

	public static void main(String[] args) {

		System.out.println("Program to implement Context Menu operation.");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_oncontextmenu";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");

			WebElement label = driver.findElement(By.xpath("//div/p"));
			Actions action = new Actions(driver);
			action.contextClick(label).perform();

			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String alertText = alert.getText();
			if (alertText.equals("You right-clicked inside the div!")) {
				System.out.println("Alert message displayed: '" + alertText + "'. Test Passed.");
			} else {
				System.out.println("Unexpected alert message: '" + alertText + "'. Test Failed.");
			}

			alert.accept();

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed due to: " + e.getMessage());
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to implement Context Menu operation.
// Alert message displayed: 'You right-clicked inside the div!'. Test Passed.
