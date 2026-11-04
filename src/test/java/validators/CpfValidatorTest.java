package validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CpfValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"52998224725", "00000000000"})
    void deveAceitarCpfComOnzeDigitos(String cpf) {
        // Observação: hoje só o formato é validado, não o dígito verificador
        assertTrue(CpfValidator.isValido(cpf));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "529.982.247-25",  // com máscara
            "5299822472",      // 10 dígitos
            "529982247255",    // 12 dígitos
            "abcdefghijk",     // letras
            "5299822472a"      // um caractere não numérico
    })
    void deveRejeitarCpfInvalido(String cpf) {
        assertFalse(CpfValidator.isValido(cpf));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void deveRejeitarNuloOuVazio(String cpf) {
        assertFalse(CpfValidator.isValido(cpf));
    }
}