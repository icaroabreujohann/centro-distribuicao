package utils.encomenda;

import entities.encomenda.CodigoRastreio;

public final class GeradorCodigoRastreio {
    private static final String PREFIXO = "AA";
    private static final String SUFIXO = "BR";
    private static final long MAXIMO = 999_999_999L;

    private long sequencial = 0;

    public CodigoRastreio proximo() {
        if (sequencial >= MAXIMO) throw new IllegalStateException("Sequência esgotada");
        sequencial++;
        return new CodigoRastreio(PREFIXO + String.format("%09d", sequencial) + SUFIXO);
    }
}