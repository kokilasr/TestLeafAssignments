package week4.week4day2assignments;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickAndConfirmNewWindowOpens {
	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("//span[text()='Open']")).click();
		//parent window title
		System.out.println("Parent title "+ driver.getTitle());

		//parent window handle
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle "+ parentWindowHandle);

		//to get the set of window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		//get the size
		int numberOfWindows = windowHandles.size();
		System.out.println("Nuber of windows: "+ numberOfWindows);

		//convert set to list to get the index as set does not have index
		List<String> listOfHandles = new ArrayList<String>(windowHandles);

		for (String each : listOfHandles) {
			System.out.println(each);
		}

		//switch to child window
		driver.switchTo().window(listOfHandles.get(1));
		System.out.println("Child window :"+ driver.getTitle());
		
		

	}
}
