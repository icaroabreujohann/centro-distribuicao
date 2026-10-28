package validators;

public final class CnpjValidator {
    private CnpjValidator() { }

    private static final String FORMATO = "\\d{14}";

    public static boolean isValido(String cnpj) {
        return cnpj != null && cnpj.matches(FORMATO);
    }
}
