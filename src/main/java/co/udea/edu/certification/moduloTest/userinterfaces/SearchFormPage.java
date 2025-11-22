package co.udea.edu.certification.moduloTest.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchFormPage extends PageObject {
    public static final Target ORIGIN = Target.the("origin field")
            .located(By.xpath("/html/body/div[3]/form/select[1]"));

    public static final Target DESTINATION = Target.the("destination field")
            .located(By.xpath("/html/body/div[3]/form/select[2]"));

    public static final Target FIND_FLIGHTS_BUTTON = Target.the("find flights button")
            .located(By.xpath("/html/body/div[3]/form/div/input"));
}
