package co.com.evalart.tasks;

import co.com.evalart.userinterfaces.SolvePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class Solve implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int j = 0; j < 12; j++) {


            String coordinates = Text.of(SolvePage.TEXT_COORDENATES).viewedBy(actor).asString();
            String[] vector = coordinates.replace(")-", ",").replace("(", "").replace(")", "").
                    replace("*", ",").replace("_", ",").replace(";", ",").
                    replace(".", ",").split(",");
            int countX = 0;
            int countY = 0;
            int quantityColums = 0;
            if (Target.the("").locatedBy("//div[@class='w-3/2 grid gap-4 grid-cols-14']").
                    resolveFor(actor).isVisible()) {
                quantityColums = 14;
            }
            if (Target.the("").locatedBy("//div[@class='w-3/2 grid gap-4 grid-cols-12']").
                    resolveFor(actor).isVisible()) {
                quantityColums = 12;
            }

            for (int i = 0; i < vector.length; i += 2) {
                countX = countX + Integer.parseInt(vector[i]);
            }
            for (int i = 1; i < vector.length; i += 2) {
                countY = countY + Integer.parseInt(vector[i]);
            }
            int positionXY = (countY * quantityColums + countX) + 1;
            int columTotal = 0;
            int position = countX;
            for (int i = 0; i < quantityColums; i++) {
                columTotal = columTotal + Integer.parseInt(Text.of(SolvePage.BTN_NUMBERS.of(String.valueOf(position + 1))).
                        viewedBy(actor).asString());
                position = position + quantityColums;
            }


            actor.attemptsTo(
                    Scroll.to(SolvePage.BTN_NUMBERS.of(String.valueOf(positionXY))).andAlignToBottom(),
                    Click.on(SolvePage.BTN_NUMBERS.of(String.valueOf(positionXY))),
                    Enter.theValue(String.valueOf(columTotal)).into(SolvePage.INPUT_SUMTOTAL),
                    Click.on(SolvePage.BTN_SEND)
            );
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Solve with() {
        return Tasks.instrumented(Solve.class);
    }
}
