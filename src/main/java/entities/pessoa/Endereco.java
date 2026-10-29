package entities.pessoa;
import enums.Regiao;
import exceptions.CepInvalidoException;
import validators.CepValidator;

import java.util.Objects;

public final class Endereco {
    private String cep;
    private Regiao regiao;

    public Endereco(String cep, Regiao regiao) {
        setCep(cep);
        setRegiao(regiao);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if(!CepValidator.isValido(cep)) throw new CepInvalidoException(cep);
        this.cep = cep;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = Objects.requireNonNull(regiao, "Região não informada");
    }

    @Override
    public String toString() {
        return "CEP: " + this.cep + ", Região: " + this.regiao;
    }
}
