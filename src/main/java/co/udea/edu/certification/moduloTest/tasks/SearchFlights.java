package co.udea.edu.certification.moduloTest.tasks;


import co.udea.edu.certification.moduloTest.interactions.Clicks;
import co.udea.edu.certification.moduloTest.interactions.SelectDropdownValue;
import co.udea.edu.certification.moduloTest.userinterfaces.SearchFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class SearchFlights implements Task {

    private final String origin;
    private final String destination;

    public SearchFlights(String origin, String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public static SearchFlights from(String origin) {
        return new SearchFlights(origin, null);
    }

    public SearchFlights to(String destination) {
        return new SearchFlights(this.origin, destination);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectDropdownValue.on(SearchFormPage.ORIGIN, origin),
                SelectDropdownValue.on(SearchFormPage.DESTINATION, destination),
                Clicks.on(SearchFormPage.FIND_FLIGHTS_BUTTON)
        );
    }



}
