package co.udea.edu.certification.moduloTest.questions;

import co.udea.edu.certification.moduloTest.userinterfaces.ListOfFlightsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class ListOfFlights implements Question<Boolean> {

    private final String origin;
    private final String destination;

    private ListOfFlights(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public static ListOfFlights from(String origin, String destination) {
        return new ListOfFlights(origin, destination);
    }

    public static Question<Boolean> isVisible() {
        return actor ->
                ListOfFlightsPage.LIST_FLIGHT_TEXT.resolveFor(actor).isVisible();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // Obtener el texto del header
        String actualMessage = Text.of(ListOfFlightsPage.LIST_FLIGHT_TEXT)
                .answeredBy(actor)
                .trim();

        // Construir el mensaje esperado dinámicamente
        String expectedMessage = String.format("Flights from %s to %s:", origin, destination);

        // Comparar (ignora mayúsculas/minúsculas)
        return actualMessage.equalsIgnoreCase(expectedMessage);
    }
}