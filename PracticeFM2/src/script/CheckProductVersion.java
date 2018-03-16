package script;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import generic.AutoUtil;
import generic.BaseTest;
import generic.Excel;
import generic.IAutoConst;
import page.EnterTTPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest implements IAutoConst{
@Test(priority=3)
	
	public void testCheckProductVersion() throws InterruptedException
	{
		   String un = Excel.getData(XL_PATH, "ValidLogin", 1, 0);
	       String pw = Excel.getData(XL_PATH, "ValidLogin", 1, 1);
	       String version=Excel.getData(XL_PATH, "CheckProductVersion",1, 0);
	    	
		LoginPage l=new LoginPage(driver);
		
		//enter valid username
		l.setUsername(un);
		
		//enter valid password
		l.setPassword(pw);
		
		//click on login button
		l.Loginclk();
		
		
		EnterTTPage tt=new EnterTTPage(driver);
		
		String sITO = AutoUtil.getProperty(CONFIG_PATH, "ITO");
		long ITO=Long.parseLong(sITO);
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		
		//click on help
		 tt.clickHelp();
		
		//click on About your actitime
	     tt.clickAboutActitime();
		
		//verify the product version is actitime 2017.4
		  tt.VerifyVersion(version);
		
		//close the popup
     	tt.clickCloseButton();
		
     	//click logout
		tt.clickLogout();
		
	}	

}
