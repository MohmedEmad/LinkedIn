package linkedinPages;

import org.openqa.selenium.By;

public class LinkedInFeedPage extends PageBase
{
	public static boolean homeIconeIsDisplayed() throws InterruptedException
	{
	    Thread.sleep(3000);
		return Driver.findElement(By.xpath("//*[@id=\"feed-tab-icon\"]")).isDisplayed();
	}

	public static void logout() throws Exception {
		
		Driver.findElement(By.id("nav-settings__dropdown-trigger")).click();
		Thread.sleep(1000);
		Driver.findElement(By.linkText("Sign out")).click();;

	}
	
	public static void OpenProfilePage() throws Exception {
		
		Driver.findElement(By.id("nav-settings__dropdown-trigger")).click();
		Thread.sleep(2000);
		Driver.findElement(By.xpath("/html/body/nav/div/ul[1]/li[6]/div/ul/li[1]/a/div[2]/span")).click();
}
}