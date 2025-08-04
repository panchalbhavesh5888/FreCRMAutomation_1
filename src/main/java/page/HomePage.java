package page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	
	
	@FindBy(xpath="//span[contains(text(),'Bhavesh Panchal')]")
	WebElement userNameLable;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath= "//span[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath ="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath= "//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	
	public HomePage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver,this);
		}
	
	
	public String  varifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public  boolean varifyUserNameLable() {
		return userNameLable.isDisplayed();
	}
	
	public CalendarPage clickOnCalenderLink() {
		calendarLink.click();
		return new CalendarPage();
	}
	
	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public CompaniesPage clickOnCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskeLink() {
		tasksLink.click();
		return new TasksPage();
	}
	

	

	
	
	

}
