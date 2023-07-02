package week2.day1assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DuplicateLead {
	public static void main(String[] args) {

		//Launch the Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		//Launch the url
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximize the window
		driver.manage().window().maximize();

		//Find the webelements in the page.
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Create Lead")).click();

		//Enter the details
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kokila");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Rajendran");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Kokila");
		driver.findElement(By.name("departmentName")).sendKeys("Quality Analyst");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Kokila is from QA department");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("kokila@gmail.com");

		//Select New York from State/Province list
		WebElement stateList = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selState = new Select(stateList);
		selState.selectByVisibleText("New York");

		//Create lead
		driver.findElement(By.name("submitButton")).click();

		//Get the title of the page
		String title = driver.getTitle();
		System.out.println("The title of the page is "+ title);

		//Duplicate the lead to enter correct details
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("New Company Name");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Kokila Shree");
		driver.findElement(By.className("smallSubmit")).click();

		//Get the title of the new page
		String newTitle = driver.getTitle();
		System.out.println("The title of the page is "+ newTitle);	
		
		driver.close();
	}
}
