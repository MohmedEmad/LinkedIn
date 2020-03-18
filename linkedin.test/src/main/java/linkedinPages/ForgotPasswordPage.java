package linkedinPages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends PageBase{
	public static String getPageTitel() throws Exception {
		Thread.sleep(1000);
		return Driver.getTitle();
	}

	public static String getEmail() {
		// TODO Auto-generated method stub
		return Driver.findElement(By.id("username")).getText()	;}

	public static void add_data(String email) throws InterruptedException {
		Thread.sleep(1000);
		Driver.findElement(By.id("username")).sendKeys(email);
		Driver.findElement(By.id("reset-password-submit-button")).click();
		Thread.sleep(2000);
	}

	
	public static String getConfirmationMSG() {
		
		 return Driver.findElement(By.xpath("/html/body/div/div[2]/main/form/h2")).getText();
		
	}

	public static String getErrorMSG() {
		return Driver.findElement(By.id("user-name-error")).getText();
	}
}
