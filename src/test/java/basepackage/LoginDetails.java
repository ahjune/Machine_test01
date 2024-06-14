package basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDetails {
	ChromeDriver driver;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement registered_email;
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement confirmed_password;
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement login_button;
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/div/i")
	WebElement icon;
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/div/div/ul/a[5]/li")
	WebElement log_out;
	
	
	public LoginDetails(WebDriver driver) { //parameter
		this.driver=(ChromeDriver) driver;
		PageFactory.initElements(driver, this); //initializes the web elements in the current class context using PageFactory.initElements
	}
	
	public void passingvalues() {
		registered_email.sendKeys("prema63kumari@gmail.com");
		confirmed_password.sendKeys("k1lle6p@$ha");
		login_button.click();
		icon.click();
		log_out.click();
	}
}
