package dataproviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigFileReader {
	
	private static Properties prop;
	
	
	public ConfigFileReader() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\kselvaraj\\Cucumberframework\\Configs\\Configuration.properties");
		prop = new Properties();
		prop.load(fis);
			}
		
	public String getDriverpath() {
		
		String Driverpath =  prop.getProperty("driverpath");
		if(Driverpath!= null) return Driverpath;
		else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
		
	}

	public long getImplicitlyWait() {		
		String implicitlyWait = prop.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = prop.getProperty("url");
		System.out.println(url);
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public DriverType getBrowser() {
		String browsername = prop.getProperty("browser");
		if (browsername ==null || browsername.equals("Chrome") ) return DriverType.CHROME;
		else if (browsername.equalsIgnoreCase("firefox") ) return DriverType.FIREFOX;
		else if (browsername.equalsIgnoreCase("iexplorer") ) return DriverType.FIREFOX;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browsername);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = prop.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.Local;
		else if(environmentName.equals("remote")) return EnvironmentType.Remote;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
 
	public Boolean getBrowserWindowSize() {
		String windowSize = prop.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	
}
