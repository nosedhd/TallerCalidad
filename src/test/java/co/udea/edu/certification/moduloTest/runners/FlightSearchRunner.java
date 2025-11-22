package co.udea.edu.certification.moduloTest.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/BlazeDemo/FlightSearch.feature",
        glue = "co.udea.edu.certification.moduloTest.stepdefinitions.blazeDemoSteps",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@blaze_demo",
        plugin = {"pretty", "html:target/cucumber-reports/flight-search.html"}
)
public class FlightSearchRunner {}