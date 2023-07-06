package week2marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException {
	//Launch the Chrome Browser
	ChromeDriver driver = new ChromeDriver();

	//Launch the URL
	driver.get("https://www.amazon.in/");

	//Maximize the window
	driver.manage().window().maximize();

	//Implicit wait
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	//Enter text in search box
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags");
	
	//Select bags for boys
	driver.findElement(By.xpath("//span[text()=' for boys']/parent::div")).click();
	
	//Print the total number of results
	String results = driver.findElement(By.xpath("//div[@class = 'a-section a-spacing-small a-spacing-top-small']")).getText();
	System.out.println("The total number of results is "+ results);
	
	//Select the 1st two brands
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//span[text()='Skybags']/preceding::i[@class='a-icon a-icon-checkbox'])[3]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//span[text()='Safari']/preceding::i[@class='a-icon a-icon-checkbox'])[4]")).click();
	Thread.sleep(5000);
	
	//Select Newest Arrival option
	WebElement sortBy = driver.findElement(By.id("s-result-sort-select"));
	Select sort = new Select(sortBy);
	sort.selectByVisibleText("Newest Arrivals");
	
	//Print resulting bag info, discounted price and title
	System.out.println("The first resulting bag info is "+ driver.findElement(By.xpath("//span[contains(text(),'Marvel Spiderman')]")).getText());;
	System.out.println("Discounted price is "+ driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText());
	System.out.println("The title of the page is "+ driver.getTitle());
	
	//Close the browser
	driver.close();
}
}