package exceptions.encomenda;

public class PesoKgException extends RuntimeException {
    public PesoKgException(double valor) {
        super("O Peso em KG é inválido: " + valor);
    }
}
