package co.udea.edu.certification.moduloTest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage {
    public static final Target CONFIRMATION_MESSAGE = Target.the("mensaje de confirmación")
            .located(By.xpath("/html/body/div[2]/div/h1"));
}
