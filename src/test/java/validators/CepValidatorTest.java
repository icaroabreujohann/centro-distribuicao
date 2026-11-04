package validators;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CepValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"89120000", "00000000", "12345678"})
    void deveAceitarCepComOitoDigitos(String cep) {
        assertTrue(CepValidator.isValido(cep));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "89120-000",   // com máscara
            "1234567",     // 7 dígitos
            "123456789",   // 9 dígitos
            "abcdefgh",    // letras
            "8912 000",    // espaço
            " 89120000",   // espaço no início
            "89120000\n"   // quebra de linha no fim
    })
    void deveRejeitarCepInvalido(String cep) {
        assertFalse(CepValidator.isValido(cep));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void deveRejeitarNuloOuVazio(String cep) {
        assertFalse(CepValidator.isValido(cep));
    }
}