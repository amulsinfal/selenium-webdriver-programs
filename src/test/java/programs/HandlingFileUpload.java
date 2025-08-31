package programs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingFileUpload {

	private static final String UPLOAD_FODLER_NAME = "testData";
	private static final String UPLOAD_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + UPLOAD_FODLER_NAME;
	private static final String FILE_NAME = "TestFile.txt";
	private static final String UPLOAD_FILE_NAME = UPLOAD_DIRECTORY_PATH + File.separator + FILE_NAME;
	
	public static void main(String[] args) {
		System.out.println("Program to handle file upload...");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String url = "https://www.w3schools.com/howto/tryit.asp?filename=tryhow_html_file_upload_button";

		try {
			driver.get(url);
			driver.switchTo().frame("iframeResult");
			
			WebElement chooseFileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myFile")));
			System.out.println("Uploading file: " + FILE_NAME);
			chooseFileButton.sendKeys(UPLOAD_FILE_NAME);
			
			WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']")));
			submitButton.click();
			
			WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='w3-container w3-large w3-border']")));
			String actualText = result.getText().trim();
			String expectedText = "filename="+ FILE_NAME;

			if (actualText.equals(expectedText)) {
				System.out.println("Text displayed: '" + actualText + "'. Test Passed.");
			} else {
				System.out.println("Expected: '" + expectedText + "', but found: '" + actualText + "'. Test Failed.");
			}
			
		} catch(Exception e) {
			throw new RuntimeException("Test execution failed.", e);
		} finally {
			driver.switchTo().defaultContent();
			driver.quit();
		}
	}
}

// Output:
// Program to handle file upload...
// Uploading file: TestFile.txt
// Text displayed: 'filename=TestFile.txt'. Test Passed.

