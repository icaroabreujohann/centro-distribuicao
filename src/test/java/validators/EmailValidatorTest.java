package validators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "user@dominio.com",
            "nome.sobrenome@empresa.com.br",
            "user+tag@dominio.org",
            "user_name-1@sub.dominio.io"
    })
    void deveAceitarEmailValido(String email) {
        assertTrue(EmailValidator.isValido(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "semarroba.com",
            "@dominio.com",         // sem parte local
            "user@",                // sem domínio
            "user@dominio",         // sem TLD
            "user@dominio.c",       // TLD com 1 letra
            "user @dominio.com",    // espaço
            "user@@dominio.com",    // dois @
            "user@dominio.com "     // espaço no fim
    })
    void deveRejeitarEmailInvalido(String email) {
        assertFalse(EmailValidator.isValido(email));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void deveRejeitarNuloOuVazio(String email) {
        assertFalse(EmailValidator.isValido(email));
    }
}