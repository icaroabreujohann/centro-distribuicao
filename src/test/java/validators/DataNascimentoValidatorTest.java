package validators;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DataNascimentoValidatorTest {

    @Test
    void deveRejeitarNulo() {
        assertFalse(DataNascimentoValidator.isValida(null));
    }

    @Test
    void deveAceitarDataDeHoje() {
        assertTrue(DataNascimentoValidator.isValida(LocalDate.now()));
    }

    @Test
    void deveAceitarDataPassadaComum() {
        assertTrue(DataNascimentoValidator.isValida(LocalDate.now().minusYears(30)));
    }

    @Test
    void deveRejeitarDataFutura() {
        assertFalse(DataNascimentoValidator.isValida(LocalDate.now().plusDays(1)));
    }

    @Test
    void deveAceitarExatamenteIdadeMaxima() {
        assertTrue(DataNascimentoValidator.isValida(LocalDate.now().minusYears(200)));
    }

    @Test
    void deveRejeitarMaisVelhoQueIdadeMaxima() {
        assertFalse(DataNascimentoValidator.isValida(LocalDate.now().minusYears(200).minusDays(1)));
    }

    @Test
    void deveAceitarUmDiaAntesDoLimiteSuperior() {
        assertTrue(DataNascimentoValidator.isValida(LocalDate.now().minusDays(1)));
    }
}