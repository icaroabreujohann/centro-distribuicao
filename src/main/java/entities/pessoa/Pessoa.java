package entities.pessoa;

import exceptions.EmailInvalidoException;
import exceptions.EnderecoInvalidoException;
import exceptions.NomeInvalidoException;
import exceptions.TelefoneInvalidoException;
import validators.EmailValidator;
import validators.NomeValidator;
import validators.TelefoneValidator;

public abstract sealed class Pessoa permits PessoaFisica, PessoaJuridica {
    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;

    protected Pessoa(String nome, String email, String telefone, Endereco endereco) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        if (!NomeValidator.isValido(nome)) throw new NomeInvalidoException(nome);
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public final void setEmail(String email) {
        if(!EmailValidator.isValido(email)) throw new EmailInvalidoException(email);
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public final void setTelefone(String telefone) {
        if(!TelefoneValidator.isValido(telefone)) throw new TelefoneInvalidoException(telefone);
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco == null) throw new EnderecoInvalidoException();
        this.endereco = endereco;
    }

    public abstract String getDocumento();
}
