package week4Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForce {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch the driver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter the credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		//Click on Learn More
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//Click confirm on Confirm redirect
		//Window handles
		Set<String> windowHandles = driver.getWindowHandles();
		int numberOfWindows = windowHandles.size();
		System.out.println("The number of window is: "+numberOfWindows );
		List<String> listOfWindows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listOfWindows.get(1));

		//Click on Confirm button
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(5000);

		//Click Learning 
		//Instantiate Shadow class
		Shadow shadowElements = new Shadow(driver);
		shadowElements.findElementByXPath("//span[text()='Learning']").click();

		//Mouse over on Learning On Trailhead
		WebElement learningOnTrailHead = shadowElements.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions action = new Actions(driver);
		action.moveToElement(learningOnTrailHead).perform();

		//Click on Salesforce Certifications
		Thread.sleep(5000);
		WebElement salesForceCertification = shadowElements.findElementByXPath("//a[text()='Salesforce Certification']");
		action.moveToElement(salesForceCertification).perform();
		shadowElements.findElementByXPath("//a[text()='Salesforce Certification']").click();

		//Click on first resulting Certificate
		driver.findElement(By.linkText("Administrator")).click();

		//verify - Administrator Overview page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("The current URL is " + currentUrl);
		if (currentUrl.contains("administrator"))
			System.out.println("Administrator Overview page is displayed");
		else
			System.out.println("Administrator Overview page is not displayed");

		//Find the number of certifications
		List<WebElement> numberofCertifications = driver.findElements(By.xpath("//div[text()='Certification']"));
		System.out.println("The number of certifications are "+ numberofCertifications.size());
		for(int i=0; i<numberofCertifications.size(); i++)
		{
			List<WebElement> certificationList = driver.findElements(By.xpath("//div[@class='credentials-card_title']/a"));
			System.out.println("Certification name:" + certificationList.get(i).getText());
		}

		//Get screenshot
		Thread.sleep(5000);
		WebElement certificationListPage = driver.findElement(By.xpath("//a[text()='Strategy Designer']"));
		action.scrollToElement(certificationListPage).perform();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snapshots/Salesforce.png");
		FileUtils.copyFile(source, destination);
	}
}
