package exceptions.encomenda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValorMonetarioException extends RuntimeException {
    public ValorMonetarioException(BigDecimal valor) {
        super("O valor " + valor + " é inválido");
    }
}
