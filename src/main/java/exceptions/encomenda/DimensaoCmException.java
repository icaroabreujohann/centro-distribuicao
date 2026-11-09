package exceptions.encomenda;

public class DimensaoCmException extends RuntimeException {
    public DimensaoCmException(double valor) {
        super("Valor Invalido: " + valor);
    }
}
