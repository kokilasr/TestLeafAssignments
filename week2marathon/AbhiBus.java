package week2marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AbhiBus {
public static void main(String[] args) throws InterruptedException {
	//Launch the Chrome Browser
			ChromeDriver driver = new ChromeDriver();

			//Launch the URL
			driver.get("https://www.abhibus.com/");

			//Maximize the window
			driver.manage().window().maximize();

			//Implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			//Click on Bus
			driver.findElement(By.linkText("Bus"));
//			Thread.sleep(5000);
			
			//Enter source and destination
			driver.findElement(By.id("source")).sendKeys("Chennai");
			driver.findElement(By.xpath("//li[text()='Chennai']")).click();
			driver.findElement(By.id("destination")).sendKeys("Bangalore");
			driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
			
			//Select date
			driver.findElement(By.id("datepicker1")).click();
			driver.findElement(By.xpath(" //td[contains(@class, 'ui-datepicker-today')]/following::a")).click();
			
			//Click on Search
			driver.findElement(By.xpath("//a[text()='Search']")).click();
			Thread.sleep(5000);
			
			//Print first resulting bus
			System.out.println("The first resulting bus is "+ driver.findElement(By.xpath("//h2[@title='Yolo Bus']")).getText());
			
			//Select Sleeper class
			driver.findElement(By.id("Bustypes4")).click();
			
			//Print number of available seats
			System.out.println("The number of seats available is "+ driver.findElement(By.xpath("//p[text()='15 Seats Available']")).getText());;
			
			//Click on select seat
			driver.findElement(By.xpath("(//a[@class='btn-seatselect book1']/span)[2]")).click();
			
			//Choose the available seat
			driver.findElement(By.xpath("//a[@class='tooltip tooltipstered']")).click();
			
			//Print the seat number and total fare
			System.out.println("Selected Seat is "+ driver.findElement(By.xpath("//p[text()='Seats Selected ']/following::span")).getText());
			System.out.println("Total fare is "+ driver.findElement(By.xpath("//span[@id='ticketfare']")).getText());

			//Select Boarding point
			WebElement boarding = driver.findElement(By.id("boardingpoint_id"));
			Select selBoarding = new Select(boarding);
			selBoarding.selectByIndex(2);
			
			//Select Dropping point
			WebElement dropPoint = driver.findElement(By.id("droppingpoint_id"));
			Select selDropPoint = new Select(dropPoint);
			selDropPoint.selectByIndex(2);

			//Get the title of the page
			System.out.println("The title of the page is" + driver.getTitle());
			
			//Close the browser
			driver.close();
}
}
