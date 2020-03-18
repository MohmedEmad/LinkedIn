package linkedinTestCases;

import org.testng.annotations.Test;

import data.ExcelReader;
import linkedinPages.*;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ForgotPasswordTest extends TestBase {
	@Test
	public void Verfiy_the_user_can_open_forgetpassPage() throws Exception {
		  HomePage.goTo();
		  HomePage.openRest_password_Page();
		  assertEquals(ForgotPasswordPage.getPageTitel(), "Reset Password | LinkedIn");
		 		  	  
	  } 
	
	@DataProvider
	  public Object[][] emailList() throws IOException {
		 Object[][] testObjArray = ExcelReader.getExcelData(3,2);
		  return (testObjArray);
	  }
  
	@Test(dataProvider = "emailList")
     public void Verfiy_the_system_keep_the_email( String email ,String Pass) throws Exception {
	  HomePage.goTo();
	  HomePage.logInAs(email, "");
	  HomePage.openRest_password_Page();
	  assertEquals(ForgotPasswordPage.getPageTitel(), "Reset Password | LinkedIn");
	  assertEquals(ForgotPasswordPage.getEmail(), email);
	  	  
  }
	
	  
	  @Test(dataProvider = "emailList")
	public void Verfiy_the_system_send_email_For_user(String email, String Pass) throws Exception {
		  HomePage.goTo();
		  HomePage.openRest_password_Page();
		  assertEquals(ForgotPasswordPage.getPageTitel(), "Reset Password | LinkedIn");
		  ForgotPasswordPage.add_data(email);
		  assertEquals(ForgotPasswordPage.getConfirmationMSG(), "Please check your email and click the secure link.");
		 		  	  
	  } 
	  @DataProvider
	  public Object[][] InvalidData() {
	    return new Object[][] {
	      new Object[] {"" } , 
	      new Object[] {"mai.gmail.com" } , 
	      	      	    };
	  }
	  
	  @Test(dataProvider = "InvalidData")
		public void Verfiy_the_system_display_MSG_For_invalid(String data) throws Exception {
			  HomePage.goTo();
			  HomePage.openRest_password_Page();
			  assertEquals(ForgotPasswordPage.getPageTitel(), "Reset Password | LinkedIn");
			  ForgotPasswordPage.add_data(data);
			  assertEquals(ForgotPasswordPage.getErrorMSG(), "Please enter your email or phone");
			 		  	  
		  } 
	 

  
}
