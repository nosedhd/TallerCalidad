package co.udea.edu.certification.moduloTest.stepdefinitions.blazeDemoSteps;

import co.udea.edu.certification.moduloTest.questions.ConfirmationMessage;
import co.udea.edu.certification.moduloTest.questions.ListOfFlights;
import co.udea.edu.certification.moduloTest.tasks.FillPurchaseForm;
import co.udea.edu.certification.moduloTest.tasks.NavigateTo;
import co.udea.edu.certification.moduloTest.tasks.SearchFlights;
import co.udea.edu.certification.moduloTest.tasks.SelectFlight;
import co.udea.edu.certification.moduloTest.userinterfaces.PurchaseFormPage;
import co.udea.edu.certification.moduloTest.userinterfaces.SearchFormPage;
import co.udea.edu.certification.moduloTest.utils.AvailableCities;
import co.udea.edu.certification.moduloTest.utils.WaitTime;
import co.udea.edu.certification.moduloTest.interactions.Clicks;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.hamcrest.JMock1Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BlazeDemoStep {

    public final Actor User = Actor.named("Customer");
    @Managed(driver ="chrome", uniqueSession = true)
    public WebDriver driver;

    @Before
    public void config(){
        User.can(BrowseTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Customer");
    }


    @Given("User opens the booking page")
    public void userOpensTheBookingPage() {
        User.wasAbleTo(NavigateTo.blazeDemo()); // Como es una configuración que debe si o si funcionar, se usa wasableto
        //WaitTime.putWaitTimeOf(2000);
    }

    @When("searches for flights from {string} to {string}")
    public void
    searchesForFlightsFromTo(String origin, String destination) {
        User.attemptsTo(
                SearchFlights.from(origin).to(destination)
        );
        //WaitTime.putWaitTimeOf(2000);
    }

    @Then("should see a list of available flights from {string} to {string}")
    public void shouldSeeAListOfAvailableFlightsFromTo(String origin, String destination) {
        User.should(seeThat("flights list", ListOfFlights.from(origin, destination), is(true)));
    }

    @And("selects the flight with the {string} price")
    public void selectsTheFlightWithThePrice(String priceCriteria) {
        // El (.+) captura cualquier texto después de "the " y antes de " price"
        switch (priceCriteria.toLowerCase()) {
            case "lowest":
                //WaitTime.putWaitTimeOf(2000);
                User.attemptsTo(SelectFlight.withLowestPrice());
                break;
            case "highest":
                //WaitTime.putWaitTimeOf(2000);
                User.attemptsTo(SelectFlight.withHighestPrice());
                break;
            default:
                throw new IllegalArgumentException("Unknown price criteria: " + priceCriteria);
        }
    }

    @When("Complete the reservation form with:")
    public void completeTheReservationFormWith(DataTable dataTable) {
        // Convertir DataTable a Map
        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        // Ejecutar la tarea de llenar el formulario
        User.attemptsTo(FillPurchaseForm.withData(formData));
        //WaitTime.putWaitTimeOf(2000);
    }

    @And("clicks on Purchase Flight")
    public void clicksOnPurchaseFlight() {
        User.attemptsTo(Clicks.on(PurchaseFormPage.PURCHASE_BUTTON));
    }

    @Then("should see the message {string} of confirmation purchase")
    public void shouldSeeTheMessageOfConfirmationPurchase(String expectedMessage) {
        User.should(seeThat("mensaje de confirmación", ConfirmationMessage.isEqualTo(expectedMessage), is(true)));
        //WaitTime.putWaitTimeOf(2000);
    }


    @Then("should see the details of the selected flight")
    public void shouldSeeTheDetailsOfTheSelectedFlight() {
        User.should(seeThat("detalle de vuelo",
                actor -> driver.getCurrentUrl().contains("/purchase.php")));
        //WaitTime.putWaitTimeOf(2000);
    }
}
