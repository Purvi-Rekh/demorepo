package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {

	WebDriver driver;
	public loginPage(WebDriver d)
	{
		driver =d;
	}
	public WebElement checkLoginUserName()
	{
		
		By userText = By.id("user_email");
		return driver.findElement(userText);	
	}
	
	public WebElement checkLoginPassword()
	{
		
		By passwordText = By.id("user_password");
		return driver.findElement(passwordText);
	}
	
	public WebElement checkLoginButton()
	{
		
		By loginButton = By.name("commit");
		return driver.findElement(loginButton);
	}
}
