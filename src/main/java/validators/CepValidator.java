package validators;

public final class CepValidator {

    private CepValidator() { }

    private static final String FORMATO = "\\d{8}";

    public static boolean isValido(String cep) {
        return cep != null && cep.matches(FORMATO);
    }

}
