package co.udea.edu.certification.moduloTest.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class Clicks implements Interaction {

    private final Target element;

    public Clicks(Target element) {
        this.element = element;
    }

    public static Clicks on(Target element) {
        return Tasks.instrumented(Clicks.class, element);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(element)
        );
    }

}
