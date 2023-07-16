package week2.week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcmeTest {
public static void main(String[] args) {
	//Launch Chrome browser
	ChromeDriver driver = new ChromeDriver();
	
	//Launch the URL
	driver.get("https://acme-test.uipath.com/login");
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//Implicit wait for the page to findelement
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Find the webelments and pass the values
	driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
	driver.findElement(By.id("password")).sendKeys("leaf@12");
	driver.findElement(By.xpath("//button[contains(text(), 'Login')]")).click();
	String title = driver.getTitle();
	System.out.println("The title of the page is "+ title);
	driver.findElement(By.partialLinkText("Log")).click();
	driver.close();
}
}
