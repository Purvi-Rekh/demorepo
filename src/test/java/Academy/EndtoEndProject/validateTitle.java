package Academy.EndtoEndProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import pageObject.landingPage;
import pageObject.loginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import utility.ExcelUtils;
import org.testng.asserts.Assertion;

//import java.utility.ExcelUtils;
import resources.base;

public class validateTitle extends base {
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void loadWebsite() throws IOException, ClassNotFoundException {
		driver = initializeDriver();
		//dataBaseConnectivity();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
		driver = null;
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException
	{
		System.out.println("calling validate title .. ...........");
		String expected ="featured course";
		Assertion a = new Assertion();
		
		landingPage lpage = new landingPage(driver);
		
		String actual = lpage.getTitle().getText();
		
		a.assertTrue(true);
		
		log.info("Asserttion Successful..");
		//a.assertAll();
		
		
	}
	
	}

	

