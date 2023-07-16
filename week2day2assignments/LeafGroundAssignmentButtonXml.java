package week2.week2day2assignments;

import java.time.Duration;
import java.util.List;

import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundAssignmentButtonXml {
	public static void main(String[] args) throws InterruptedException {
		//Launch the driver
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//Click and Confirm title.
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String title = driver.getTitle();
		if(title.contains("Dashboard"))
			System.out.println("Correct title");
		else
			System.out.println("Incorrect title");

		//Confirm if the button is disabled.
		driver.get("https://www.leafground.com/button.xhtml");
		Thread.sleep(5000);
		boolean enabled = driver.findElement(By.xpath("//h5[text() ='Confirm if the button is disabled.']/following::button")).isEnabled();
		if(enabled)
			System.out.println("Button is enabled");
		else
			System.out.println("Button is disabled");

		//Find the position of the Submit button
		WebElement position = driver.findElement(By.xpath("//span[text()='Submit']"));
		System.out.println("The position of the button is " + position.getLocation());

		//Find the Save button color
		WebElement color = driver.findElement(By.xpath("//span[text()='Save']"));
		String buttonColor = color.getCssValue("color");
		System.out.println("The color of the button is "+ buttonColor);


		//Find the height and width of this button
		WebElement heightWidth = driver.findElement(By.xpath("(//span[text() = 'Submit'])[2]"));
		System.out.println("Height and Width of the button is" + heightWidth.getSize());

		//Mouse over and confirm the color changed
		Actions action = new Actions(driver);
		WebElement colorChangeButton = driver.findElement(By.xpath("//span[text()='Success']"));
		String colorBeforeMouseOver = colorChangeButton.getCssValue("background-color");
		System.out.println("The button color before mouse over is "+ colorBeforeMouseOver);
		action.moveToElement(colorChangeButton).perform();
		String colorAfterMouseOver = colorChangeButton.getCssValue("background-color");
		Thread.sleep(6000);
		System.out.println("The button color after mouse over is "+ colorAfterMouseOver);
		if (colorBeforeMouseOver.equals(colorAfterMouseOver))
			System.out.println("Color has not changed after mouse over");
		else
			System.out.println("Color has changed after mouse over");

		//Click Image Button and Click on any hidden button
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		Thread.sleep(5000);
		boolean click = driver.findElement(By.xpath("//span[text()='Secondary']")).isSelected();
		if(!click)
			System.out.println("Unable to click on hidden button");
		else
			System.out.println("Able to click on hidden button");

		//How many rounded buttons are there?
		List<WebElement> countRoundButtons = driver.findElements(By.xpath("//h5[contains(text(), 'How many rounded buttons')]/following::button"));
		System.out.println("The number of rounded buttons are "+ countRoundButtons.size());
	}
}
