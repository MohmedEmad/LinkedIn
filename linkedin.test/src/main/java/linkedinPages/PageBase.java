package linkedinPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Hello world!
 *
 */
public class PageBase 
{
    
	public static WebDriver Driver ;
	
	public static void Initialization()
    {
        /*
		String chromPath= System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
    	System.setProperty("webdriver.chrome.driver", chromPath);
    	Driver = new ChromeDriver(); 
    	*/
    	       
         /*   if you need to test on firefox */
        
    	String firfoxPath= System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
    	System.setProperty("webdriver.chrome.driver", firfoxPath);
    	Driver = new FirefoxDriver(); 
    	Driver.navigate().to("https://www.linkedin.com/");
      
        
    }
	 public static void uploadFile(String filepath) throws Exception {
		    Robot robot = new Robot();	
			StringSelection selection = new StringSelection(filepath);
			
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, null);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(2000);
			 
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		 
	 }
	
	
	
	
}
