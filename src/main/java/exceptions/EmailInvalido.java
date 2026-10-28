package exceptions;

public class EmailInvalido extends RuntimeException {

    private final String email;

    public EmailInvalido(String email) {
        super("Email inválido " + email);
        this.email = email;
    }
}
