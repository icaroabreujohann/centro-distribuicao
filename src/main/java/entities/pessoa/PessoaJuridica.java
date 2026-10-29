package entities.pessoa;

import enums.TipoDocumento;
import exceptions.DocumentoInvalidoException;
import validators.CnpjValidator;

public final class PessoaJuridica extends Pessoa {
    private String cnpj;

    public PessoaJuridica(String nome, String email, String telefone, Endereco endereco, String cnpj) {
        super(nome, email, telefone, endereco);
        setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        if(!CnpjValidator.isValido(cnpj)) throw new DocumentoInvalidoException(cnpj, TipoDocumento.CNPJ);
        this.cnpj = cnpj;
    }

    @Override
    public String getDocumento() {
        return getCnpj();
    }
}

