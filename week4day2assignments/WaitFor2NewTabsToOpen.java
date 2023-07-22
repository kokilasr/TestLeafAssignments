package week4.week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitFor2NewTabsToOpen {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/window.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//inspect the element
	driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
	
	//Window handles and number of windows
	Set<String> windowHandles = driver.getWindowHandles();
	int numberOfWindows = windowHandles.size();
	System.out.println("Number of windows is "+ numberOfWindows);
	
	//Convert set to list
	List<String> window = new ArrayList<String>(windowHandles);
	for(int i=0; i<numberOfWindows;i++)
	{
		driver.switchTo().window(window.get(i));
		System.out.println("Window title is "+ driver.getTitle());
	}
	
	
	
	
}
}
