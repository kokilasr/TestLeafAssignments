package webpages;

import org.openqa.selenium.By;

import base.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage enterUserName() {
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		return this;
	}
	
	public LoginPage enterPassword() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		return this;
	}
	
	public WelcomePage clickLoginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
		WelcomePage wp = new WelcomePage();
		return wp;

	}
}
