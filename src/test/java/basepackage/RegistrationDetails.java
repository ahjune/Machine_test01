package basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationDetails  {
ChromeDriver driver;
	
	@FindBy(xpath="/html/body/div[11]/div[1]/div[1]/a")
	WebElement click_here_to_register;
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement first_name;
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement last_name;
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement e_mail;
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement telephone;
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement password;
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement confirm_password;
	//Note: The site already has selected the button in the case of newsletter.
	@FindBy(xpath="//*[@id=\"register-button\"]")
	WebElement continue_button;
	
	public RegistrationDetails(WebDriver driver) {
		this.driver=(ChromeDriver) driver;
		PageFactory.initElements(driver, this);
	}
	
	public void entries() {
		click_here_to_register.click();
		first_name.sendKeys("Prema");
		last_name.sendKeys("Kumari");
		e_mail.sendKeys("prema63kumari@gmail.com");
		telephone.sendKeys("9567696731");
		password.sendKeys("k1lle6p@$ha");
		confirm_password.sendKeys("k1lle6p@$ha");
		continue_button.click();
	}
}
