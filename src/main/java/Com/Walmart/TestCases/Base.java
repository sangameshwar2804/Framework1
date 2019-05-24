package Com.Walmart.TestCases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import Com.Walmart.Utilities.ReadProperties;

public class Base {
	ReadProperties rp= new ReadProperties();
public String baseurl=rp.getUrl();//tps://www.amazon.in/
public String username=rp.getUserName();//6303721807
public String password=rp.getPassword();//Innovpath1
public static WebDriver driver;
public static Logger logger;
@Parameters("browser")
@BeforeClass
public void beforeClass(String BrowserName) {
	 

logger=logger.getLogger("Base");
PropertyConfigurator.configure("Log4j.properties");
if(BrowserName.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver",rp.getChromePath());
	driver=new ChromeDriver();
}
else if(BrowserName.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver",rp.getFirefoxPath());
	driver=new FirefoxDriver();
}
else if(BrowserName.equals("ie")) {
	System.setProperty("webdriver.ie.driver",rp.getIePath());
	driver=new InternetExplorerDriver();
}
driver.get(baseurl);
driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
}

@AfterClass
public void aftreClass()
{
driver.quit();	
}
public void caaptureScreenShoot(WebDriver driver,String testcasename) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File scr= ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+testcasename+".png");
	FileUtils.copyDirectory(scr, target);
	System.out.println("screenshoot taken");
}
}
