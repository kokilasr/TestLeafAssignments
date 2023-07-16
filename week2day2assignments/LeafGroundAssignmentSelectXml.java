package week2.week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafGroundAssignmentSelectXml {
public static void main(String[] args) throws InterruptedException {
	//Launch the driver
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/select.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Which is your favorite UI Automation tool?
	WebElement toolList = driver.findElement(By.className("ui-selectonemenu"));
	Select selectTool = new Select(toolList);
	selectTool.selectByIndex(1);
	
	//Choose your preferred country.
	driver.findElement(By.xpath("//label[text()='Select Country']")).click();
	driver.findElement(By.xpath("//li[text()='Germany']")).click();
	
	//Confirm Cities belongs to Country is loaded
	Thread.sleep(5000);
	driver.findElement(By.xpath("//label[text()='Select City']")).click();
	driver.findElement(By.xpath("//li[text()='Berlin']")).click();
	String city = driver.findElement(By.xpath("//li[text()='Berlin']")).getText();
	if(city.contains("Berlin"))
			System.out.println("Cities belong to country");
	else
		System.out.println("City does not belong to country");
	
	//Choose the Course
	driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::button")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[text()='Appium']")).click();
	
	//Choose language randomly
	driver.findElement(By.xpath("//label[text()='Select Language']/following-sibling::div")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//li[text()='Tamil']")).click();
	
	//Select 'Two' irrespective of the language chosen
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[text()='Select Values']/following::span")).click();
	driver.findElement(By.xpath("//ul[@id='j_idt87:value_items']//li[2]")).click();
}
}
