package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	
	public TestBase() throws IOException  {
		
		FileInputStream fi = new FileInputStream("C:\\QA1\\Selenium_Workspace\\FreCRMAutomation_1\\src\\main\\java\\config\\config.properties");//location of file with filName.FileType//
		prop = new Properties();//java.util to read write in  properties file
		prop.load(fi);
		
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		}else if(browserName.equals("chrome")) {
			driver= new ChromeDriver();
		}else if(browserName.equals("safari")) {
			driver= new SafariDriver();
		}else {
			driver= null;
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	

}
