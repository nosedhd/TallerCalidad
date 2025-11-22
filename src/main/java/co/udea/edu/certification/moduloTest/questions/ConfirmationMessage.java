package co.udea.edu.certification.moduloTest.questions;

import co.udea.edu.certification.moduloTest.userinterfaces.ConfirmationPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConfirmationMessage implements Question<Boolean> {  // ← Cambia a Boolean
    private final String expectedMessage;

    // Constructor privado
    private ConfirmationMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    // Método factoría que acepta el mensaje esperado
    public static ConfirmationMessage isEqualTo(String expectedMessage) {
        return new ConfirmationMessage(expectedMessage);
    }

    @Override
    public Boolean answeredBy(Actor actor) {  // ← Ahora retorna Boolean
        actor.attemptsTo(
                WaitUntil.the(ConfirmationPage.CONFIRMATION_MESSAGE, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        String actualMessage = Text.of(ConfirmationPage.CONFIRMATION_MESSAGE).answeredBy(actor);
        return actualMessage.equals(expectedMessage);
    }
}