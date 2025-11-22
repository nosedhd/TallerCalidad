package co.udea.edu.certification.moduloTest.tasks;

import co.udea.edu.certification.moduloTest.interactions.Clicks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import co.udea.edu.certification.moduloTest.userinterfaces.ResultsTablePage;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SelectFlight implements Task {

    private final Comparator<Double> comparator;

    public SelectFlight(Comparator<Double> comparator) {
        this.comparator = comparator;
    }

    public static SelectFlight withLowestPrice() {
        return new SelectFlight(Comparator.naturalOrder());
    }

    public static SelectFlight withHighestPrice() {
        return new SelectFlight(Comparator.reverseOrder());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Target> prices = ResultsTablePage.Flight_Prices;
        List<Target> buttons = ResultsTablePage.Select_Button;

        Optional<Integer> index = prices.stream()
                .map(target -> target.resolveFor(actor).getText().replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(java.util.stream.Collectors.toList())
                .stream()
                .collect(java.util.stream.Collectors.collectingAndThen(
                        java.util.stream.Collectors.toList(),
                        lista -> {
                            Double valor = lista.stream().min(comparator).orElseThrow();
                            return Optional.of(lista.indexOf(valor));
                        }
                ));
        if (index.isPresent()) {
            actor.attemptsTo(
                    Clicks.on(buttons.get(index.get()))
            );
        } else {
            throw new RuntimeException("No se pudo encontrar el vuelo con el precio deseado");
        }


    }

}
