package Com.Walmart.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
public static Properties pro;
public ReadProperties()  {
	File fs=new File("./Configurations/config.properties");//fs
	try {
		FileInputStream fis=new FileInputStream(fs);//path of config.properties
		pro=new Properties();
		pro.load(fis);//fis
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		
		System.out.println(e.getMessage());
	}
}
public String getUrl() {
	String url=pro.getProperty("BaseUrl");//https://www.amazon.in/
	return url;
}
public String getUserName() {
	String username=pro.getProperty("UserName");
	return username;
}
public String getPassword() {
	String password=pro.getProperty("Password");
	return password;
}
public String getChromePath() {
	String ChromePath=pro.getProperty("ChromePath");
	return ChromePath;
}
public String getFirefoxPath() {
	String FirefoxPath=pro.getProperty("ChromePath");
	return FirefoxPath;
}
public String getIePath() {
	String IePath=pro.getProperty("IePath");
	return IePath;
}
}
