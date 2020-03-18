package linkedinTestCases;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.annotations.*;

import data.ExcelReader;
import linkedinPages.HomePage;


public class RegistrationTest extends TestBase {
  
	
	@DataProvider
	public Object[][] userRegisterData() throws IOException
	{
		// get data from Excel Reader class 
		Object[][] testObjArray = ExcelReader.getExcelData(0,6);
		  return (testObjArray);
		
	}

	@Test(dataProvider="userRegisterData")
	public void UserCanRegisterSuccssfully(String f_name, String l_name, String email, String password, String Country, String Tel) throws Exception 
	{
		HomePage.goTo();
		HomePage.enterDataOnRegistrationForm(f_name,l_name,email,password);
		HomePage.EnterSecurityData(Country, Tel);
		assertEquals(HomePage.getFinishRegisteringCodeMSG(), "To finish registering, please enter the verification code we gave you.\n" + 
				"It might take a few minutes to receive your code.");
	
     
		
	}
	/*another ways for Data driven */
	@DataProvider
	public Object[][] RegisterWithInvalidData() throws IOException
	{
		
		return new Object[][] { { "", "user1", "Test@123.com","sd4e7rr4d1","Please enter your first name" }
		,{  "user1","", "Test@123.com","sd4e7rr4d1","Please enter your last name" }
		,{  "user1","test", "","sd4e7rr4d1","Please enter your email address" }
		,{  "user1","test", "Test@123.com","","Please enter your password" }};
		
		
	}
	

	@Test(dataProvider="RegisterWithInvalidData")
     public void Check_mandatory_fields(String f_name, String l_name, String email, String password , String error_MSG) throws Exception {
		HomePage.goTo();
		HomePage.enterDataOnRegistrationForm(f_name,l_name,email,password);
	    assertEquals(HomePage.getErrorMessage_for_invaild_data(),error_MSG);
	}
	
	@DataProvider
	public Object[][] userRegisterWithInvalidEmail() throws IOException
	{
		Object[][] testObjArray = ExcelReader.getExcelData(1,1);
		  return (testObjArray);
		
	}
	

	@Test(dataProvider="userRegisterWithInvalidEmail")
	  public void Check_for_invalid_emails(String email) throws Exception {
		HomePage.goTo();
		HomePage.enterDataOnRegistrationForm("test","user",email,"1111");
	    assertEquals(HomePage.getErrorMessage_for_invaild_data(),"Please enter a valid email address");
	}
	
	@DataProvider
	public Object[][] userRegisterWithInvalidPassword() throws IOException
	{
		Object[][] testObjArray = ExcelReader.getExcelData(2,2);
		  return (testObjArray);
		
	}
	

	@Test(dataProvider="userRegisterWithInvalidPassword")
	  public void Check_for_invalid_password(String pass, String error) throws Exception {
		HomePage.goTo();
		HomePage.enterDataOnRegistrationForm("test","user","m.@gmail.com",pass);
	    assertEquals(HomePage.getErrorMessage_for_invaild_data(),error);
	}
		
		

	     
		}
 



