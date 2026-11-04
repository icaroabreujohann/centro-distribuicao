package validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CnpjValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"11222333000181", "00000000000000"})
    void deveAceitarCnpjComQuatorzeDigitos(String cnpj) {
        assertTrue(CnpjValidator.isValido(cnpj));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "11.222.333/0001-81",  // com máscara
            "1122233300018",       // 13 dígitos
            "112223330001811",     // 15 dígitos
            "abcdefghijklmn",      // letras
            "1122233300018a"       // um caractere não numérico
    })
    void deveRejeitarCnpjInvalido(String cnpj) {
        assertFalse(CnpjValidator.isValido(cnpj));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void deveRejeitarNuloOuVazio(String cnpj) {
        assertFalse(CnpjValidator.isValido(cnpj));
    }
}