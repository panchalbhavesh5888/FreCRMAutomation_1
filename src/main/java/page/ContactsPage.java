package page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//div[@class='item']/a")
	WebElement CreateNewContact;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	
	@FindBy (xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);

	}
	
	public boolean verifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td")) );
		Thread.sleep(2000);
		
		}

	public void clickOnNewContactsLink() {
		Actions hower = new Actions(driver);
		hower.moveToElement(CreateNewContact).build().perform();
		CreateNewContact.click();
		}
	
	
	public void createNewContact(String ftName, String lstName) {
		firstName.sendKeys(ftName);
		lastName.sendKeys(lstName);
		saveBtn.click();
	}
	
	}


	

