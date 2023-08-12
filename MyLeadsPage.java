package webpages;

import org.openqa.selenium.By;

import base.BaseClass;

public class MyLeadsPage extends BaseClass {
	public CreateLeadPage clickCreateLead() {
		driver.findElement(By.partialLinkText("Create Lead")).click();
		CreateLeadPage clp = new CreateLeadPage();
		return clp;
	}

}
