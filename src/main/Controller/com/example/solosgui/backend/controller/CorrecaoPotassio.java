package com.example.solosgui.backend.controller;

import com.example.solosgui.backend.model.data.FontePotassio;
import com.example.solosgui.backend.model.ICorrecaoNutriente;
import com.example.solosgui.backend.model.ICorrecaoNutrienteQuantidadeAplicar;

public class CorrecaoPotassio
        implements
        ICorrecaoNutriente<FontePotassio>,
        ICorrecaoNutrienteQuantidadeAplicar<FontePotassio> {

    public double calculaNecessidadeAdicionarCMolcDm3 (
        double teorSolo,
        double participacaoCTCExistente,
        double participacaoCTCDesejada) {

            if (teorSolo <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCExistente <= 0) {
                throw new IllegalArgumentException();
            }

            if (participacaoCTCDesejada <= 0) {
                throw new IllegalArgumentException();
            }

            return (teorSolo 
                    * participacaoCTCDesejada 
                    / participacaoCTCExistente) 
                    - teorSolo;
    }

}
