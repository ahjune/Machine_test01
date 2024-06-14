package testpackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepackage.LoginDetails;
public class MainLoginTest {
	ChromeDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.redwolf.in/index.php?route=account/login");
		driver.manage().window().maximize(); //max the screen
	}
	
	@Test (priority = 1)
	public void logintest() {
		LoginDetails obj1=new LoginDetails(driver);
		obj1.passingvalues();
	}
	
	@AfterTest
	public void stop() {
		driver.close(); //close the current browser
	}
}
