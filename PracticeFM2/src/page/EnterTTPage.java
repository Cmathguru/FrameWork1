package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class EnterTTPage extends BasePage{
	@FindBy(xpath="//div[contains(text(),'Help')]")	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")	private WebElement AboutIt;
	
	@FindBy(css="span.productVersion")	private WebElement version;
	
//	@FindBy(id="aboutPopupCloseButtonId")	private WebElement close;
	@FindBy(xpath="//div[@id='gettingStartedShortcutsMenuCloseId']") private WebElement gettingStart;
	
	@FindBy(xpath="(//div[@class='closeButton'])[2]")	private WebElement close;
	
	@FindBy(id="logoutLink")	private WebElement logoutlink;
	
	public EnterTTPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void closeGettingStartPop() {
		gettingStart.click();
	}
	
	public void clickHelp()
	{
		CustoWaitAndClick(help);
	}
	
	public void clickAboutActitime(){
		
		AboutIt.click();
	}
	
	public void VerifyVersion(String eText)
	{
		VerifyText(version, eText);
	}
	
	public void clickCloseButton()
	{
		CustoWaitAndClick(close);
		//close.click();
	}
	
	public void clickLogout()
	{
		CustoWaitAndClick(logoutlink);
		//logoutlink.click();
	}

}
