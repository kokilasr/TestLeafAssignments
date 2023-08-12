package testcase;

import org.testng.annotations.Test;

import base.BaseClass;
import webpages.LoginPage;

public class WelcomePageTestCase extends BaseClass {
	@Test
	public void viewHomePage() {
		LoginPage lp = new LoginPage();
		lp.enterUserName().enterPassword().clickLoginButton().verifyWelcomePage().clickCRMSLink();
	}
}
