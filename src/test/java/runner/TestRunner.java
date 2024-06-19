package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefination","com.helper"},tags=" @smoke",
plugin="json:target/Cucummber-Report/cucumber.json")

public class TestRunner {

}
