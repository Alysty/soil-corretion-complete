package com.example.test;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Assertions;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class MainControllerTest  extends ApplicationTest {

    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../solosgui/Main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Soil Correction");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void testMethodActionTextura() {
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        Assertions.assertEquals("9.0", lookup("#fosforoIdeal").queryText().getText());
        Assertions.assertEquals("0.35", lookup("#potassioIdeal").queryText().getText());
        Assertions.assertEquals("6.0", lookup("#calcioIdeal").queryText().getText());
        Assertions.assertEquals("1.5", lookup("#magnesioIdeal").queryText().getText());
        Assertions.assertEquals("9.0", lookup("#enxofreIdeal").queryText().getText());
        Assertions.assertEquals("0.0", lookup("#aluminioIdeal").queryText().getText());
        Assertions.assertEquals("0.0", lookup("#hPlusAlIdeal").queryText().getText());
        Assertions.assertEquals("1.2", lookup("#potassioCTCAtual").queryText().getText());
        Assertions.assertEquals("44.7", lookup("#calcioCTCAtual").queryText().getText());
        Assertions.assertEquals("12.6", lookup("#magnesioCTCAtual").queryText().getText());
        Assertions.assertEquals("58.49", lookup("#vPorcentagemAtual").queryText().getText());

    }

    @Test
    void testMethodActionTexturaBecauseOfWrongInput() {
        clickOn("#texturaSolo");
        write("Wrong input").push(KeyCode.ENTER);
        Assertions.assertEquals("ERROR", lookup("#fosforoIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#potassioIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#calcioIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#magnesioIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#enxofreIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#aluminioIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#hPlusAlIdeal").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#potassioCTCAtual").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#calcioCTCAtual").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#magnesioCTCAtual").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#vPorcentagemAtual").queryText().getText());

    }
    @Test
    void testMethodButtonCalcularFosforoAction() {
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#teorFosforoAtingir").queryTextInputControl().setText("16");
        lookup("#fonteFosforo").queryTextInputControl().setText("5");
        lookup("#eficienciaFosforo").queryTextInputControl().setText("5");
        lookup("#buttonCalcularFosforo").queryButton().fire();
        Assertions.assertEquals("3.2", lookup("#quantidadeAplicarFosforo").queryText().getText());
        Assertions.assertEquals("16.0", lookup("#fosforoAposCorrecoes").queryText().getText());
        Assertions.assertEquals("16.0", lookup("#custoTotalFosforo").queryText().getText());
        Assertions.assertEquals("Nutriente1: 2.3", lookup("#primeiroNutrienteAdicionalFosforo").queryText().getText());
        Assertions.assertEquals("Nutriente2: 4.0", lookup("#segundoNutrienteAdicionalFosforo").queryText().getText());
    }

    @Test
    void testMethodButtonCalcularFosforoActionFailedBecauseOfWrongTypeOfInput() {
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#teorFosforoAtingir").queryTextInputControl().setText("Wrong Input");
        lookup("#fonteFosforo").queryTextInputControl().setText("Wrong Input");
        lookup("#eficienciaFosforo").queryTextInputControl().setText("Wrong Input");
        lookup("#buttonCalcularFosforo").queryButton().fire();
        Assertions.assertEquals("ERROR", lookup("#quantidadeAplicarFosforo").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#fosforoAposCorrecoes").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#custoTotalFosforo").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#primeiroNutrienteAdicionalFosforo").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#segundoNutrienteAdicionalFosforo").queryText().getText());
    }

    @Test
    void testMethodButtonCalcularPotassioAction() { clickOn("#texturaSolo");
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#potassioCTCDesejada").queryTextInputControl().setText("16");
        lookup("#fontePotassio").queryTextInputControl().setText("5");
        lookup("#buttonCalcularPotassio").queryButton().fire();
        Assertions.assertEquals("3.2", lookup("#quantidadeAplicarPotassio").queryText().getText());
        Assertions.assertEquals("16.0", lookup("#potassioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("16.0", lookup("#custoTotalPotassio").queryText().getText());
        Assertions.assertEquals("Nutriente1: 9.3", lookup("#primeiroNutrienteAdicionalPotassio").queryText().getText());
        Assertions.assertEquals("Nutriente2: 5.2", lookup("#segundoNutrienteAdicionalPotassio").queryText().getText());
    }
    @Test
    void testMethodButtonCalcularPotassioActionFailedBecauseOfWrongTypeOfInput() { clickOn("#texturaSolo");
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#potassioCTCDesejada").queryTextInputControl().setText("Wrong Input");
        lookup("#fontePotassio").queryTextInputControl().setText("Wrong Input");
        lookup("#buttonCalcularPotassio").queryButton().fire();
        Assertions.assertEquals("ERROR", lookup("#quantidadeAplicarPotassio").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#potassioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#custoTotalPotassio").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#primeiroNutrienteAdicionalPotassio").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#segundoNutrienteAdicionalPotassio").queryText().getText());
    }

    @Test
    void testMethodButtonCalcularCalcioMagAction() {
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#calcioCTCDesejada").queryTextInputControl().setText("60");
        lookup("#magnesioCTCDesejada").queryTextInputControl().setText("15");
        lookup("#fonteCorretivo").queryTextInputControl().setText("5");
        lookup("#pRNT").queryTextInputControl().setText("9");
        lookup("#teorCaOCorretivo").queryTextInputControl().setText("5");
        lookup("#buttonCalcularCalcioMag").queryButton().fire();

        Assertions.assertEquals("12.0", lookup("#quantidadeAplicarCalcioMag").queryText().getText());
        Assertions.assertEquals("60.0", lookup("#calcioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("15.0", lookup("#magnesioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("60.0", lookup("#custoTotalCalcioMag").queryText().getText());
        Assertions.assertEquals("9.0", lookup("#vPorcentagemAposCorrecoes").queryText().getText());
        Assertions.assertEquals("Nutriente1: 6.6", lookup("#primeiroNutrienteAdicionalCalcioMag").queryText().getText());
        Assertions.assertEquals("Nutriente2: 5.5", lookup("#segundoNutrienteAdicionalCalcioMag").queryText().getText());
    }

    @Test
    void testMethodButtonCalcularCalcioMagActionFailedBecauseOfWrongTypeOfInput() {
        clickOn("#texturaSolo");
        write("1").push(KeyCode.ENTER);
        lookup("#calcioCTCDesejada").queryTextInputControl().setText("Wrong Input");
        lookup("#magnesioCTCDesejada").queryTextInputControl().setText("Wrong Input");
        lookup("#fonteCorretivo").queryTextInputControl().setText("Wrong Input");
        lookup("#pRNT").queryTextInputControl().setText("Wrong Input");
        lookup("#teorCaOCorretivo").queryTextInputControl().setText("Wrong Input");
        lookup("#buttonCalcularCalcioMag").queryButton().fire();

        Assertions.assertEquals("ERROR", lookup("#quantidadeAplicarCalcioMag").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#calcioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#magnesioAposCorrecoes").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#custoTotalCalcioMag").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#vPorcentagemAposCorrecoes").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#primeiroNutrienteAdicionalCalcioMag").queryText().getText());
        Assertions.assertEquals("ERROR", lookup("#segundoNutrienteAdicionalCalcioMag").queryText().getText());
    }
}