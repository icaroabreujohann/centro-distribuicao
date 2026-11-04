package validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"47999998888", "(47) 99999-8888", "1234"})
    void deveAceitarTelefonePreenchido(String telefone) {
        assertTrue(TelefoneValidator.isValido(telefone));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t"})
    @NullAndEmptySource
    void deveRejeitarNuloVazioOuEmBranco(String telefone) {
        assertFalse(TelefoneValidator.isValido(telefone));
    }
}