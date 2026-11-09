package entities.encomenda;

import exceptions.encomenda.DimensaoCmException;
import validators.DimensaoCmValidator;

public class Dimensao {
    private double larguraCm;
    private double alturaCm;
    private double profunidadeCm;

    private static final double CM3_POR_M3 = 1_000_000.0;

    public Dimensao(double larguraCm, double alturaCm, double profunidadeCm) {
        setLarguraCm(larguraCm);
        setAlturaCm(alturaCm);
        setProfunidadeCm(profunidadeCm);
    }

    private void setLarguraCm(double larguraCm) {
        if (!DimensaoCmValidator.isValido(larguraCm)) throw new DimensaoCmException(larguraCm);
        this.larguraCm = larguraCm;
    }

    private void setAlturaCm(double alturaCm) {
        if (!DimensaoCmValidator.isValido(alturaCm)) throw new DimensaoCmException(alturaCm);
        this.alturaCm = alturaCm;
    }

    private void setProfunidadeCm(double profunidadeCm) {
        if (!DimensaoCmValidator.isValido(profunidadeCm)) throw new DimensaoCmException(profunidadeCm);
        this.profunidadeCm = profunidadeCm;
    }

    private double getLarguraCm() {
        return larguraCm;
    }

    private double getAlturaCm() {
        return alturaCm;
    }

    private double getProfunidadeCm() {
        return profunidadeCm;
    }

    public double getVolumeM3() {
        return (getLarguraCm() * getAlturaCm() * getProfunidadeCm() / CM3_POR_M3);
    }
}
