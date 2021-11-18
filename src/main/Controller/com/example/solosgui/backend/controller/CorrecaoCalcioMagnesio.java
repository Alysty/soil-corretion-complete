package com.example.solosgui.backend.controller;

import com.example.solosgui.backend.model.data.FonteCalcioMagnesio;
import com.example.solosgui.backend.model.ICorrecaoNutriente;

public class CorrecaoCalcioMagnesio
        implements ICorrecaoNutriente<FonteCalcioMagnesio> {

    public double calculaQuantidadeAplicar(
        double qtdeFonteAdicionar, 
        double prntPercent) {

        if (qtdeFonteAdicionar <= 0) {
            throw new IllegalArgumentException();
        }

        if (prntPercent <= 0) {
            throw new IllegalArgumentException();
        }

        return qtdeFonteAdicionar / prntPercent;
    }
}
