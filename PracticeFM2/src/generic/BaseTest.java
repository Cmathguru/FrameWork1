package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConst{
public  WebDriver driver;
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}
		
		@BeforeMethod
		
		public void OpenAppplication()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			String url = AutoUtil.getProperty(CONFIG_PATH, "appurl");
			driver.get(url);
			
			String sITO = AutoUtil.getProperty(CONFIG_PATH, "ITO");
			
			long ITO=Long.parseLong(sITO);
			
			driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
			
		}
		
		@AfterMethod
		
		public void closeApplcation(ITestResult r)
		{
			String testName=r.getName();
		
			int status = r.getStatus();
			
			if(status==2)
			{
				AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
			}
			driver.quit();
		}

}
