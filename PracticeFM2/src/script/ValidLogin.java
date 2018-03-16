package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTTPage;
import page.LoginPage;

public class ValidLogin extends BaseTest{

	@Test(priority=1)
	public void testValidLogin()
	{
       String un = Excel.getData(XL_PATH, "ValidLogin", 1, 0);
       String pw = Excel.getData(XL_PATH, "ValidLogin", 1, 1);
       String eTitle = Excel.getData(XL_PATH, "ValidLogin", 1, 2);
             
      
       
       LoginPage l=new LoginPage(driver);
       
     //Enter valid username
       l.setUsername(un);
       
     //Enter valid password
       l.setPassword(pw);
       
     //click login button
       l.Loginclk();
       
       //Verify that homepage is displayed
       
       EnterTTPage tt=new EnterTTPage(driver);
       
       tt.VerifyPageIsDisplayed(driver, eTitle);
       
	}

}
