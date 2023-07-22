package week4.week4day2assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		//Launch the driver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		//Mouseover on Brands and Search L'Oreal Paris
		//Find webelement Brand
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		//brand.click();
		
		//Instantiate Actions to mousehover on Brands
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(brand).perform();
		Thread.sleep(5000);
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(text(),'Oreal Paris')]")).click();
		
		//Check the title
		String title = driver.getTitle();
		System.out.println("The title of the page is "+ title);
		if(title.contains("L'Oreal Paris"))
			System.out.println("The title of the page is correct");
		else
			System.out.println("The title of the page is incorrect");
	
		//Click sort By and select customer top rated
		driver.findElement(By.className("sort-name")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();
		
		//Click Category and click Hair->Click haircare->Shampoo
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='filter-name ']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[1]")).click();
		
		//Click->Concern->Color Protection
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div")).click();
		
		//check whether the Filter is applied with Shampoo
		String filterText = driver.findElement(By.xpath("//span[text()='Filters Applied']/following::span")).getText();
		if(filterText.contains("Shampoo"))
			System.out.println("Filter is applied by Shampoo");
		else
			System.out.println("Filter is not applied by Shampoo");
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'Shampoo')]")).click();
		
		//Window handles and navigate to new window
		Set<String> windowHandles = driver.getWindowHandles();
		int numberOfWindows = windowHandles.size();
		System.out.println("The number of windows is "+ numberOfWindows);
		List<String> listOfWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfWindows.get(1));
		
		//GO to the new window and select size as 175ml
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		
		//Print the MRP of the product
		String mrpValue = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("The MRP value is:"+mrpValue );
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		
		//Go to Shopping Bag 
		driver.findElement(By.xpath("//button[@class='css-aesrxy']")).click();
		
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		//String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[contains(text(),'279')]")).getText();
		//String grandTotal = driver.findElement(By.xpath("//span[contains(text(),'279')]")).getText();
		String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[contains(text(),'79')]")).getText();
		System.out.println("Grand total is:"+ grandTotal);
		
		//Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		Thread.sleep(2000);
		
		//Close the pop-up window
		driver.findElement(By.xpath("//p[text()='New Address']/preceding::span[@class='css-175whwo ehes2bo0']")).click();
		
		//Check if this grand total is the same in step 14
		String total = driver.findElement(By.xpath("//p[text()='Price Details']/following::p")).getText();
		if (total.equals(grandTotal))
				System.out.println("Grand total is same");
		else
			System.out.println("Grand total is different");
		
		//close all windows
		driver.quit();
	}
}
