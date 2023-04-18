package co.com.evalart.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target INPUT_USERNAME = Target.the("Input user name").
            located(By.xpath("(//*[@class='p-2 rounded-md'])[1]"));
    public static final Target INPUT_PASSWORD = Target.the("Input user password").
            located(By.xpath("(//*[@class='p-2 rounded-md'])[2]"));
    public static final Target BTN_LOGIN = Target.the("Botton to login").
            located(By.xpath("//*[@class='bg-white border-black p-2 border-2 rounded-md hover:bg-blue-300 w-1/2 mx-auto']"));


}
