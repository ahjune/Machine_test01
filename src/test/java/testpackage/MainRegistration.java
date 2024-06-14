package testpackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepackage.RegistrationDetails;

public class MainRegistration {
	ChromeDriver driver;
	
	@BeforeTest
	public void regstart() {
		driver=new ChromeDriver();
		driver.get("https://www.redwolf.in/index.php?route=account/login");
		driver.manage().window().maximize();
		 try {
	            // Wait for the alert to be displayed and store it in a variable
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	            
	        } catch (NoAlertPresentException e) {
	        	System.out.println("No alert is present.");
	        }
	}
	
	@Test
	public void firsttest() {
		RegistrationDetails obj = new RegistrationDetails(driver);
		obj.entries();
	}
	
	@AfterTest
	public void stop() {
		driver.close(); 
	}
}
