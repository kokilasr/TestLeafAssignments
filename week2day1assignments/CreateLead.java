package week2.week2day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class CreateLead {
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
}
}