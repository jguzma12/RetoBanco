package co.com.evalart.runners;

import com.google.common.jimfs.Feature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\login_solve.feature",
        glue = "co.com.evalart.stepdefinitions",
        snippets = SnippetType.CAMELCASE
)
public class LoginSolveRunner {
}
