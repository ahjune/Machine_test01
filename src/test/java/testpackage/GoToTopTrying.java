package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoToTopTrying {
	
	ChromeDriver driver;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		driver.get("https://www.redwolf.in/index.php?route=account/login");
		driver.manage().window().maximize(); //max the screen
	}
	
	@Test
	public void mytry() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        //code to go down at first
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        //spotting the icon
	        WebElement goToTopButton = driver.findElement(By.xpath("//*[@id=\"scrollUp\"]"));

	        // click the "Gototop" button
	        goToTopButton.click();

	        // verify if the page has scrolled back to the top
	        Double scrollPosition = (Double) js.executeScript("return window.pageYOffset;");

	        if (scrollPosition == 0) {
	            System.out.println("Go to Top button works correctly!");
	        } else {
	            System.out.println("Go to Top button did not work!");
	        }
	    	
	    }
	}
