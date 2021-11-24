package com.example.solosgui.backend.controller;

import com.example.solosgui.backend.model.NutrienteAdicional;
import com.example.solosgui.backend.model.data.FonteFosforo;
import com.example.solosgui.backend.model.data.FontePotassio;
import com.example.solosgui.backend.model.data.NutrientesCTC;
import com.example.solosgui.backend.model.data.TexturaSolo;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Set;

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
    public TextField valorTonFosforoTextField;

    //postasio controller
    public TextField potassioCTCDesejada;
    public TextField fontePotassio;
    public Text custoTotalPotassio;
    public Text potassioCTCAtual;
    public Text primeiroNutrienteAdicionalPotassio;
    public Text segundoNutrienteAdicionalPotassio;
    public Text quantidadeAplicarPotassio;
    public Button buttonCalcularPotassio;
    public TextField valorTonPotassioTextField;

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
        }catch (ArrayIndexOutOfBoundsException e){
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setHeaderText("Unavailable");
            warningAlert.setContentText("The input used is unavailable");
            warningAlert.showAndWait();
        }
    }

    public void texturaEscolhida() throws NumberFormatException, ArrayIndexOutOfBoundsException{
        NutrientesCTC chosenTextureValues = TexturaSolo.values()[Integer.parseInt(texturaSolo.getCharacters().toString())].calculaValorIdeal();
        fosforoIdeal.setText(String.valueOf(chosenTextureValues.fosforo()));
        potassioIdeal.setText(String.valueOf(chosenTextureValues.potassio()));
        calcioIdeal.setText(String.valueOf(chosenTextureValues.calcio()));
        magnesioIdeal.setText(String.valueOf(chosenTextureValues.magnesio()));
        enxofreIdeal.setText(String.valueOf(chosenTextureValues.enxofre()));
        aluminioIdeal.setText(String.valueOf(chosenTextureValues.aluminio()));
        hPlusAlIdeal.setText(String.valueOf(chosenTextureValues.aluminioHidrogenio()));

        calcioCTCAtual.setText(String.valueOf(chosenTextureValues.calcio()));
        magnesioCTCAtual.setText(String.valueOf(chosenTextureValues.magnesio()));
        double sCmol = equilibrioCorrecaoCTC.calculaSCmol(chosenTextureValues.potassio(),chosenTextureValues.calcio(),chosenTextureValues.magnesio());
        double cTCCmol = equilibrioCorrecaoCTC.calculaCTCCmol(chosenTextureValues.potassio(),chosenTextureValues.calcio(),chosenTextureValues.magnesio(),chosenTextureValues.aluminioHidrogenio());
        vPorcentagemAtual.setText(String.valueOf(equilibrioCorrecaoCTC.calculaVPercentual(sCmol,cTCCmol)));


    }

    public void buttonCalcularFosforoAction(ActionEvent actionEvent) {
        CorrecaoFosforo correcaoFosforo = new CorrecaoFosforo();
        ConverteMgDm3EmKgHa converteMgDm3EmKgHa = new ConverteMgDm3EmKgHa();
        ConverteKgHaEmP2O5 converteKgHaEmP2O5 = new ConverteKgHaEmP2O5();
        try{
            FonteFosforo chosenFonteFosforo = FonteFosforo.values()[Integer.parseInt(fonteFosforo.getCharacters().toString())-1];
            double necessiade  =
                    converteKgHaEmP2O5.converte(
                            converteMgDm3EmKgHa.converte(
                                    Double.parseDouble(teorFosforoAtingir.getText())
                                            - Double.parseDouble(fosforoNoSolo.getText())
                            )
                    ) * 100/Double.parseDouble(eficienciaFosforo.getText())
                    ;
            quantidadeAplicarFosforo
                    .setText(String.valueOf(
                            correcaoFosforo
                                .calculaQuantidadeAplicar(
                                        necessiade,
                                        chosenFonteFosforo
                                )
                            )
                    );
            fosforoAposCorrecoes.setText(String.valueOf(teorFosforoAtingir.getText()));
            custoTotalFosforo.setText(String.valueOf(correcaoFosforo.calculaCusto(
                    Double.parseDouble(valorTonFosforoTextField.getText())
                    ,Double.parseDouble(quantidadeAplicarFosforo.getText()))
            ));

            Set<NutrienteAdicional> nutrientesAdicionais = correcaoFosforo.getNutrientesAdicionais(Double.parseDouble(quantidadeAplicarFosforo.getText()), chosenFonteFosforo);
            Iterator<NutrienteAdicional> iteratorNutrientes = nutrientesAdicionais.iterator();
            if(iteratorNutrientes.hasNext()){
                NutrienteAdicional nutrienteAdicional = iteratorNutrientes.next();
                primeiroNutrienteAdicionalFosforo.setText(nutrienteAdicional.getNome().toString() +
                        ": " + new DecimalFormat().format(nutrienteAdicional.getCorrecaoAdicional()));
            }if(iteratorNutrientes.hasNext()){
                NutrienteAdicional nutrienteAdicional = iteratorNutrientes.next();
                segundoNutrienteAdicionalFosforo.setText(nutrienteAdicional.getNome().toString() +
                        ": " + new DecimalFormat().format(nutrienteAdicional.getCorrecaoAdicional()));
            }
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e){
            quantidadeAplicarFosforo.setText("ERROR");
            fosforoAposCorrecoes.setText("ERROR");
            custoTotalFosforo.setText("ERROR");
            primeiroNutrienteAdicionalFosforo.setText("ERROR");
            segundoNutrienteAdicionalFosforo.setText("ERROR");
        }
    }

    public void buttonCalcularPotassioAction(ActionEvent actionEvent) {
        try{
            CorrecaoPotassio correcaoPotassio = new CorrecaoPotassio();
            FontePotassio chosenFontePotassio = FontePotassio.values()[Integer.parseInt(fontePotassio.getCharacters().toString())-1];
            ConverteCMolcDm3EmMgDm3  converteCMolcDm3EmMgDm3 = new ConverteCMolcDm3EmMgDm3();
            ConverteMgDm3EmKgHa converteMgDm3EmKgHa = new ConverteMgDm3EmKgHa();
            ConverteKgHaEmK2O converteKgHaEmK2O = new ConverteKgHaEmK2O();
            double efficiency = 0.85;
            Double potassioCTCAtualResult = Double.parseDouble(potassioNoSolo.getText())/
                    (Double.parseDouble(calcioNoSolo.getText()) +
                            Double.parseDouble(magnesioNoSolo.getText()) +
                            Double.parseDouble(potassioNoSolo.getText())+
                            Double.parseDouble(hPlusAlNoSolo.getText()))
                    *100;

            Double kToAdd = ( Double.parseDouble(potassioNoSolo.getText())*
                    Double.parseDouble(potassioCTCDesejada.getText())/
                    potassioCTCAtualResult)-
                    Double.parseDouble(potassioNoSolo.getText());

            double a  = (converteKgHaEmK2O.converte(converteMgDm3EmKgHa.converte(converteCMolcDm3EmMgDm3.converte(kToAdd)))*100 / efficiency / 100);
            quantidadeAplicarPotassio.setText(
                    String.valueOf(
                            (a*100/ chosenFontePotassio.getTeorFonte())/100));

            potassioCTCAtual.setText(String.valueOf(potassioCTCAtualResult));

            potassioAposCorrecoes.setText(String.valueOf(Double.parseDouble(potassioCTCDesejada.getText())));
            custoTotalPotassio.setText(String.valueOf(correcaoPotassio.calculaCusto(
                    Double.parseDouble(valorTonPotassioTextField.getText())
                    ,Double.parseDouble(quantidadeAplicarPotassio.getText()))
            ));

            Set<NutrienteAdicional> nutrientesAdicionais = correcaoPotassio.getNutrientesAdicionais(Double.parseDouble(quantidadeAplicarPotassio.getText()), chosenFontePotassio);
            Iterator<NutrienteAdicional> iteratorNutrientes = nutrientesAdicionais.iterator();
            if(iteratorNutrientes.hasNext()){
                NutrienteAdicional nutrienteAdicional = iteratorNutrientes.next();
                primeiroNutrienteAdicionalPotassio.setText(nutrienteAdicional.getNome().toString() +
                        ": " + new DecimalFormat().format(nutrienteAdicional.getCorrecaoAdicional()));
            }if(iteratorNutrientes.hasNext()){
                NutrienteAdicional nutrienteAdicional = iteratorNutrientes.next();
                segundoNutrienteAdicionalPotassio.setText(nutrienteAdicional.getNome().toString() +
                        ": " + new DecimalFormat().format(nutrienteAdicional.getCorrecaoAdicional()));
            }
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
