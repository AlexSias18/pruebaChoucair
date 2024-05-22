package org.prueba.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features",
        glue = {"org.prueba.stepsdefinitions","org.prueba.hooks"},
        tags="@test1"
)
public class RunnerTest {
    private static EnvironmentVariables envs= SystemEnvironmentVariables.createEnvironmentVariables();
}
