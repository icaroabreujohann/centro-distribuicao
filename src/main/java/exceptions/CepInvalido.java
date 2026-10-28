package exceptions;

public class CepInvalido extends RuntimeException {

    private final String cep;

    public CepInvalido(String cep) {
        super("CEP invalido: " + cep);
        this.cep = cep;
    }
}
