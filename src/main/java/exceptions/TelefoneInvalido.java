package exceptions;

public class TelefoneInvalido extends RuntimeException {
    private final String telefone;

    public TelefoneInvalido(String telefone) {
        super("Telefone inválido " + telefone);
        this.telefone = telefone;
    }
}
