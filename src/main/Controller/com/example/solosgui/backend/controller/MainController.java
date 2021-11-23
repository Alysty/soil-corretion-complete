package com.example.solosgui;

import com.example.solosgui.backend.controller.EquilibrioCorrecaoCTC;
import com.example.solosgui.backend.model.data.NutrientesCTC;
import com.example.solosgui.backend.model.data.TexturaSolo;
import com.example.solosgui.util.exceptions.InvalidEntryException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainController {
    public TextField produto;
    public TextField municipio;
    public TextField talhao;
    public TextField data;
    public TextField lote;
    public TextField totalArea;
    public TextField areaTalhao;
    public TextField matriculaLote;
    public TextField texturaSolo;
    public TextField sistemaDeCultivo;
    public TextField responsavel;
    public TextField profundidade;

    public TextField fosforoNoSolo;
    public Text fosforoIdeal;
    public Text fosforoAposCorrecoes;

    public TextField calcioNoSolo;
    public Text calcioIdeal;
    public Text calcioAposCorrecoes;

    public TextField potassioNoSolo;
    public Text potassioIdeal;
    public Text potassioAposCorrecoes;

    public TextField magnesioNoSolo;
    public Text magnesioIdeal;
    public Text magnesioAposCorrecoes;

    public TextField enxofreNoSolo;
    public Text enxofreIdeal;
    public Text enxofreAposCorrecoes;

    public TextField aluminioNoSolo;
    public Text aluminioIdeal;
    public Text aluminioAposCorrecoes;

    public TextField hPlusAlNoSolo;
    public Text hPlusAlIdeal;
    public Text hPlusAlAposCorrecoes;

    //fosforo controller
    public TextField teorFosforoAtingir;
    public TextField fonteFosforo;
    public TextField eficienciaFosforo;
    public Text custoTotalFosforo;
    public Text quantidadeAplicarFosforo;
    public Text primeiroNutrienteAdicionalFosforo;
    public Text segundoNutrienteAdicionalFosforo;
    public Button buttonCalcularFosforo;

    //postasio controller
    public TextField potassioCTCDesejada;
    public TextField fontePotassio;
    public Text custoTotalPotassio;
    public Text potassioCTCAtual;
    public Text primeiroNutrienteAdicionalPotassio;
    public Text segundoNutrienteAdicionalPotassio;
    public Text quantidadeAplicarPotassio;
    public Button buttonCalcularPotassio;

    //calciomag controller
    public Text custoTotalCalcioMag;
    public Text calcioCTCAtual;
    public Text quantidadeAplicarCalcioMag;
    public Button buttonCalcularCalcioMag;
    public TextField fonteCorretivo;
    public TextField calcioCTCDesejada;
    public TextField pRNT;
    public TextField teorCaOCorretivo;
    public Text vPorcentagemAtual;
    public Text vPorcentagemAposCorrecoes;
    public Text primeiroNutrienteAdicionalCalcioMag;
    public Text segundoNutrienteAdicionalCalcioMag;
    public TextField magnesioCTCDesejada;
    public Text magnesioCTCAtual;


    //Util
    public EquilibrioCorrecaoCTC equilibrioCorrecaoCTC = new EquilibrioCorrecaoCTC();


    public void actionTextura(ActionEvent actionEvent) {
        try{
            texturaEscolhida();
        }catch (NumberFormatException e){
            fosforoIdeal.setText("ERROR");
            potassioIdeal.setText("ERROR");
            calcioIdeal.setText("ERROR");
            magnesioIdeal.setText("ERROR");
            enxofreIdeal.setText("ERROR");
            aluminioIdeal.setText("ERROR");
            hPlusAlIdeal.setText("ERROR");
            potassioCTCAtual.setText("ERROR");
            calcioCTCAtual.setText("ERROR");
            magnesioCTCAtual.setText("ERROR");
            vPorcentagemAtual.setText("ERROR");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Invalid input");
            errorAlert.setContentText("The input used is invalid");
            errorAlert.showAndWait();
        }catch (InvalidEntryException e){
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setHeaderText("Unavailable");
            warningAlert.setContentText("The input used is unavailable");
            warningAlert.showAndWait();
        }
    }

    public void texturaEscolhida() throws NumberFormatException, InvalidEntryException {
        NutrientesCTC chosenTextureValues = TexturaSolo.values()[Integer.parseInt(texturaSolo.getCharacters().toString())].calculaValorIdeal();
        if(chosenTextureValues != null){
            fosforoIdeal.setText(String.valueOf(chosenTextureValues.fosforo()));
            potassioIdeal.setText(String.valueOf(chosenTextureValues.potassio()));
            calcioIdeal.setText(String.valueOf(chosenTextureValues.calcio()));
            magnesioIdeal.setText(String.valueOf(chosenTextureValues.magnesio()));
            enxofreIdeal.setText(String.valueOf(chosenTextureValues.enxofre()));
            aluminioIdeal.setText(String.valueOf(chosenTextureValues.aluminio()));
            hPlusAlIdeal.setText(String.valueOf(chosenTextureValues.aluminioHidrogenio()));
            potassioCTCAtual.setText(String.valueOf(chosenTextureValues.potassio()));
            calcioCTCAtual.setText(String.valueOf(chosenTextureValues.calcio()));
            magnesioCTCAtual.setText(String.valueOf(chosenTextureValues.magnesio()));
            vPorcentagemAtual.setText(String.valueOf(equilibrioCorrecaoCTC.calculaVPercentual()));
        }else{
            throw new InvalidEntryException();
        }
    }

    public void buttonCalcularFosforoAction(ActionEvent actionEvent) {
        try{
            quantidadeAplicarFosforo.setText(String.valueOf( Double.parseDouble(teorFosforoAtingir.getCharacters().toString()) /  Double.parseDouble(fonteFosforo.getCharacters().toString())));
            fosforoAposCorrecoes.setText(String.valueOf(Double.parseDouble(teorFosforoAtingir.getText())));
            custoTotalFosforo.setText(String.valueOf(Double.parseDouble(quantidadeAplicarFosforo.getText()) * Double.parseDouble(fonteFosforo.getText())));
            primeiroNutrienteAdicionalFosforo.setText("Nutriente1: 2.3");
            segundoNutrienteAdicionalFosforo.setText("Nutriente2: 4.0");
        }catch (NumberFormatException e){
            quantidadeAplicarFosforo.setText("ERROR");
            fosforoAposCorrecoes.setText("ERROR");
            custoTotalFosforo.setText("ERROR");
            primeiroNutrienteAdicionalFosforo.setText("ERROR");
            segundoNutrienteAdicionalFosforo.setText("ERROR");
        }
    }

    public void buttonCalcularPotassioAction(ActionEvent actionEvent) {
        try{
            quantidadeAplicarPotassio.setText(String.valueOf( Double.parseDouble(potassioCTCDesejada.getCharacters().toString()) /  Double.parseDouble(fontePotassio.getCharacters().toString())));
            potassioAposCorrecoes.setText(String.valueOf(Double.parseDouble(potassioCTCDesejada.getText())));
            custoTotalPotassio.setText(String.valueOf(Double.parseDouble(quantidadeAplicarPotassio.getText()) * Double.parseDouble(fontePotassio.getText())));
            primeiroNutrienteAdicionalPotassio.setText("Nutriente1: 9.3");
            segundoNutrienteAdicionalPotassio.setText("Nutriente2: 5.2");
        }catch (NumberFormatException e){
            quantidadeAplicarPotassio.setText("ERROR");
            potassioAposCorrecoes.setText("ERROR");
            custoTotalPotassio.setText("ERROR");
            primeiroNutrienteAdicionalPotassio.setText("ERROR");
            segundoNutrienteAdicionalPotassio.setText("ERROR");
        }

    }

    public void buttonCalcularCalcioMagAction(ActionEvent actionEvent) {
        try {
            quantidadeAplicarCalcioMag.setText(String.valueOf( Double.parseDouble(calcioCTCDesejada.getCharacters().toString()) /  Double.parseDouble(teorCaOCorretivo.getCharacters().toString())));
            calcioAposCorrecoes.setText(String.valueOf(Double.parseDouble(calcioCTCDesejada.getText())));
            magnesioAposCorrecoes.setText(String.valueOf(Double.parseDouble(magnesioCTCDesejada.getText())));
            custoTotalCalcioMag.setText(String.valueOf(Double.parseDouble(quantidadeAplicarCalcioMag.getText()) * Double.parseDouble(fonteCorretivo.getText())));
            vPorcentagemAposCorrecoes.setText(String.valueOf(Double.parseDouble(pRNT.getText())));
            primeiroNutrienteAdicionalCalcioMag.setText("Nutriente1: 6.6");
            segundoNutrienteAdicionalCalcioMag.setText("Nutriente2: 5.5");
        }catch (NumberFormatException e){
            quantidadeAplicarCalcioMag.setText("ERROR");
            calcioAposCorrecoes.setText("ERROR");
            magnesioAposCorrecoes.setText("ERROR");
            custoTotalCalcioMag.setText("ERROR");
            vPorcentagemAposCorrecoes.setText("ERROR");
            primeiroNutrienteAdicionalCalcioMag.setText("ERROR");
            segundoNutrienteAdicionalCalcioMag.setText("ERROR");
        }
    }
}
