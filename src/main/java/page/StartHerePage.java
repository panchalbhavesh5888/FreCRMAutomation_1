package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class StartHerePage extends TestBase {
	
	
	@FindBy(xpath = "//span[contains(text(),'Start Here')]")
	WebElement startHereBtn;
	
	@FindBy(xpath = "//span[contains(text(),'sign up')]")
	WebElement signupBtn;
	
	@FindBy (xpath = "(//div[@class='rd-navbar-brand'])[1]")
	WebElement FreeCRMLogo;
	
	

	public StartHerePage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	public String validateStartHerePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return FreeCRMLogo.isDisplayed();
	}
	
	public boolean validateStartHereButton() {
		return startHereBtn.isDisplayed();
	}
	
	public boolean validateSignUpButton() {
		return signupBtn.isDisplayed();
	}
	
	public LoginPage clickOnStartHere() throws IOException {
		startHereBtn.click();
		return new LoginPage();
	}
	
	public long validateNumberOfHeader() {
		List<WebElement> header = driver.findElements(By.xpath("//ul[@class='rd-navbar-nav']/li"));
		return header.size();
	}
	

}
