package pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.base;

 public class landingPage extends base{
	
	public WebDriver driver;
	By title = By.xpath("//*[contains(text(),'Featured Courses')]");
	public landingPage(WebDriver d) {
		// TODO Auto-generated constructor stub
		driver=d;
	}
	
	//By Signin = By.partialLinkText("Login");
	public WebElement getLogin() throws InterruptedException
	{
	//	Thread.sleep(5000);
		//Alert a = driver.switchTo().alert();
		//a.dismiss();
		By Signin = By.cssSelector("a[href*='sign_in']");
		return driver.findElement(Signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
}
