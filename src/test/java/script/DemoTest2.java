package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class DemoTest2 extends BaseTest
{

	@Test
	public void testDemo2()
	{
		String title=driver.getTitle();
		Reporter.log(title,true);
	}
}
