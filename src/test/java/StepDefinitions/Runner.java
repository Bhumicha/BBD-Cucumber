package StepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        plugin = {"pretty:target/cucumber-pretty.txt", "html:target/cucumber-html-report.html",
                "json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@loginSuccess or @loginFailure")

public class Runner extends AbstractTestNGCucumberTests {
}
