package co.udea.edu.certification.moduloTest.tasks;

import co.udea.edu.certification.moduloTest.userinterfaces.PurchaseFormPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.Map;

public class FillPurchaseForm {

    public static Performable withData(Map<String, String> formData) {
        // Usar getValue helper para evitar repetir formData.getOrDefault
        return Task.where("{0} fills the purchase form",
                Enter.theValue(getValue(formData, "Name"))
                        .into(PurchaseFormPage.NAME),

                Enter.theValue(getValue(formData, "Address"))
                        .into(PurchaseFormPage.ADDRESS),

                Enter.theValue(getValue(formData, "City"))
                        .into(PurchaseFormPage.CITY),

                Enter.theValue(getValue(formData, "State"))
                        .into(PurchaseFormPage.STATE),

                Enter.theValue(getValue(formData, "Zip Code"))
                        .into(PurchaseFormPage.ZIP_CODE),

                SelectFromOptions.byVisibleText(getValue(formData, "Card Type", "Visa"))
                        .from(PurchaseFormPage.CARD_TYPE),

                Enter.theValue(getValue(formData, "Card Number"))
                        .into(PurchaseFormPage.CARD_NUMBER),

                Enter.theValue(getValue(formData, "Month"))
                        .into(PurchaseFormPage.MONTH),

                Enter.theValue(getValue(formData, "Year"))
                        .into(PurchaseFormPage.YEAR),

                Enter.theValue(getValue(formData, "Name on card"))
                        .into(PurchaseFormPage.NAME_CARD)
        );
    }

    private static String getValue(Map<String, String> formData, String key) {
        return getValue(formData, key, "");
    }

    private static String getValue(Map<String, String> formData, String key, String defaultValue) {
        return formData.getOrDefault(key, defaultValue);
    }
}