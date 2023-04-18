package co.com.evalart.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.evalart.userinterfaces.LoginPage.*;
import static co.com.evalart.utils.Constants.PASSWORD;
import static co.com.evalart.utils.Constants.USERNAME;

public class Login implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(USERNAME).into(INPUT_USERNAME),
                Enter.theValue(PASSWORD).into(INPUT_PASSWORD),
                Click.on(BTN_LOGIN)

        );
    }

    public static Login with() {
        return Tasks.instrumented(Login.class);
    }
}
