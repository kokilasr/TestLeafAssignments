package week4.week4day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch the driver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		
		//Get the price of the first product
		String price = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println("First resulting product price : " + price);
		
		//Print the number of customer ratings for the first displayed product
		driver.findElement(By.xpath("//i[@class='a-icon a-icon-popover']")).click();
		String customerRatings = driver.findElement(By.xpath("//span[contains(@class,'a-text-beside-button')]")).getText();
		System.out.println("Customer Ratings for the first resulting product: "+ customerRatings);
		
		//Click the first text link of the first image
		driver.findElement(By.xpath("//div[contains(@class,'aok-relative')]/img")).click();
		
		//Window handles
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("The number of windows is: " + windowHandles.size());
		List<String> listOfWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfWindows.get(1));
		
		//Take a screen shot of the product displayed
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File productScreenshot = new File("./snapshots/amazonproduct.png");
		FileUtils.copyFile(screenshot, productScreenshot);
		
		//Click 'Add to Cart' button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Get the cart subtotal and verify if it is correct.
		Thread.sleep(3000);
		String cartSubTotal = driver.findElement(By.xpath("//b[text()='Cart subtotal']/following::span[2]")).getText();
		System.out.println("Cart Subtotal: "+cartSubTotal);
		
		if(cartSubTotal.contains(price))
			System.out.println("Cart Subtotal is correct");
		else
			System.out.println("Cart subtotal is incorrect");
		
		//Close the browser
		driver.quit();
	}
}
