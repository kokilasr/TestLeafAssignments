package week2.week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGroundAssignmentCheckbox {
public static void main(String[] args) throws InterruptedException {
	
	//Launch the browser
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/checkbox.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Basic Checkbox
	driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[1]")).click();

	//Notification
	driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
	String notificationText = driver.findElement(By.className("ui-growl-title")).getText();
	if (notificationText.contains("Checked"))
		System.out.println("Notification displayed");
	else
		System.out.println("Notification is not displayed");
	
	//Choose your favorite languages
	Thread.sleep(5000);
	driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div[1]")).click();
	driver.findElement(By.xpath("//label[text()='Python']/preceding-sibling::div[1]")).click();

	//Tri state checkbox
	//First state
	Thread.sleep(5000);
	driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[3]")).click();
	String firstClick = driver.findElement(By.xpath("//p[text()='State = 1']")).getText();
	if (firstClick.contains("1"))
		System.out.println("First state has been changed");
	else
		System.out.println("First state has not been changed");
	
	//Second State
	Thread.sleep(5000);
	driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[3]")).click();
	String secondClick = driver.findElement(By.xpath("//p[text()='State = 2']")).getText();
	if (secondClick.contains("2"))
		System.out.println("Second state has been changed");
	else
		System.out.println("Second state has not been changed");
	
	//Third State
	Thread.sleep(5000);
	driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[3]")).click();
	String thirdClick = driver.findElement(By.xpath("//p[text()='State = 0']")).getText();
	if (thirdClick.contains("0"))
		System.out.println("Third state has been changed");
	else
		System.out.println("Third state has not been changed");
	
	//Toggle switch
	driver.findElement(By.xpath("//h5[text()='Toggle Switch']/following::div[3]")).click();
	
	//Verify if check box is disabled
	boolean checkBoxEnabled = driver.findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div[1]")).isSelected();
	if(checkBoxEnabled)
		System.out.println("Checkbox is enabled");
	else
		System.out.println("Checkbox is disabled");
	
	//Select Multiple
	driver.findElement(By.xpath("//div[contains(@class,'ui-selectcheckboxmenu-trigger')]")).click();
	driver.findElement(By.xpath("//label[text()='Miami']/preceding-sibling::div")).click();
	driver.findElement(By.xpath("//label[text()='London']/preceding-sibling::div")).click();
}
}
