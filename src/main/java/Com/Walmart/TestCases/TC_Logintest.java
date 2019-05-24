package Com.Walmart.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.Walmart.PageObjects.HomePage;

public class TC_Logintest extends Base{
@Test
public void loginTest() throws IOException {
	
	logger.info("opened Url");
	HomePage hp=new HomePage(driver);
	hp.signUp();
	logger.info("Clicked on signin button");
	hp.sendUserName(username);
	logger.info("entered usrname");
	hp.clickContinue();
	logger.info("clicked on continue button");
	hp.sendPassword(password);
	logger.info("entered password");
	hp.ckckSubmit();
	logger.info("clicked on submit button");
	String pagetitle="Amazon Sign In";
	if(driver.getTitle().equals(pagetitle)) {
		Assert.assertTrue(true);
		logger.info("login-sucess");
	}
	else {
		Assert.assertFalse(false);
		caaptureScreenShoot(driver, "loginTest");
			
		logger.info("login-failed");
	}
}
}


