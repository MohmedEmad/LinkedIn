package linkedinTestCases;

import java.sql.Driver;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import linkedinPages.PageBase;
public class TestBase {
	
	@BeforeTest
	 public void Open_the_web_page()
    {
        PageBase.Initialization();
    }
	
	
	// take screenshot when test case fail and add it in the Screenshot folder
		@AfterTest
		public void Close_the_Site() 
		{
			
			PageBase.Driver.quit();
		}

}
