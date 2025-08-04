package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TestBase;
import page.ContactsPage;
import page.HomePage;
import page.LoginPage;
import page.StartHerePage;
import util.TestUtil;


public class ContactsPageTest extends TestBase{
	StartHerePage startHerePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName = "contacts";
	
	
  public ContactsPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
@BeforeMethod
public void setUp() throws IOException {
	 initialization();
	 startHerePage = new StartHerePage();  
	 startHerePage.clickOnStartHere();
	 loginPage = new LoginPage(); 
	 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 contactsPage = homePage.clickOnContactsLink();
	 
 }
 
 @AfterMethod
 public void tearDown() {
	  driver.quit();	  
 }
 
 @DataProvider
 public Object[][] getCrmTestData() {
	Object data[][]= TestUtil.getTestData(sheetName);
	return data;	 
 }
 
@Test(priority=1)
  public void VerifyContactsPageLabel() {
	boolean contactsLable = contactsPage.verifyContactsLabel();
	Assert.assertTrue(contactsLable, "contactsLable is not displayed");
  }

@Test(priority=2)
public void SelectSingleContectByNameTest() throws InterruptedException {
	contactsPage.selectContactsByName("test1 test1");
}

@Test(priority=3)
public void SelectMultipleContectsByNameTest() throws InterruptedException {
	contactsPage.selectContactsByName("test1 test1");
	contactsPage.selectContactsByName("bhavesh panchal");
}

@Test(priority=4,dataProvider="getCrmTestData")
public void ValidateCreateNewContactTest(String fristName, String lastName){
	contactsPage.clickOnNewContactsLink();
	contactsPage.createNewContact(fristName, lastName);
}

}
