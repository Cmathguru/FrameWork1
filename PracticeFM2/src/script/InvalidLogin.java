package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2)
	
	public void testInValidLogin() throws InterruptedException
	{
       String un = Excel.getData(XL_PATH, "InValidLogin", 1, 0);
       String pw = Excel.getData(XL_PATH, "InValidLogin", 1, 1);
       String emsg = Excel.getData(XL_PATH, "InValidLogin", 1, 2);
             
      
       
       LoginPage l=new LoginPage(driver);
       
     //Enter valid username
       l.setUsername(un);
       
     //Enter valid password
       l.setPassword(pw);
       
     //click login button
       l.Loginclk();
       
       Thread.sleep(2000);
       
     //Verify that errormessage is  is displayed
       
     l.verifyErrMsg(emsg);
        
       
	}

}
