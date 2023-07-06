package week2marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PVRCinemas {
	public static void main(String[] args) throws InterruptedException {
	
	//Launch the Chrome Browser
	ChromeDriver driver = new ChromeDriver();

	//Launch the URL
	driver.get("https://www.pvrcinemas.com/");

	//Maximize the window
	driver.manage().window().maximize();

	//Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Find the webelements
		
	//Click on Movie library
	driver.findElement(By.xpath("//div[text()='Movie Library ']")).click();
	
	//Select City
	WebElement selCity = driver.findElement(By.name("city"));
	Select city = new Select(selCity);
	city.selectByVisibleText("Chennai");
	
	//Select Genre
	WebElement selGenre = driver.findElement(By.name("genre"));
	Select genre = new Select(selGenre);
	genre.selectByVisibleText("ANIMATION");
	
	//Select English language
	WebElement selLang = driver.findElement(By.name("lang"));
	Select lang = new Select(selLang);
	lang.selectByVisibleText("ENGLISH");
	
	//Click on apply
	driver.findElement(By.xpath("//button[text()='Apply']")).click();
	
	//Click on first animation movie
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[text()='Paw Patrol']")).click();
	
	//Click on proceed to book
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[text()='Proceed To Book']")).click();
	Thread.sleep(5000);
	
	//select cinema
	WebElement selCinema = driver.findElement(By.id("cinemaName"));
	Select cinema = new Select(selCinema);
	cinema.selectByIndex(1);
	
	//Select showtime
	WebElement selShowTime = driver.findElement(By.name("timings"));
	Select showTime = new Select(selShowTime);
	showTime.selectByValue("03:00 PM - 06:00 PM");
	
	//enter number of tickets, name, email and mobile
	driver.findElement(By.name("noOfTickets")).sendKeys("2");
	driver.findElement(By.name("name")).sendKeys("Kokila");
	driver.findElement(By.name("email")).sendKeys("Kokila@testleaf.com");
	driver.findElement(By.name("mobile")).sendKeys("7889525258");
	
	//Food and beverage selection
	WebElement selFood = driver.findElement(By.name("food"));
	Select food = new Select(selFood);
	food.selectByVisibleText("Yes");
	
	//Enter comments, Click on Copy to self and Send request
	driver.findElement(By.name("comment")).sendKeys("test");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@class='custom-control custom-radio']")).click();
	driver.findElement(By.xpath("//button[text()='SEND REQUEST']")).click();
	
	//Click on Cancel
	driver.findElement(By.xpath("(//button[@class='btn already-member'])[4]")).click();
	
	//Close the pop-up
	driver.findElement(By.xpath("//button[text()='×']")).click();
	
	//Print the ttile of the page
	System.out.println("The title of the page is "+ driver.getTitle());
	
	//Close the browser
	driver.close();
	}
}
