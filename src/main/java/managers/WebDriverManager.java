package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;
import managers.FileReaderManager;

public class WebDriverManager {
	
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	public DriverType drivertype;
	public EnvironmentType environement;
	public WebDriver driver;
	
	public WebDriverManager() throws IOException {
		
		drivertype = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environement = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	
	public WebDriver getWebDriver() throws IOException {
	
		if(driver==null) driver=Createdriver();
		return driver;
}


	public WebDriver Createdriver() throws IOException {
		switch (drivertype) {
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverpath());
        	driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}
		return driver;
	}
	
	public void quitDriver() {
		driver.close();
	}

}