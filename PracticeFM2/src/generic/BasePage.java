package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	public void VerifyPageIsDisplayed(WebDriver driver,String eResult)
	{
          String sETO = AutoUtil.getProperty(IAutoConst.CONFIG_PATH,"ETO");
          
          long ETO=Long.parseLong(sETO);
          
          WebDriverWait wait=new WebDriverWait(driver, ETO);
          
          try
          {
        	  wait.until(ExpectedConditions.titleIs(eResult));
        	  Reporter.log("PASS:Page is displayed",true);
          }
          catch (Exception e) {
			Reporter.log("FAIL:Page is not displayed",true);
			Assert.fail();
          }
	}
	
	public void VerifyText(WebElement e, String eText)
	{
		String aText=e.getText();
		System.out.println(aText);
		Assert.assertEquals(aText, eText);

	}
	
	public void CustoWaitAndClick(WebElement e)
	{
		while(true)
		{
			try
			{
				e.click();
				break;
			}
			catch (Exception e1) {
				// TODO: handle exception
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}

}
