package validators.encomenda;
import java.util.regex.Pattern;

public final class CodigoRastreioValidator {
    private static final Pattern FORMATO = Pattern.compile("^[A-Z]{2}\\d{9}[A-Z]{2}$");

    private CodigoRastreioValidator() {}

    public static boolean isValido(String codigo) {
        return codigo != null && FORMATO.matcher(codigo).matches();
    }
}