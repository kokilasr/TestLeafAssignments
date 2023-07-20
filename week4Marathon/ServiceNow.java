package week4Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {
public static void main(String[] args) throws InterruptedException, IOException {
	//Launch ServiceNow application
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://dev31913.service-now.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Login with valid credentials username as admin and password 
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("q+NozS5Qe8!E");
	driver.findElement(By.id("sysverb_login")).click();
	
	//Shadow element - Click-All
	Shadow shadowAll = new Shadow(driver);
	shadowAll.setImplicitWait(10);
	shadowAll.findElementByXPath("//div[@id='all']").click();
	
	//Enter Service catalog in filter navigator
	//shadowAll.findElementByXPath("//input[@id='filter']").sendKeys("Service");
	shadowAll.findElementByXPath("//span[text()='Service Catalog']").click();
	Thread.sleep(2000);
	
	WebElement frame = shadowAll.findElementByXPath("//iframe[@id='gsft_main']");	
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
	
	//Select Apple iphone6s
	driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
	
	//Update color field to Rose gold and storage field to 128GB
	Thread.sleep(2000);
	WebElement colorDropDown = driver.findElement(By.xpath("(//select[contains(@class,'cat_item_option')])[2]"));
	Thread.sleep(2000);
	Select color = new Select(colorDropDown);
	color.selectByVisibleText("Rose Gold");
	
	WebElement storageDropDown = driver.findElement(By.xpath("(//select[contains(@class,'cat_item_option')])[3]"));
	Thread.sleep(2000);
	Select storage = new Select(storageDropDown);
	storage.selectByIndex(2);

	//Select  Order now option
	driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
	
	//Verify order is placed and copy the request number"
	String orderText = driver.findElement(By.xpath("//span[contains(text(),'your request has been submitted')]")).getText();
	if (orderText.contains("submitted"))
		System.out.println("The order is placed");
	else
		System.out.println("The order is not placed");
	
	String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
	System.out.println("Request number is :"+ requestNumber);
	
	//Take snapshot
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./snapshots/servicenow.png");
	FileUtils.copyFile(source, dest);
	
}
}
