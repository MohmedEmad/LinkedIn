package linkedinPages;

import java.security.AlgorithmConstraints;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{
	
	

	public static void goTo()
    {
		Driver.navigate().to("https://www.linkedin.com/");
    }	
		
	public static void enterDataOnRegistrationForm(String f_name, String l_name, String email, String password ) throws Exception {
		
		Driver.findElement(By.id("reg-firstname")).sendKeys(f_name);
		Driver.findElement(By.id("reg-lastname")).sendKeys(l_name);
		Driver.findElement(By.id("reg-email")).sendKeys(email);
		Driver.findElement(By.id("reg-password")).sendKeys(password);
		Driver.findElement(By.id("registration-submit")).click();
		Thread.sleep(1000);
		
	
	}

	public static void EnterSecurityData(String country, String tel) throws Exception {
	  
		WebElement myDynamicElement = (new WebDriverWait(Driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"captcha-dialog\"]/iframe")));
		Driver.switchTo().frame(Driver.findElement(By.xpath("//*[@id=\"captcha-dialog\"]/iframe")));
		Thread.sleep(2000);
		Driver.findElement(By.xpath("//*[@id=\"cp-challenge-form-page1\"]/fieldset/ul/li[1]/div/label[1]")).click();
		WebElement options= Driver.findElement(By.id("country-select"));
		Select selectOption= new Select(options);
		selectOption.selectByValue(country);
		Driver.findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys(tel);
	    Driver.findElement(By.id("submitPage1")).click();
	    Thread.sleep(1000);
	}
	   
		


	public static String getFinishRegisteringCodeMSG() throws Exception 
	{
		Thread.sleep(2000);
     return Driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/form/fieldset/h2")).getText();
	}

	public static String getErrorMessage_for_invaild_data() throws InterruptedException {
		Thread.sleep(1000);
		return Driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/div/p/span")).getText();
		
		
	}
	
   public static void closeSecurityVerificationForm() throws InterruptedException {
	  Thread.sleep(2000);
	   Driver.findElement(By.xpath("/html/body/div[2]/button/span")).click();
   }
	
	
	
public static void logInAs(String email, String password ) throws Exception {
		
		Driver.findElement(By.id("login-email")).sendKeys(email);
		Driver.findElement(By.id("login-password")).sendKeys(password);
		Driver.findElement(By.id("login-submit")).click();
			
	}






public static String getLoginErrorMSG() {
	return Driver.findElement(By.id("session_password-login-error")).getText();

}



public static String getValidationMessageLogIn() {
	// TODO Auto-generated method stub
	return null;
}

public static void 	openRest_password_Page() throws InterruptedException {
	  
	   Driver.findElement(By.linkText("Forgot password?")).click();
 }
	


}
