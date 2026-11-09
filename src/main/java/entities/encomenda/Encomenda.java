package entities.encomenda;

import entities.pessoa.Pessoa;
import enums.Servico;
import enums.TipoEncomenda;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Deque;

public class Encomenda {
    private String codigoRastreio;
    private Pessoa remetente;
    private Pessoa destinatario;
    private TipoEncomenda tipoEncomenda;
    private Servico servico;
    private BigDecimal valorDeclarado;
    private BigDecimal valorFrete;
    private double pesoKg;
    private Dimensao dimensao;
    private Instant dataCriacao;
    private Deque<EventoRastreio> eventos;

}
