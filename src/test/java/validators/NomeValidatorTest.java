package validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NomeValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ícaro", "Maria da Silva", "A"})
    void deveAceitarNomePreenchido(String nome) {
        assertTrue(NomeValidator.isValido(nome));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @NullAndEmptySource
    void deveRejeitarNuloVazioOuEmBranco(String nome) {
        assertFalse(NomeValidator.isValido(nome));
    }
}