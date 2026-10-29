package exceptions;

public class EmailInvalidoException extends RuntimeException {

    private final String email;

    public EmailInvalidoException(String email) {
        super("Email inválido " + email);
        this.email = email;
    }
}
