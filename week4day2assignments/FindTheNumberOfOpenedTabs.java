package week4.week4day2assignments;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTheNumberOfOpenedTabs {
public static void main(String[] args) {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/window.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Click on button
	driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
	
	//Window handles
	Set<String> windowHandles = driver.getWindowHandles();
	
	//Find the number of windows opened
	System.out.println("Number of windows opened is "+ windowHandles.size());
	
	//Close all the windows
	driver.quit();
	
}
}
