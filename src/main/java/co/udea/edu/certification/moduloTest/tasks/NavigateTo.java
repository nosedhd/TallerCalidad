package co.udea.edu.certification.moduloTest.tasks;

import co.udea.edu.certification.moduloTest.config.ApplicationURL ;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;


public class NavigateTo {

    public static Performable application(ApplicationURL app) {
        return Task.where("{0} navigates to " + app.getName(),
                Open.url(app.getUrl())
        );
    }

    public static Performable blazeDemo() {
        return Task.where("{0} navigates to Sauce Demo",
                Open.url(ApplicationURL.BLAZE_DEMO.getUrl())
        );
    }

    // Métodos específicos para facilidad de uso





}
