package exceptions;

public class TelefoneInvalidoException extends RuntimeException {
    private final String telefone;

    public TelefoneInvalidoException(String telefone) {
        super("Telefone inválido " + telefone);
        this.telefone = telefone;
    }
}
