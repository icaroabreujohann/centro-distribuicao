package validators.encomenda;

public final class PesoKgValidator {
    private static final double PESO_MAXIMO_KG = 50.0;

    private PesoKgValidator() {}

    public static boolean isValido(double valor) {
        return Double.isFinite(valor) && valor > 0 && valor <= PESO_MAXIMO_KG;
    }
}