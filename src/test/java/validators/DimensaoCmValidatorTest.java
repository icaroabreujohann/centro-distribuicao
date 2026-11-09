package validators;

import entities.encomenda.Dimensao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DimensaoCmValidatorTest {

    @ParameterizedTest
    @ValueSource(doubles = { -1.5, 501})
    void deveRejeitarValorInvalido(double valor){
        assertFalse(DimensaoCmValidator.isValido(valor));
    }

    @Test
    void deveRetornarVolumeEmM3() {
        // 100cm x 100cm x 100cm = 1.000.000 cm³ = 1 m³
        Dimensao dimensao = new Dimensao(100, 100, 100);
        assertEquals(1.0, dimensao.getVolumeM3(), 0.0001);
    }
}
