package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/resource"},
		glue= {"com.simplilearn.Cucumber_E2E_Testing"},
		monochrome=true, plugin = {
        "html:target/cucumber-reports/report.html" }
		 )
public class testRunner {

}
