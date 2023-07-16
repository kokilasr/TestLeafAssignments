package week2.week2day2assignments;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGroundAssignmentInputXhtml {
	public static void main(String[] args) throws InterruptedException {
		//Launch the Chrome Browser
		ChromeDriver driver = new ChromeDriver();

		//Launch the URL
		driver.get("https://www.leafground.com/input.xhtml");

		//Maximize the window
		driver.manage().window().maximize();

		//Actions for webelements
		//Enter your name
		driver.findElement(By.xpath("//input[contains(@class, 'ui-inputfield ui-inputtext')]")).sendKeys("Kokila Shree");

		//Append Country to this City.
		driver.findElement(By.xpath("//input[contains(@class,'ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all city')]")).clear();

		//Verify if text box is disabled
		driver.findElement(By.xpath("//input[contains(@class,'ui-inputfield ui-inputtext ui-widget ui-state-default ui-corner-all city')]")).sendKeys("Mumbai");
		WebElement textBox = driver.findElement(By.xpath("(//input[contains(@class, 'ui-inputfield ui-inputtext')])[3]"));
		if (textBox.isEnabled())
			System.out.println("The textbox is enabled");
		else
			System.out.println("The textbox is disabled");

		//Clear the typed text
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();

		//Retrieve the typed text.
		System.out.println("The typed text is " + driver.findElement(By.xpath("//h5[contains(text(), 'Retrieve the')]/following::input")).getAttribute("value"));

		//Type email and tab
		driver.findElement(By.xpath("//h5[contains(text(), 'Type email')]/following::input")).sendKeys("test.com");

		//Check whether control moved to next element 
		driver.findElement(By.xpath("//h5[contains(text(), 'Type email')]/following::input")).sendKeys(Keys.TAB);
		if (driver.findElement(By.xpath("//h5[contains(text(), 'Type about')]/following::textarea")).isSelected())
		{
			//driver.findElement(By.xpath("//h5[contains(text(), 'Type about')]/following::textarea")).sendKeys("I am Kokila");
			System.out.println("Control moved to next element");
		}
		else
			System.out.println("Control is not moved to next element");

		//Type about yourself
		driver.findElement(By.xpath("//h5[contains(text(), 'Type about')]/following::textarea")).sendKeys("I am Kokila");

		//Text Editor
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']/p")).sendKeys("Sample Text");
		driver.findElement(By.xpath("//div[@class='ql-container ql-snow']//p")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath("//button[@class='ql-strike']")).click();

		//Just Press Enter and confirm error message*
		driver.findElement(By.xpath("(//h5[contains(text(), 'Just Press Enter and confirm')]/following::input)[2]")).sendKeys(Keys.ENTER);
		if (driver.findElement(By.className("ui-message-error-detail")).getText().contains("Age is"))
			System.out.println("Error message is displayed correctly");
		else
			System.out.println("Error message is not displayed correctly");

		//Click and Confirm Label Position Changes
		if(driver.findElement(By.xpath("//input[@name='j_idt106:float-input']/following-sibling::label")).getText().contains("Username"))
		{
			System.out.println("Label is present");
		}
		else
			System.out.println("Label is not present");

		driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).click();

		if(driver.findElement(By.xpath("//span[@class='ui-float-label']/input")).getText().isBlank())
			System.out.println("Label position is changed");
		else
			System.out.println("Label position is not changed");

		//Type your name and choose the third option
		driver.findElement(By.xpath("//li[@class='ui-autocomplete-input-token']/input")).sendKeys("Kokila");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[text()='2']")).click();

		//Type DOB and confirm
		driver.findElement(By.xpath("//span[contains(@class, 'ui-trigger-calendar')]/input")).sendKeys("01/09/1982");
		String month = driver.findElement(By.xpath("//span[text()='January']")).getText();
		String monComp = month;
		System.out.println("Month is "+ month );
		String year = driver.findElement(By.xpath("//span[text()='1982']")).getText();
		String yearComp = year;
		System.out.println("Year is "+ year );
		String day = driver.findElement(By.xpath("//a[text()='9']")).getText();
		String dayComp = day;
		System.out.println("Day is "+ day );
		if(month.equals(monComp) && year.equals(yearComp) && day.equals(dayComp))
			System.out.println("DOB is correct");
		else
			System.out.println("DOB is incorrect");

		//Type number and spin to confirm value increased
		driver.findElement(By.xpath("//h5[contains(text(), 'spin to confirm value changed')]/following::input[1]")).sendKeys("25");
		driver.findElement(By.xpath("//h5[contains(text(), 'spin to confirm value changed')]/following::a")).click();
		Thread.sleep(5000);
		String number = driver.findElement(By.xpath("//h5[contains(text(), 'spin to confirm value changed')]/following::input[1]")).getAttribute("value");
		if(number.contains("26"))
			System.out.println("Value is increased");
		else
			System.out.println("Value is not increased");
		//Spin to confirm value decreased
		driver.findElement(By.xpath("//h5[contains(text(), 'spin to confirm value changed')]/following::a[2]")).click();
		String value = driver.findElement(By.xpath("//h5[contains(text(), 'spin to confirm value changed')]/following::input[1]")).getAttribute("value");
		if(value.contains("25"))
			System.out.println("Value is decreased");
		else
			System.out.println("Value is not decreased");

		//Type random number (1-100) and confirm slider moves correctly
		driver.findElement(By.xpath("//h5[contains(text(), 'Type random number')]/following-sibling::input")).sendKeys("45");
		String style = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle')]")).getAttribute("style");
		if(!style.isBlank())
			System.out.println("The slider has moved");
		else
			System.out.println("The slider has not moved");

		//Click and Confirm Keyboard appears
		driver.findElement(By.xpath("//h5[contains(text(),'Confirm Keyboard appears')]//following-sibling::input")).click();
		boolean displayed = driver.findElement(By.xpath("//div[@id='textarea_simulator']/following::div")).isDisplayed();
		if(displayed)
			System.out.println("Keyboard is displayed");
		else
			System.out.println("Keyboard not displayed");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		//Custom Toolbar
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]/p")).click();
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]/p")).sendKeys("Test content", Keys.CONTROL+"a");
		driver.findElement(By.xpath("(//button[@class='ql-underline'])[2]")).click();
		WebElement underlineTag = driver.findElement(By.tagName("u"));
		if(underlineTag.getText().contains("Test content"))
			System.out.println("Text is underlined");
		else
			System.out.println("The text is not underlined");


	}
}
