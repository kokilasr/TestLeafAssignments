package webpages;

import org.openqa.selenium.By;

import base.BaseClass;

public class WelcomePage extends BaseClass{

	public WelcomePage verifyWelcomePage() {
		String welcomeText = driver.findElement(By.xpath("//h2[text()='Welcome ']")).getText();
		if(welcomeText.contains("Welcome"))
			System.out.println("Welcome page is displayed correctly");
		else
			System.out.println("Welcome page is not displayed correctly");
		return this;
	}
	
	public HomePage clickCRMSLink() {
	driver.findElement(By.partialLinkText("CRM")).click();
	HomePage hp = new HomePage();
	return hp;
	}
}
