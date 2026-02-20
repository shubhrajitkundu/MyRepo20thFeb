package StepDefinition14;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(
		features="src/test/java/FeatureFiles/",
		glue= {"StepDefinition14"},
		tags="@sanity",
		dryRun=false,
		monochrome=false,
		
		plugin= {"pretty","html:target/CucumberReport/index.html"}
		
		
		
		
		
		)

















public class TestRunner15 {

}
