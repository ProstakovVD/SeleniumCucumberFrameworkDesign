package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		if(driver == null) {
			
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//GlobalData.properties");
			prop.load(fis);
			String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
			String URL = prop.getProperty("QAUrl");
			
			if(browserName.contains("chrome")){
				
				ChromeOptions opotions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				if(browserName.contains("headless")) {
					
					opotions.addArguments("headless");
					
				}
				driver = new ChromeDriver(opotions);
				driver.manage().window().setSize(new Dimension(1440,900));
				
			} else if(browserName.contains("edge")) {
				
				EdgeOptions opotions = new EdgeOptions();
				WebDriverManager.edgedriver().setup();
				if(browserName.contains("headless")) {
					
					opotions.addArguments("headless");
					
				}
				driver = new EdgeDriver(opotions);
				driver.manage().window().setSize(new Dimension(1440,900));
				
			}
		//driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	    	driver.get(URL);
			
		}
		
		return driver;
    	
	}
	
}
