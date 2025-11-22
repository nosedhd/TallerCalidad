package co.udea.edu.certification.moduloTest.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class PurchaseFormPage {
    public static Target NAME = Target.the("campo nombre")
            .located(By.xpath("//*[@id='inputName']"));

    public static  Target DIRECTION = Target.the("campo dirección")
            .located(By.xpath("//*[@id='address']"));

    public static  Target CITY = Target.the("campo ciudad")
            .located(By.xpath("//*[@id='city']"));

    public static  Target STATE = Target.the("campo estado")
            .located(By.xpath("//*[@id='state']"));

    public static  Target ZIP_CODE = Target.the("campo código postal")
            .located(By.xpath("//*[@id='zipCode']"));

    public static  Target CARD_TYPE = Target.the("dropdown tipo de tarjeta")
            .located(By.xpath("//*[@id='cardType']"));

    public static  Target CARD_NUMBER = Target.the("campo número de tarjeta")
            .located(By.xpath("//input[@name='creditCardNumber']")); // O puedes usar: //form//input[@type='text'][@name='creditCardNumber']

    public static  Target MONT = Target.the("campo mes")
            .located(By.xpath("//*[@id='creditCardMonth']"));

    public static  Target YEAR = Target.the("campo año")
            .located(By.xpath("//*[@id='creditCardYear']"));

    public static  Target NAME_CARD = Target.the("campo nombre en la tarjeta")
            .located(By.xpath("//*[@id='nameOnCard']"));

    public static  Target PURCHASE_BUTTON = Target.the("botón para completar la compra")
            .located(By.xpath("/html/body/div[2]/form/div[11]/div/input"));

}
