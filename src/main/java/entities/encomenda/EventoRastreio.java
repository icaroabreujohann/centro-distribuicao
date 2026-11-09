package entities.encomenda;

import enums.StatusEncomenda;

import java.time.Instant;

public class EventoRastreio {
    private StatusEncomenda statusEncomenda;
    private Instant dataHora;
    private String local;

    public EventoRastreio(StatusEncomenda statusEncomenda, Instant dataHora, String local) {
        setStatusEncomenda(statusEncomenda);
        setDataHora(dataHora);
        setLocal(local);
    }

    public StatusEncomenda getStatusEncomenda() {
        return statusEncomenda;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setStatusEncomenda(StatusEncomenda statusEncomenda) {
        this.statusEncomenda = statusEncomenda;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
