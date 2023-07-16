package week2.week2day2assignments;

import java.time.Duration;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class LeafGroundAssigmentRadoXml {
public static void main(String[] args) throws InterruptedException {
	//Launch the driver
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/radio.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Your most favorite browser
	driver.findElement(By.xpath("//label[text()='Chrome']/preceding::div[1]")).click();

	//Unselectable
	driver.findElement(By.xpath("//label[text()='Chennai']/preceding::div[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[text()='Chennai']/preceding::div[1]")).click();

	//Find the default select radio button
	String text = driver.findElement(By.xpath("(//label[text()='Safari'])[2]")).getText();
	System.out.println("The default selected radio button is "+ text);
	
	//Select the age group (only if not selected)
	boolean selected = driver.findElement(By.xpath("//label[text()='1-20 Years']")).isSelected();
	if(!selected)
	{
		System.out.println("Age group is not selected and hence selected now");
		driver.findElement(By.xpath("//label[text()='1-20 Years']")).click();	
	}	
}
}
