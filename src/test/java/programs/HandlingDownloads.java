package programs;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HandlingDownloads {
	private static final String DOWNLOADS_FODLER_NAME = "downloads";
	private static final String DOWNLOADS_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + DOWNLOADS_FODLER_NAME;
	private static final File DOWNLOADS_DIRECTORY = new File(DOWNLOADS_DIRECTORY_PATH);
	
	private static final String FILE_NAME = "selenium-java-4.35.0.zip";
	private static final File DOWNLOADED_FILE = new File(DOWNLOADS_DIRECTORY_PATH, FILE_NAME);
	
	public static void main(String[] args) {
		System.out.println("Program to handle file downloads...");
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", DOWNLOADS_DIRECTORY_PATH);
		prefs.put("download.prompt_for_download", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		String url = "https://www.selenium.dev/downloads/";
		
		try {
			if (!DOWNLOADS_DIRECTORY.exists()) {
				System.out.println("Folder '" + DOWNLOADS_FODLER_NAME + "' not present.");
				if (DOWNLOADS_DIRECTORY.mkdirs()) {
					System.out.println("Created " + DOWNLOADS_FODLER_NAME + " folder.");
				}
			}
			
			driver.get(url);
			
			String xpathStr = "//p[text()='Java']/following-sibling::p[contains(text(),'Stable')]/a";
			WebElement downloadLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathStr)));
			downloadLink.click();
			
			int timeOutSecondsForDownload = 30;
			int elaspedTime = 0;
			while (elaspedTime < timeOutSecondsForDownload && !DOWNLOADED_FILE.exists()) {
				Thread.sleep(1000);
				elaspedTime++;
			}
			
			if (DOWNLOADED_FILE.exists()) {
				System.out.println("File downloaded successfully!!!");
			}

			Assert.assertTrue(verifyDownloadedFile(), "Downloaded file not found.");

			if (DOWNLOADS_DIRECTORY.exists()) {
				DOWNLOADED_FILE.delete();
				DOWNLOADS_DIRECTORY.delete();
				System.out.println("Deleted " + DOWNLOADS_FODLER_NAME + " folder.");
			}
			
			driver.quit();

		} catch (Exception e) {
			throw new RuntimeException("Test execution failed.");
		} finally {
			driver.quit();
		}
	}
	
	private static boolean verifyDownloadedFile() {
		boolean flag = false;
		if (DOWNLOADED_FILE.exists()) {
			System.out.println("File found in the downloads directory.");
			flag = true;
		} else {
			System.err.println("File not found in the downloads directory.");
			flag = false;
		}
		return flag;
	}
}
