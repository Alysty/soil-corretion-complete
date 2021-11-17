package com.example.solosgui.backend;

public interface ICorrecaoNutrienteQuantidadeAplicar<T extends IFonteNutriente> {

    public default double calculaQuantidadeAplicar(
            double necessidade,
            T fonteNutriente) {

        if (necessidade <= 0) {
            throw new IllegalArgumentException();
        }

        return necessidade / fonteNutriente.getTeorFonte();
    }
}
