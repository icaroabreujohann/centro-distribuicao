package validators.encomenda;

import java.math.BigDecimal;

public final class ValorMonetarioValidator {
    private ValorMonetarioValidator() {}

    public static boolean isValido(BigDecimal valor) {
        return valor != null && valor.compareTo(BigDecimal.ZERO) >= 0;
    }
}
