package co.udea.edu.certification.moduloTest.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import java.util.List;

public class ResultsTablePage {
    public static List<Target> Select_Button = List.of(
            Target.the("Botón seleccionar vuelo 1").located(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[1]/input")),
            Target.the("Botón seleccionar vuelo 2").located(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]/input")),
            Target.the("Botón seleccionar vuelo 3").located(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[1]/input")),
            Target.the("Botón seleccionar vuelo 4").located(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[1]/input")),
            Target.the("Botón seleccionar vuelo 5").located(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[1]/input"))
    );

    public static List<Target> Flight_Prices = List.of(
            Target.the("Precio vuelo 1").located(By.xpath("/html/body/div[2]/table/tbody/tr[1]/td[6]")),
            Target.the("Precio vuelo 2").located(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[6]")),
            Target.the("Precio vuelo 3").located(By.xpath("/html/body/div[2]/table/tbody/tr[3]/td[6]")),
            Target.the("Precio vuelo 4").located(By.xpath("/html/body/div[2]/table/tbody/tr[4]/td[6]")),
            Target.the("Precio vuelo 5").located(By.xpath("/html/body/div[2]/table/tbody/tr[5]/td[6]"))
    );
}
