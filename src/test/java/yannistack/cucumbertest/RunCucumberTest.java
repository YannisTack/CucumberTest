package yannistack.cucumbertest;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.HomePage;
import utils.DriverManager;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import java.util.concurrent.TimeUnit;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("yannistack/cucumbertest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
	@Before
	public void SetupWebdriver() {
		System.out.println("Setting up webdriver");
		DriverManager.getEDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		DriverManager.getEDriver().get(HomePage.url);
	}
	
	@After
	public void CleanupWebdriver() {
		System.out.println("Killing driver");
		DriverManager.killDriver();
	}
}
