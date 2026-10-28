package exeptions;

public class CepInvalido extends RuntimeException {
    public CepInvalido(String message) {
        super(message);
    }
}
