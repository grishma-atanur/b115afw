package generic;

import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * BaseTest class
 */
public class BaseTest {
	
	public WebDriver driver;
	public WebDriverWait wait;
	public final String configPath="config.properties";
	public final String xlpath="./data/input.xlsx";
	@Parameters({"property"})
	@BeforeMethod
	public void preCondition(@Optional(configPath) String property) throws Exception
	{
		Reporter.log("Read properties from:"+property,true);
		String grid = Utility.getProperty(property, "GRID");
		String gURL = Utility.getProperty(property, "GURL");
		String browser = Utility.getProperty(property, "BROWSER");
		String app_url = Utility.getProperty(property, "APPURL");
		String ITO = Utility.getProperty(property, "ITO");
		String ETO = Utility.getProperty(property, "ETO");
		
		if(grid.equalsIgnoreCase("yes"))
		{
			if(browser.equals("chrome"))
			{
				Reporter.log("Open Chrome Browser in Remote System",true);
				driver=new RemoteWebDriver(new URL(gURL),new ChromeOptions());
			}
			else
			{
				Reporter.log("Open Edge Browser in Remote System",true);
				driver=new RemoteWebDriver(new URL(gURL),new EdgeOptions());;
			}
		}
		else
		{
			if(browser.equals("chrome"))
			{
				Reporter.log("Open Chrome Browser in Local System",true);
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Open Edge Browser in Local System",true);
				driver=new EdgeDriver();
			}
		}
		
		
		Reporter.log("Enter the URL:"+app_url,true);
		driver.get(app_url);
		
		Reporter.log("Maximize the browser",true);
		driver.manage().window().maximize();
		
		Reporter.log("Set ITO:"+ITO,true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ITO)));
		
		Reporter.log("Set ETO:"+ETO,true);
		wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ETO)));
	}
	
	@AfterMethod
	public void postCondition()
	{
		Reporter.log("Close the browser",true);
		driver.quit();
	}
}
