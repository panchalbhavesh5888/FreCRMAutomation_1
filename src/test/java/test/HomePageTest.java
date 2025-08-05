package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.CalendarPage;
import page.CompaniesPage;
import page.ContactsPage;
import page.DealsPage;
import page.HomePage;
import page.LoginPage;
import page.StartHerePage;
import page.TasksPage;

public class HomePageTest extends TestBase {
	
	StartHerePage startHerePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	CalendarPage calendarPage;
	CompaniesPage companiesPage;
	TasksPage tasksPage;
	
	
	 public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		 //.
		//...
		//....
		
		
	
	}

	@BeforeMethod
	  public void setUp() throws IOException {
		 initialization();
		 startHerePage = new StartHerePage();  
		 startHerePage.clickOnStartHere();
		 loginPage = new LoginPage(); 
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();	  
	  }
	  
  @Test(priority=1)
  public void VerityHomePageTitleTest() {
	 String title = homePage.varifyHomepageTitle();
	 Assert.assertEquals(title,"Cogmento CRM");
  }
  
  @Test(priority=2)
  public void VerifyUserNameLableTest() {
	  boolean userNameLable = homePage.varifyUserNameLable();
	  Assert.assertTrue(userNameLable,"usernamelable is not displayed");
  }
  
  @Test(priority=3)
  public void ClickOnCalenderLinkTest() {
	 calendarPage = homePage.clickOnCalenderLink();  
  }
  
  @Test(priority=4)
  public void ClickOnContactsLinkTest() throws IOException {
	  contactsPage = homePage.clickOnContactsLink();  
  }
  
  @Test(priority=4)
  public void ClickOnCompaniesLinkTest() {
	 companiesPage = homePage.clickOnCompaniesLink();  
  }
  
  @Test(priority=4)
  public void ClickOnDealsLinkTest() {
	 dealsPage = homePage.clickOnDealsLink();  
  }
  
  
  @Test(priority=4)
  public void ClickOnTasksLinkTest() {
	  tasksPage = homePage.clickOnTaskeLink();  
  }
  

  
}
