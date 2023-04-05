package myTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {

	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/sameh/eclipse-workspace/MiniProject2/resources/chromedriver.exe");

		// Open Browser chrome
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
