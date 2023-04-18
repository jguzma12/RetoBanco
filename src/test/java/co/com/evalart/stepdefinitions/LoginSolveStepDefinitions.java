package co.com.evalart.stepdefinitions;

import co.com.evalart.tasks.Login;
import co.com.evalart.tasks.Solve;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.aspectj.apache.bcel.classfile.Module;
import org.openqa.selenium.WebDriver;

public class LoginSolveStepDefinitions {

    @Managed
    private WebDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("Actor");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(driver));
    }
    @Given("^the user enter to page$")
    public void theUserEnterToPage() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://tasks.evalartapp.com/automatization/"));

    }

    @When("^Solve al pages$")
    public void solveAlPages() {
        OnStage.theActorInTheSpotlight().attemptsTo(Login.with(), Solve.with());

    }

    @Then("^The user should see the result$")
    public void theUserShouldSeeTheResult() {

    }


}
