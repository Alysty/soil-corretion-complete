package com.example.solosgui.backend.model.data;

import lombok.Builder;

import java.util.Objects;

@Builder
public final class NutrientesCTC {
    private final double fosforo;
    private final double potassio;
    private final double calcio;
    private final double magnesio;
    private final double enxofre;
    private final double aluminio;
    private final double aluminioHidrogenio;

    NutrientesCTC(
            double fosforo,
            double potassio,
            double calcio,
            double magnesio,
            double enxofre,
            double aluminio,
            double aluminioHidrogenio) {
        this.fosforo = fosforo;
        this.potassio = potassio;
        this.calcio = calcio;
        this.magnesio = magnesio;
        this.enxofre = enxofre;
        this.aluminio = aluminio;
        this.aluminioHidrogenio = aluminioHidrogenio;
    }

    public double fosforo() {
        return fosforo;
    }

    public double potassio() {
        return potassio;
    }

    public double calcio() {
        return calcio;
    }

    public double magnesio() {
        return magnesio;
    }

    public double enxofre() {
        return enxofre;
    }

    public double aluminio() {
        return aluminio;
    }

    public double aluminioHidrogenio() {
        return aluminioHidrogenio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NutrientesCTC) obj;
        return Double.doubleToLongBits(this.fosforo) == Double.doubleToLongBits(that.fosforo) &&
                Double.doubleToLongBits(this.potassio) == Double.doubleToLongBits(that.potassio) &&
                Double.doubleToLongBits(this.calcio) == Double.doubleToLongBits(that.calcio) &&
                Double.doubleToLongBits(this.magnesio) == Double.doubleToLongBits(that.magnesio) &&
                Double.doubleToLongBits(this.enxofre) == Double.doubleToLongBits(that.enxofre) &&
                Double.doubleToLongBits(this.aluminio) == Double.doubleToLongBits(that.aluminio) &&
                Double.doubleToLongBits(this.aluminioHidrogenio) == Double.doubleToLongBits(that.aluminioHidrogenio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fosforo, potassio, calcio, magnesio, enxofre, aluminio, aluminioHidrogenio);
    }

    @Override
    public String toString() {
        return "NutrientesCTC[" +
                "fosforo=" + fosforo + ", " +
                "potassio=" + potassio + ", " +
                "calcio=" + calcio + ", " +
                "magnesio=" + magnesio + ", " +
                "enxofre=" + enxofre + ", " +
                "aluminio=" + aluminio + ", " +
                "aluminioHidrogenio=" + aluminioHidrogenio + ']';
    }
}
