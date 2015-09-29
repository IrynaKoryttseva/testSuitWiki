import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test102 {

	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://uk.wikipedia.org/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {
		driver.findElement(By.xpath(".//*[@id='p-logo']/a"));
		driver.findElement(By.xpath(".//*[@id='p-lang']/div/ul/li[13]/a"))
				.click();
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("D:\\Selenium\\Screen02.png"));
		driver.findElement(By.xpath(".//*[@id='p-lang']/div/ul/li[10]/a"))
				.click();
		File screenshot1 = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File("D:\\Selenium\\Screen03.png"));
		driver.findElement(By.xpath(".//*[@id='p-logo']/a")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}