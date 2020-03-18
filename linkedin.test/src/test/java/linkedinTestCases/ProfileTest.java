package linkedinTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import data.ExcelReader;
import linkedinPages.HomePage;
import linkedinPages.LinkedInFeedPage;
import linkedinPages.ProfilePage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Driver;

import org.testng.annotations.DataProvider;

public class ProfileTest  extends TestBase{
		
	 @DataProvider
	  public Object[][] loginData() throws IOException {
		  Object[][] testObjArray = ExcelReader.getExcelData(3,2);
		  return (testObjArray);
	  }
	  	
	@Test(dataProvider = "loginData", priority = 1)
      public void login_with_valid_data(String  email, String pass) throws Exception {
	  HomePage.goTo();
	  HomePage.logInAs(email, pass);
	  AssertJUnit.assertEquals(LinkedInFeedPage.homeIconeIsDisplayed(), true);}
  
	
	
	@Test(dataProvider = "WorkExperience_Data", priority = 2)
  public void Verfiy_User_can_add_work_experience(String title, String company, String  location, String month, String year, String filename) throws Exception {
	  	    
    LinkedInFeedPage.OpenProfilePage();
    ProfilePage.add_Work_experience(title,company, location, month, year, filename);
    assertEquals(ProfilePage.titleIsDispalyed(title), true);
    assertEquals(ProfilePage.companyNameIsDispalyed(company), true);
    assertEquals(ProfilePage.companyLocationIsDispalyed(location), true);
  }

 
@DataProvider
public Object[][] WorkExperience_Data() throws IOException {	 
Object[][] testObjArray = ExcelReader.getExcelData(5,6);
	  return (testObjArray); }
}



