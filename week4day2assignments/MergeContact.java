package week4.week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {
public static void main(String[] args) throws InterruptedException {
	
	//Lunch the driver
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Enter UserName and Password Using Id Locator
	driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	
	
	//Click on Login Button using Class Locator
	driver.findElement(By.className("decorativeSubmit")).click();
	
	//CRM/SFA Link
	driver.findElement(By.partialLinkText("CRM")).click();
	
	//Click on contacts Button
	driver.findElement(By.linkText("Contacts")).click();

	//Click on Merge Contacts using Xpath Locator
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	
	//Click on Widget of From Contact
	driver.findElement(By.xpath("//input[@name = 'partyIdFrom']/following::img")).click();
	
	//Window handle
	Set<String> windowHandlesFrom = driver.getWindowHandles();
	System.out.println("The number of windows is:" +windowHandlesFrom.size() );
	
	//Convert set to list
	List<String> windowsListFrom = new ArrayList<String>(windowHandlesFrom);
	driver.switchTo().window(windowsListFrom.get(1));
	
	//Click on First Resulting Contact
	driver.findElement(By.linkText("10165")).click();
	
	//Click on Widget of To Contact
	driver.switchTo().window(windowsListFrom.get(0));
	driver.findElement(By.xpath("//input[@name = 'partyIdFrom']/following::img[2]")).click();
	
	//Window handle
	Set<String> windowHandlesTo = driver.getWindowHandles();
	System.out.println("The number of windows is:" +windowHandlesTo.size() );
	
	//Convert set to list
	List<String> windowsListTo = new ArrayList<String>(windowHandlesTo);
	driver.switchTo().window(windowsListTo.get(1));
	
	//Click on Second Resulting Contact
	driver.findElement(By.linkText("10165")).click();
	
	//Switch window to parent window
	driver.switchTo().window(windowsListTo.get(0));
	
	//Click on Merge button using Xpath Locator
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	
	//Accept the alert
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	//Switch to parent window and verify the title of the page
	String parentWindow = driver.getWindowHandle();
	driver.switchTo().window(parentWindow);
	String title = driver.getTitle();
	System.out.println("The title of the page is :" + title);
	if(title.contains("Merge Contacts"))
		System.out.println("The title of the page is correct");
	else
		System.out.println("The tile of the page is incorrect");
	
}
}
