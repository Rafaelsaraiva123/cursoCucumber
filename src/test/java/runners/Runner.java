package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/seu_barriga.feature",
        glue = "steps",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)

public class Runner {

}
