package co.udea.edu.certification.moduloTest.tasks;

import co.udea.edu.certification.moduloTest.config.ApplicationURL ;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class NavigateTo {

    public static Performable application(ApplicationURL app) {
        return Task.where("{0} navigates to " + app.getName(),
                Open.url(app.getUrl())
        );
    }

    // Métodos específicos para facilidad de uso
    public static Performable sauceDemo() {
        return Task.where("{0} navigates to Sauce Demo",
                Open.url(ApplicationURL.SAUCE_DEMO.getUrl())
        );
    }

    public static Performable paraBank() {
        return application(ApplicationURL.PARA_BANK);
    }

    public static Performable google() {
        return application(ApplicationURL.GOOGLE);
    }

    public static Performable advantageOnline() {
        return application(ApplicationURL.ADVANTAGE_ONLINE);
    }

    public static Performable blazeDemo() {
        return Task.where("{0} navigates to Sauce Demo",
                Open.url(ApplicationURL.BLAZE_DEMO.getUrl())
        );
    }

    public static Performable automationExercise() {
        return application(ApplicationURL.AUTOMATION_EXERCISE);
    }

    public static Performable demoOpenCart() {
        return application(ApplicationURL.DEMO_OPENCART);
    }

    public static Performable buggyRating() {
        return application(ApplicationURL.BUGGY_RATING);
    }

    public static Performable nopCommerce(){
        return application(ApplicationURL.NOP_COMMERCE);
    }


}
