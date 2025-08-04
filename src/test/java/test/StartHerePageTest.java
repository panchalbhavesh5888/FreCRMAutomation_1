package test;

import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;
import page.StartHerePage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class StartHerePageTest extends TestBase {
	StartHerePage startHere;
	LoginPage loginPage;
	
	
  public StartHerePageTest() throws IOException {
		super();
	}
  
  @BeforeMethod
  public void setUp() throws IOException {
	  initialization();
	   startHere = new StartHerePage();  
  }
  
  @AfterMethod
  public void tearDown() {
	  driver.quit();	  
  }
  
@Test(priority=1)
  public void startHerePageTitleTest() {
	String title = startHere.validateStartHerePageTitle();
	System.out.println(title);
	Assert.assertEquals(title, "#1 Free CRM Software Power Up your Entire Business Free Forever");
  }

@Test(priority=2)
 public void FreeCRMLogoTest() {
	boolean logo = startHere.validateCRMLogo();
	Assert.assertTrue(logo,"FreeCRMLogo is not  present");
 }

@Test(priority=3)
public void StartHereButtonTest() {
	boolean starthere = startHere.validateStartHereButton();
	Assert.assertTrue(starthere,"StartHere button is not  present");
}

@Test(priority=4)
public void SignUpButtonTest() {
	boolean signUpBtn = startHere.validateSignUpButton();
	Assert.assertTrue(signUpBtn,"SignUp button is not  present");
}

@Test(priority=5)
public void NumberOfHeaderTest() {
	long totalHeader = startHere.validateNumberOfHeader();
	System.out.println("Total number of headers are:"+totalHeader);
	Assert.assertEquals(totalHeader, 5);
}

@Test
public void StartHereTest() throws IOException {
	loginPage = startHere.clickOnStartHere();
}


}
