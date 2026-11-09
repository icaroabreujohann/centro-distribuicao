package validators;

public final class DimensaoCmValidator {
    private DimensaoCmValidator() {}

    public static boolean isValido(double valor){
        return valor > 0 && valor <= 500;
    }
}
