package week4.week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAllWindowsExceptPrimary {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/window.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	//click on the button
	driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
	
	
	//Get parent window handle
	String parentWindow = driver.getWindowHandle();
	System.out.println("Parent window handle : "+ parentWindow);
	
	//Get all window handles and get the size
	Set<String> windowHandles = driver.getWindowHandles();
	int numberOfWindows = windowHandles.size();
	System.out.println("Number of windows "+ numberOfWindows);
	
	//Convert set to list
	List<String> listOfWindows = new ArrayList<String>(windowHandles);
	
	for (String each : listOfWindows) 
	{
		if(!each.equals(parentWindow))
		{
			driver.switchTo().window(each);
			driver.close();
		}		
	}
	
	//Verify whether primary window is not closed
	driver.switchTo().window(parentWindow);
	if (!parentWindow.isEmpty())
		System.out.println("Primary window is not closed");
	else
		System.out.println("Primary window is closed");
	
}
}
