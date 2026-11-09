package entities.encomenda;

import entities.pessoa.Pessoa;
import enums.Servico;
import enums.TipoEncomenda;
import exceptions.encomenda.PesoKgException;
import exceptions.encomenda.ValorMonetarioException;
import exceptions.pessoa.PessoaException;
import utils.encomenda.CalculadoraFrete;
import validators.encomenda.PesoKgValidator;
import validators.encomenda.ValorMonetarioValidator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Encomenda {
    private final CodigoRastreio codigoRastreio;
    private Pessoa remetente;
    private Pessoa destinatario;
    private TipoEncomenda tipoEncomenda;
    private Servico servico;
    private BigDecimal valorDeclarado;
    private BigDecimal valorFrete;
    private double pesoKg;
    private Dimensao dimensao;
    private final Instant dataCriacao;
    private final Deque<EventoRastreio> eventos;

    public Encomenda(CodigoRastreio codigoRastreio, Pessoa remetente, Pessoa destinatario,
                     TipoEncomenda tipoEncomenda, Servico servico, BigDecimal valorDeclarado,
                     double pesoKg, double larguraCm, double alturaCm, double profundidadeCm) {
        this.codigoRastreio = Objects.requireNonNull(codigoRastreio, "Código de rastreio não pode ser nulo");
        setRemetente(remetente);
        setDestinatario(destinatario);
        setTipoEncomenda(tipoEncomenda);
        setServico(servico);
        setValorDeclarado(valorDeclarado);
        setPesoKg(pesoKg);
        setDimensao(new Dimensao(larguraCm, alturaCm, profundidadeCm));

        this.dataCriacao = Instant.now();
        this.eventos = new ArrayDeque<>();

        this.valorFrete = CalculadoraFrete.calcular(servico, tipoEncomenda, pesoKg, dimensao, valorDeclarado);
    }

    private void setRemetente(Pessoa remetente) {
        if (Objects.isNull(remetente)) throw new PessoaException();
        this.remetente = remetente;
    }

    private void setDestinatario(Pessoa destinatario) {
        if (Objects.isNull(destinatario)) throw new PessoaException();
        this.destinatario = destinatario;
    }

    private void setTipoEncomenda(TipoEncomenda tipoEncomenda) {
        this.tipoEncomenda = Objects.requireNonNull(tipoEncomenda, "Tipo de encomenda não pode ser nulo");
    }

    private void setServico(Servico servico) {
        this.servico = Objects.requireNonNull(servico, "Serviço não pode ser nulo");
    }

    private void setValorDeclarado(BigDecimal valorDeclarado) {
        if (!ValorMonetarioValidator.isValido(valorDeclarado)) throw new ValorMonetarioException(valorDeclarado);
        this.valorDeclarado = valorDeclarado;
    }

    private void setPesoKg(double pesoKg) {
        if (!PesoKgValidator.isValido(pesoKg)) throw new PesoKgException(pesoKg);
        this.pesoKg = pesoKg;
    }

    private void setDimensao(Dimensao dimensao) {
        this.dimensao = Objects.requireNonNull(dimensao, "Dimensão não pode ser nula");
    }

    public void adicionarEvento(EventoRastreio evento) {
        eventos.addLast(Objects.requireNonNull(evento, "Evento não pode ser nulo"));
    }

    public CodigoRastreio getCodigoRastreio() { return codigoRastreio; }
    public Pessoa getRemetente() { return remetente; }
    public Pessoa getDestinatario() { return destinatario; }
    public TipoEncomenda getTipoEncomenda() { return tipoEncomenda; }
    public Servico getServico() { return servico; }
    public BigDecimal getValorDeclarado() { return valorDeclarado; }
    public BigDecimal getValorFrete() { return valorFrete; }
    public double getPesoKg() { return pesoKg; }
    public Dimensao getDimensao() { return dimensao; }
    public Instant getDataCriacao() { return dataCriacao; }

    public Deque<EventoRastreio> getEventos() {
        return new ArrayDeque<>(eventos);
    }
}