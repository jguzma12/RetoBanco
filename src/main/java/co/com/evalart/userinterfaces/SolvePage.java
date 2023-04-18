package co.com.evalart.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SolvePage {
    public static final Target BTN_NUMBERS = Target.the("All numbers").
            locatedBy("(//*[@class='grid_button'])[{0}]");
    public static final Target TEXT_COORDENATES = Target.the("The coordenates").
            locatedBy("(//*[@class='text-center text-xl font-bold'])");

    public static final Target INPUT_SUMTOTAL = Target.the("The sum total").
            located(By.name("modal_answer"));

    public static final Target BTN_SEND = Target.the("The botton to send the result").
            located(By.xpath("//*[@class='border-black p-2 border-2 rounded-md mx-auto hover:bg-blue-300']"));


}
