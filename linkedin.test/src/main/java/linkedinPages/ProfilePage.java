package linkedinPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;		
import java.util.Set;	
public class ProfilePage extends PageBase {

	public static void add_Work_experience(String title, String company, String  location, String month, String year, String filename) throws InterruptedException, Exception {
		 Thread.sleep(5000);
	        		 		 
	  Driver.findElement(By.xpath("//span[contains(text(),'Add profile section')]")).click();
		   Driver.findElement(By.xpath("//ul[@id='background-panel']//h2[contains(text(),'Work experience')]")).click();
		Thread.sleep(5000);
		   Driver.findElement(By.id("position-title-typeahead")).sendKeys(title);
		   Driver.findElement(By.id("position-company-typeahead")).sendKeys(company);
		   Driver.findElement(By.id("position-location-typeahead")).sendKeys(location);
		   WebElement months= Driver.findElement(By.id("position-start-month"));
			Select selectMonth= new Select(months);
			//selectMonth.selectByValue(month);
			selectMonth.selectByIndex(4);
			WebElement years= Driver.findElement(By.id("position-start-year"));
			Select selectYears= new Select(years);
		selectYears.selectByIndex(2);
			//selectYears.selectByValue(year);
			 Driver.findElement(By.id("position-headline")).sendKeys("test hinde line");
// upload image
				String imageName = filename;
				String imagePath = System.getProperty("user.dir")+"\\Uploads\\"+imageName;
				WebElement fileUploader = Driver.findElement(By.xpath("//div[@class='pe-treasury-view__actions display-flex justify-space-between']//label")); 
				fileUploader.click();
				PageBase.uploadFile(imagePath);
   			   WebElement apply = Driver.findElement(By.xpath("//div[@class='pe-form-footer__actions pe-form-footer__actions--treasury-edit']//div//button[@data-control-name='apply']")); 
				apply.click();
				WebElement uploadedFiles = Driver.findElement(By.xpath("//button[@data-control-name='edit_treasury']")); 
				Thread.sleep(3000);
				System.out.println(uploadedFiles.getText());
				Assert.assertEquals(uploadedFiles.getText().contains(imageName),true );
				Driver.findElement(By.xpath("//div[@class='pe-form-footer__actions']//button[@type='submit']")).click();
	           Thread.sleep(5000);
	         
				
	}
	
	public static boolean companyNameIsDispalyed(String company) {
		return Driver.findElement(By.xpath("//div[@class='pv-entity__summary-info']//h4[@class='Sans-17px-black-85%']//span[@class='pv-entity__secondary-title'][contains(text(),'"+company+"')]")).isDisplayed();
	}
		  
	public static boolean companyLocationIsDispalyed(String location) {
		return Driver.findElement(By.xpath("//div[@class='pv-entity__summary-info']//h4[@class='pv-entity__location Sans-15px-black-70% block']//span[contains(text(),'"+location+"')]")).isDisplayed();
	}
	public static boolean titleIsDispalyed(String title) {
		return Driver.findElement(By.xpath("//h3[@class='Sans-17px-black-85%-semibold'][contains(text(),'"+title+"')]")).isDisplayed();
	}
	
}
