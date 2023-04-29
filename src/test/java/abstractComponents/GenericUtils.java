package abstractComponents;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {

WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void waitForElementToAppear(By findBy){
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void switchWindowToChild() {
		
		List<String> windows = new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(windows.get(1));
		
	}
	
	
}
