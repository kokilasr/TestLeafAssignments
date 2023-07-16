package week2.week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
public static void main(String[] args) throws InterruptedException {
	//Launch the Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		
		//Launch the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Find the webelements
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Kokila");
		driver.findElement(By.id("lastNameField")).sendKeys("Rajendran");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Koki");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Raje");
		driver.findElement(By.name("departmentName")).sendKeys("QA");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("This is description");
		driver.findElement(By.id("createContactForm_primaryEmail"));
		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select selState = new Select(state);
		selState.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.linkText("Edit")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("This is an important note");
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		System.out.println("The title of the resulting page is "+ driver.getTitle());

}
}
