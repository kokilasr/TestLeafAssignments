package webpages;

import org.openqa.selenium.By;

import base.BaseClass;

public class ViewLeadPage extends BaseClass{
	public String leadText;
	public ViewLeadPage confirmLeadCreation() {
	leadText = driver.findElement(By.xpath("//span[text()='Company Name']/following::span")).getText();
	if(leadText.contains("Test"))
		System.out.println("Lead is created successfully");
	else
		System.out.println("Lead is not created");
	return this;
	}
}
