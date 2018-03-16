package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class LoginPage extends BasePage{
	@FindBy(id="username")
	private WebElement unTB;
	
	@FindBy(name="pwd")
	private WebElement unPWD;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;
	
	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement errmsg;
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	
	}
	
	
	public void setUsername(String un)
	{
		unTB.sendKeys(un);
	}
	

	public void setPassword(String pw)
	{
		unPWD.sendKeys(pw);
	}
	
	public void Loginclk()
	{
		loginBTN.click();
	}
	
	public void verifyErrMsg(String eText)
	{
		VerifyText(errmsg, eText);
	}

}
