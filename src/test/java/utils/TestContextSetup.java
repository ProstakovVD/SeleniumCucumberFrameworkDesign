package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import abstractComponents.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String productNameLP;
	public String productNameTDP;
	public String usualProductNameCP;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	
	public TestContextSetup() throws IOException {
		
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		
	}
	
}
