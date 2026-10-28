package validators;

public final class EmailValidator {
    private EmailValidator() { }

    private static final String FORMATO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValido(String email) {
        return email != null && email.matches(FORMATO);
    }
}
