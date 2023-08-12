package testcase;

import org.testng.annotations.Test;

import base.BaseClass;
import webpages.LoginPage;

public class CreateLeadTestCase extends BaseClass {
	@Test
	public void createLeadTC() {
		LoginPage lp = new LoginPage();
		lp.enterUserName()
		  .enterPassword()
		  .clickLoginButton()
		  .verifyWelcomePage()
		  .clickCRMSLink()
		  .clickLeads()
		  .clickCreateLead()
		  .enterCompanyName()
		  .enterFirstName()
		  .enterLastName()
		  .clickCreateLeadButton()
		  .confirmLeadCreation();

		  
		

	}
}
