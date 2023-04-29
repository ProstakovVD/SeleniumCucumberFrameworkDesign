package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				,"pretty","html:reports/cucumber.html","json:reports/cucumber.json"}
		
		,features="@target/failed_scenarious.txt"
		,glue={"stepDefinitions"}
		,dryRun = false

)

public class TestRerunner {
	
}