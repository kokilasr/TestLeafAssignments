package webpages;

import org.openqa.selenium.By;

import base.BaseClass;

public class HomePage extends BaseClass {

	public MyLeadsPage clickLeads() {
	driver.findElement(By.partialLinkText("Leads")).click();
	MyLeadsPage lp = new MyLeadsPage();
	return lp;
	}
}
