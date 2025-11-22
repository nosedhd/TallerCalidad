package co.udea.edu.certification.moduloTest.utils;

import co.udea.edu.certification.moduloTest.userinterfaces.SearchFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AvailableCities {

    public static Question<List<String>> inDepartureDropdown() {
        return actor ->
                SearchFormPage.ORIGIN
                        .resolveAllFor(actor).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
    }

    public static Question<List<String>> inDestinationDropdown() {
        return actor ->
                SearchFormPage.DESTINATION
                        .resolveAllFor(actor).stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());
    }
}