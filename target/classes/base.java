package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.util.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class base {

	Connection conn;
	Statement st;
	
	public static WebDriver driver;
	 public static Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		System.out.println("4");
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\purvi\\eclipse-workspace\\EndtoEndProject\\src\\main\\java\\Academy\\EndtoEndProject\\data.properties");
		prop.load(fis);
		System.out.println("5");
		String browserName = prop.getProperty("browser");
		String chromePath = prop.getProperty("chromepath");
		
		if(browserName.equals("chrome"))
		{
			System.out.println("6");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			System.out.println("7");
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("", "");
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("", "");
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}

	public void getErrorScreenShot(String result) throws IOException
	{
		File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
		//FileUtils. copyFile(src, new File("C:/selenium/error.png"));		
		Files.copy(src,new File("C:\\Selenium_Test_Screenshots\\"+result+"screenshot.png"));
		
	}
	
	/*public void dataBaseConnectivity() throws ClassNotFoundException
	{
		System.out.println("calling database.... ");
		Class.forName("com.mysql.jdbc.Driver");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank","purvi","");
			st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from ");
						
			while(rs.next())
			{
				System.out.println("row = "+rs.getRow());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*
	 * public class ScreenshootGoogle {
public void TestJavaS1()
WebDriver driver=new FirefoxDriver();
File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
try {
FileUtils. copyFile(src, new File("C:/selenium/error.png"));
catch (IOException e)
	 */
	 
}
