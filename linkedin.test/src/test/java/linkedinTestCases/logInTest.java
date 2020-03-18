package linkedinTestCases;

import org.testng.annotations.Test;

import data.ExcelReader;
import linkedinPages.*;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class logInTest extends TestBase{
	 @DataProvider
	  public Object[][] loginData() throws IOException {
		  Object[][] testObjArray = ExcelReader.getExcelData(3,2);
		  return (testObjArray);
	  }
	  	
	@Test(dataProvider = "loginData", priority = 1)
  public void login_with_valid_data(String  email, String pass) throws Exception {
	  HomePage.goTo();
	  HomePage.logInAs(email, pass);
	  assertEquals(LinkedInFeedPage.homeIconeIsDisplayed(), true);
	  LinkedInFeedPage.logout();
  }
	
	 @DataProvider
	  public Object[][] loginInvalidData() throws IOException {
		  Object[][] testObjArray = ExcelReader.getExcelData(4,2);
		  return (testObjArray);
	  }
		
	@Test(dataProvider = "loginInvalidData")
	public void  login_with_invalid_data(String email, String Pass) throws Exception {
		  HomePage.goTo();
		  HomePage.logInAs(email,Pass);
		  assertEquals(HomePage.getLoginErrorMSG(),("Hmm, that's not the right password. Please try again or request a new one."));
		
	}
	
	@Test
	public void  Check_for_mandatory_fields() throws Exception {
		  HomePage.goTo();
		  HomePage.logInAs("","");
		  assertEquals(HomePage.getValidationMessageLogIn(),"Please enter a valid email address");
	     
	}

 
}
