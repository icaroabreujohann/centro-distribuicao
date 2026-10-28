package validators;

public final class CpfValidator {
    private CpfValidator() { }

    private static final String FORMATO = "\\d{11}";

    public static boolean isValido(String cpf) {
        return cpf != null && cpf.matches(FORMATO);
    }
}
