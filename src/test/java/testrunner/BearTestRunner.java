package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/vanchinathanac/Desktop/SeleniumTableSprint1/src/test/java/feature/bear/beartable.feature",
glue = {"stepdefinition"},
plugin = {"pretty","html:target/html","json:target/report.json"},monochrome = true,dryRun = false,strict = true)
public class BearTestRunner {
}
