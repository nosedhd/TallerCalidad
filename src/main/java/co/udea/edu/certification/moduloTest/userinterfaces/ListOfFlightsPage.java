package co.udea.edu.certification.moduloTest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ListOfFlightsPage {

    public static final Target LIST_FLIGHT_TEXT = Target.the("flight list text header")
            .located(By.xpath("/html/body/div[2]/h3"));
}
