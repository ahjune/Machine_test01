package testpackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	@Test (priority = 2)
	public void logintest() {
		LoginDetails obj1=new LoginDetails(driver);
		obj1.passingvalues();
	}
	
	//logo_code
	@Test (priority = 1)
	public void testlogo() {
		boolean logoPresent = driver.findElement(By.xpath("//*[@id=\"header-logo\"]")).isDisplayed();
		
		if(logoPresent) {
			System.out.println("present");
		}
		else {
			System.out.println("absent");
		}
	}
	
	//title verification
	@Test (priority = 3)
	public void verifytitle() {
		   String actualTitle = driver.getTitle();
	        String expectedTitle = "https://www.redwolf.in/";

	        // Verify the title using if-else statement
	        if (actualTitle.equals(expectedTitle)) {
	            System.out.println("Title verification passed!");
	        } else {
	            System.out.println("Title verification failed! Expected: " + expectedTitle + ", but got: " + actualTitle);
	        }
	}
	
	//forgot password link functioning or not
	@Test (priority = 4)
	public void forgotpasswordlink() {
	       WebElement linkElement = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/a"));
	        String url = linkElement.getAttribute("href");

	        // Verify the link
	        if (isLinkWorking(url)) {
	            System.out.println("Link verification passed!");
	        } else {
	            System.out.println("Link verification failed!");
	        }
	}
	
	private boolean isLinkWorking(String url) {
		return false;
	}
	
	//functioning links
	@Test (priority = 5)
	public void links() throws IOException {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));

        // Verify each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            // Check if the URL is not null or empty
            if (url != null && !url.isEmpty()) {
                if (isLinkWorking(url)) {
                    System.out.println("Link is working: " + url);
                } else {
                    System.out.println("Link is not working: " + url);
                }
            } else {
                System.out.println("Link is empty or null: " + link.getText());
            }
        }
    }

    public static boolean isLinkWorking1(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return (responseCode >= 200 && responseCode < 400); // Check for successful response codes
        } catch (IOException e) {
            System.out.println("Exception occurred while verifying link: " + e.getMessage());
            return false;
        }
    }
   

	@AfterTest
	public void stop() {
		driver.close(); //close the current browser
	}
}
