package utils.encomenda;

import entities.encomenda.Dimensao;
import enums.Servico;
import enums.TipoEncomenda;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CalculadoraFrete {
    private static final double FATOR_CUBAGEM_KG_POR_M3 = 300.0;
    private static final BigDecimal TARIFA_BASE = new BigDecimal("8.00");
    private static final BigDecimal PRECO_POR_KG = new BigDecimal("2.50");
    private static final BigDecimal PERCENTUAL_SEGURO = new BigDecimal("0.01");

    private CalculadoraFrete() {}

    public static BigDecimal calcular(Servico servico, TipoEncomenda tipo, double pesoKg,
                                      Dimensao dimensao, BigDecimal valorDeclarado) {
        BigDecimal pesoTarifavel = pesoTarifavel(pesoKg, dimensao);

        BigDecimal frete = TARIFA_BASE
                .add(pesoTarifavel.multiply(PRECO_POR_KG))
                .multiply(multiplicador(servico))
                .multiply(multiplicador(tipo))
                .add(valorDeclarado.multiply(PERCENTUAL_SEGURO));

        return frete.setScale(2, RoundingMode.HALF_UP);
    }

    private static BigDecimal pesoTarifavel(double pesoKg, Dimensao dimensao) {
        double pesoCubado = dimensao.getVolumeM3() * FATOR_CUBAGEM_KG_POR_M3;
        return BigDecimal.valueOf(Math.max(pesoKg, pesoCubado));
    }

    private static BigDecimal multiplicador(Servico servico) {
        return switch (servico) {
            case ECONOMICO -> new BigDecimal("1.00");
            case EXPRESSO  -> new BigDecimal("1.80");
            case AGENDADO  -> new BigDecimal("1.30");
        };
    }

    private static BigDecimal multiplicador(TipoEncomenda tipo) {
        return switch (tipo) {
            case COMUM          -> new BigDecimal("1.00");
            case FRAGIL         -> new BigDecimal("1.25");
            case PERECIVEL      -> new BigDecimal("1.40");
            case CARGA_VOLUMOSA -> new BigDecimal("1.50");
        };
    }
}