package co.udea.edu.certification.moduloTest.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Tasks;

public class SelectDropdownValue implements Interaction {

    private final Target dropdown;
    private final String value;

    public SelectDropdownValue(Target dropdown, String value) {
        this.dropdown = dropdown;
        this.value = value;
    }

    public static SelectDropdownValue on(Target dropdown, String value) {
        return Tasks.instrumented(SelectDropdownValue.class, dropdown, value);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try{
            actor.attemptsTo(
                    SelectFromOptions.byVisibleText(value).from(dropdown)
            );
        } catch (NoSuchElementException e){
            Serenity.recordReportData().withTitle("Missing Option Error")
                    .andContents("Could not find option: '" + value + "' in dropdown: " + dropdown.getName());
            throw new AssertionError("Dropdown option '" + value + "' not found. Available options might be different.", e);
        }
    }

}