package Academy.EndtoEndProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import pageObject.landingPage;
import pageObject.loginPage;

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

//import java.utility.ExcelUtils;
import resources.base;

public class HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	public void loadWebsite() throws IOException, ClassNotFoundException {
		//dataBaseConnectivity();
		driver = initializeDriver();
		log.info("Driver is initalized");
		
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
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to website..");
		landingPage lpage = new landingPage(driver);
		lpage.getLogin().click();
		
	}
	@Test(dataProvider="loginTestData")
	public void checkLoginCredentials(String userName, String Password) throws InterruptedException
	{
		//System.out.println("calling test for ..........."+userName+"and "+Password);
		//driver.get(prop.getProperty("url"));
		//landingPage lnpage = new landingPage(driver);
	//	lnpage.getLogin().click();
		loginPage lpage = new loginPage(driver);
		lpage.checkLoginUserName().sendKeys(Keys.CONTROL+"a");
		//Thread.sleep(5000);
		lpage.checkLoginUserName().sendKeys(userName);
		lpage.checkLoginPassword().sendKeys(Password);
		//Thread.sleep(5000);
		lpage.checkLoginButton().click();
	}
	
	@DataProvider
	public Object [][] loginTestData() throws IOException
{
		Object o[][] =new Object[4][2];
	//	Object obj[][] = ExcelUtils.
/*        Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\purvi\\Desktop\\logintestdata.xlsx","Sheet1");

        return (testObjArray);*/

		o[0][0] = "purvi";
		o[0][1] = "purvi1";
		o[1][0] = "purvi2";
		o[1][1] = "purvi3";
		o[2][0] = "purvi4";
		o[2][1] = "purvi5";
		o[3][0] = "purvi4";
		o[3][1] = "purvi5";
		
			/*File f = new File("C:\\Users\\purvi\\Desktop\\logintestdata.xlsx");
			
			FileInputStream str = new FileInputStream(f);
			//HSSFWorkbook wb = new HSSFWorkbook(str);
			XSSFWorkbook xfsc= new XSSFWorkbook(str);
			
			XSSFSheet mySheet = xfsc.getSheetAt(0); // Get iterator to all the rows in current sheet Iterator<Row> rowIterator = mySheet.iterator(); // Traversing over each row of XLSX file while (rowIterator.hasNext()) { Row row = rowIterator.next(); // For each row, iterate through each columns Iterator<Cell> cellIterator = row.cellIterator(); while (cellIterator.hasNext()) { Cell cell = cellIterator.next(); switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING: System.out.print(cell.getStringCellValue() + "\t"); break;
		
			System.out.println("First row no = "+mySheet.getFirstRowNum());
			System.out.println("Last row= "+mySheet.getLastRowNum());
			System.out.println("no of col  = "+mySheet.getRow(mySheet.getFirstRowNum()).getLastCellNum());
			//System.out.println("Last row= "+mySheet.getLastRowNum());
			
			//System.out.println("first row,cell 1 = "+mySheet.getRow(mySheet.getFirstRowNum()).getCell(0));
			//System.out.println("first row,cell 2 = "+mySheet.getRow(mySheet.getFirstRowNum()).getCell(1));
			//System.out.println("first row,cell 3 ="+mySheet.getRow(mySheet.getFirstRowNum()).getCell(2));
			
			
			for(int i=mySheet.getFirstRowNum();i<=mySheet.getLastRowNum();i++) {
				for(int j=mySheet.getRow(mySheet.getFirstRowNum()).getFirstCellNum();j<mySheet.getRow(mySheet.getFirstRowNum()).getLastCellNum();j++) {
					
					if(!mySheet.getRow(i).getCell(j).equals(null))
					{
						o[i][j] = mySheet.getRow(i).getCell(j);
					System.out.print("           "+mySheet.getRow(i).getCell(j));
					}
				}	
				System.out.println("");
			}
*/	
		  return o;

	}

	
}
