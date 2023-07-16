package week2.week2day2assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {
public static void main(String[] args) {
	//Launch the Chrome Browser
	ChromeDriver driver = new ChromeDriver();
	
	//Launch the URL
	driver.get("https://en-gb.facebook.com/");
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//Add implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Find the webelements
	driver.findElement(By.partialLinkText("Create new")).click();
	driver.findElement(By.name("firstname")).sendKeys("Kokila");
	driver.findElement(By.name("lastname")).sendKeys("Shree");
	driver.findElement(By.name("reg_email__")).sendKeys("123457890");
	driver.findElement(By.id("password_step_input")).sendKeys("koki@123");
	//Handling day dropdown
	WebElement dayDropDown = driver.findElement(By.id("day"));
	Select selectDay= new Select(dayDropDown);
	selectDay.selectByIndex(2);
	
	//Handling month dropdown
	WebElement monthDropDown = driver.findElement(By.id("month"));
	Select selectMonth= new Select(monthDropDown);
	selectMonth.selectByValue("1");
	
	//Handling year dropdown
	WebElement yearDropDown = driver.findElement(By.id("year"));
	Select selectYear= new Select(yearDropDown);
	selectYear.selectByVisibleText("1982");
	
	driver.findElement(By.xpath("//label[text() = 'Female']")).click();
	
	
}
}
