package Com.Walmart.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver diver;
public HomePage(WebDriver driver) {
	this.diver=driver;
	PageFactory.initElements(driver, this);
}
//web elements
@FindBy(xpath="//a[@id='nav-link-yourAccount']")
WebElement signbutton;
@FindBy(xpath="//input[@id='ap_email']")
WebElement txtUserName;
@FindBy(xpath="//input[@id='continue']")
WebElement continuebutton;
@FindBy(xpath="//input[@id='ap_password']")
WebElement txtUserPasword;
@FindBy(xpath="//input[@id='signInSubmit']")
WebElement submitBtn;

//action on web elements
public void signUp() {
	signbutton.click();
}
public void sendUserName(String username) {
	txtUserName.sendKeys(username);
}
public void clickContinue() {
	continuebutton.click();
}
public void sendPassword(String password) {
	txtUserPasword.sendKeys(password);
}
public void ckckSubmit() {
	submitBtn.click();
}

}
