package entities.encomenda;

import exceptions.encomenda.CodigoRastreioException;

import java.util.regex.Pattern;

public record CodigoRastreio(String valor) {
    private static final Pattern FORMATO = Pattern.compile("^[A-Z]{2}\\d{9}[A-Z]{2}$");

    public CodigoRastreio {
        if (valor == null || !FORMATO.matcher(valor).matches()) {
            throw new CodigoRastreioException(valor);
        }
    }

    @Override
    public String toString() {
        return valor;
    }
}