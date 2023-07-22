package week4.week4day2assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Ordering;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch the driver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Go to Mens Fashion
		WebElement menFashion = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions action = new Actions(driver);
		action.moveToElement(menFashion).perform();
		
		//Go to Sports Shoes
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		//Get the count of the sports shoes
		String sportsShoesCount = driver.findElement(By.xpath("//h1[contains(text(),'Sports Shoes for Men')]/following-sibling::span")).getText();
		System.out.println("The count of sport shoes is :"+ sportsShoesCount);
		
		//Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//Sort by Low to High
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='arrow hidden']/parent::li")).click();
	
		//product list
		Thread.sleep(3000);
		List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println(productPrice.size());
		List<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<productPrice.size();i++)
		{
			String price = productPrice.get(i).getAttribute("data-price");
			int priceAmount = Integer.parseInt(price);
			list.add(priceAmount);
			System.out.println(price);
			Thread.sleep(2000);
		}
		
		//Check if the items displayed are sorted correctly
		if(Ordering.natural().isOrdered(list))
			System.out.println("The items are sorted and displayed from Low to High price");
		else
			System.out.println("The items are not sorted and displayed from Low to High price");
		
		//Select the price range (900-1200)
		driver.findElement(By.className("input-filter")).clear();
		driver.findElement(By.className("input-filter")).sendKeys("900");
		Thread.sleep(2000);
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys("1200");
		
		//Filter with color Navy 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Color_s-Black']")).click();
		
		//verify the all applied filters 
		String filterOption = driver.findElement(By.xpath("//a[text()='Black']")).getText();
		if(filterOption.contains("Black"))
			System.out.println("The filters are applied correctly");
		else
			System.out.println("The filters are not applied correctly");
		
		// Mouse Hover on first resulting Training shoes
		WebElement firstResult = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		action.moveToElement(firstResult).perform();
		
		// click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();
		Thread.sleep(2000);
		
		//Print the cost and the discount percentage
		String actualPrice = driver.findElement(By.xpath("//span[contains(@class, 'strikee')]")).getText();
		System.out.println("Actual cost : "+actualPrice );
		String discountedPercentage = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]")).getText();
		System.out.println("Discounted percentage : "+ discountedPercentage);
		String discountedPrice = driver.findElement(By.className("payBlkBig")).getText();
		System.out.println("Discounted cost : "+ discountedPrice);
		
		//Take the snapshot of the shoes.
        File source = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snapshots/Shoes.png");
        FileUtils.copyFile(source, dest);
        
        //Close all the windows
        Thread.sleep(2000);
        driver.quit();
	}
}
