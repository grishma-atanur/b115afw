package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class DemoTest extends BaseTest
{

	@Test
	public void testDemo()
	{
		String title=driver.getTitle();
		Reporter.log(title,true);
	}
}
