package exceptions;

public class CepInvalidoException extends RuntimeException {

    private final String cep;

    public CepInvalidoException(String cep) {
        super("CEP invalido: " + cep);
        this.cep = cep;
    }
}
