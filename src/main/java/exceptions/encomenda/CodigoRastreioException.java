package exceptions.encomenda;

import entities.encomenda.CodigoRastreio;

public class CodigoRastreioException extends RuntimeException {
    public CodigoRastreioException(String mensagem) {
        super(mensagem);
    }
}
