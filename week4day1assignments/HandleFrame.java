package week4.week4day1assignments;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleFrame {
	public static void main(String[] args) throws InterruptedException {

		//Launch the driver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://buythevalue.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);

		//Find the first element and click
		driver.findElement(By.xpath("//div[@class='hxt-spm-clickable']")).click();
		driver.findElement(By.partialLinkText("URBAN FIT X SMART WATCH")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='hxt-spm-clickable']")).click();

		//Switch to frame1
		driver.switchTo().frame("dummy-chat-button-iframe");
		driver.findElement(By.id("dummy-chat-button")).click();

		//Switch to frame2
		driver.switchTo().frame("ShopifyChat");
		driver.findElement(By.xpath("//button[contains(@class,'chat-app--close-button')]")).click();

		//Switch the controller to main page
		driver.switchTo().defaultContent();

		//Enter zip code and click on Check button
		driver.findElement(By.name("wk_zipcode")).sendKeys("600106");
		driver.findElement(By.xpath("//div[@class='wk_zipfinder_btn']/input")).click();

		//Add to cart
		Thread.sleep(2000);
		driver.findElement(By.id("product-add-to-cart")).click();

		//click on View
		driver.findElement(By.xpath("(//p[@class='success-message show-cart'])[2]")).click();
		
		//Close the pop-up
		driver.findElement(By.xpath("//div[@class='hxt-spm-clickable']")).click();

		//Click on Checkout
		driver.findElement(By.xpath("//input[@id='update-cart']/following-sibling::input")).click();
		
		//Handle alert
		Alert alert = driver.switchTo().alert();
		System.out.println("Alert text is "+ alert.getText());
		alert.accept();
	}
}
