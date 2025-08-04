package page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	
	
	//Page factory
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//div[contains(text(),'Something went wrong...')]")
	WebElement loginErr;
	
	
	public LoginPage() throws IOException  {
		super();
		PageFactory.initElements(driver,this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String usrnm, String psswrd) throws IOException {
		username.sendKeys(usrnm);
		password.sendKeys(psswrd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public String readEmptyEmailErr() throws IOException {
		
		String actualErr = loginErr.getText();
		return actualErr;
	}
	
	public String readEmptyPassErr() throws IOException {
		String actualErr = loginErr.getText();
		return actualErr;
	}
	
	
	
	
	
	
	
	
	

}
