package test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.HomePage;
import page.LoginPage;
import page.StartHerePage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	StartHerePage startHerePage;
	
	
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 @BeforeMethod
	  public void setUp() throws IOException {
		  initialization();
		 startHerePage = new StartHerePage();  
		 startHerePage.clickOnStartHere();
		 loginPage = new LoginPage();  
	  }
	  
	  @AfterMethod
	  public void tearDown() {
		  driver.quit();	  
	  }
	  
	  @Test(priority=1)
	  public void LoginPageTitleTest() {
		 String title = loginPage.validateLoginPageTitle();
		 Assert.assertEquals(title, "Cogmento CRM");
	  }
	  
	  @Test(priority=2)
	  public void LoginWithCorrectUsernameAndPasswordtTest() throws IOException, InterruptedException {
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 Thread.sleep(5000);
	  }
	  
	  @Test(priority=3)
	  public void LoginWithEmptyUsernametTest() throws IOException {
		 loginPage.login("", prop.getProperty("passowrd"));
		 String expectedErr= "Something went wrong...";
		 String actualErr= loginPage.readEmptyEmailErr();
		 Assert.assertEquals(actualErr, expectedErr);
	  }
	  @Test(priority=4)
	  public void LoginWithEmptyPasswordtTest() throws IOException {
		 loginPage.login(prop.getProperty("username"), "");
		 String expectedErr= "Something went wrong...";
		 String actualErr= loginPage.readEmptyPassErr();
		 Assert.assertEquals(actualErr, expectedErr);

	  }
	 
	  
	  
	  
}
