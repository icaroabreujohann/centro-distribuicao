package entities.pessoa;

import enums.TipoDocumento;
import exceptions.DocumentoInvalidoException;
import exceptions.pessoa.DataNascimentoInvalidaException;
import validators.CpfValidator;
import validators.DataNascimentoValidator;

import java.time.LocalDate;

public final class  PessoaFisica extends Pessoa {
    private String cpf;
    private LocalDate dataNascimento;

    public PessoaFisica(String nome, String email, String telefone, Endereco endereco, String cpf, LocalDate dataNascimento) {
        super(nome, email, telefone, endereco);
        setCpf(cpf);
        setDataNascimento(dataNascimento);
    }

    private String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!CpfValidator.isValido(cpf)) throw new DocumentoInvalidoException(cpf, TipoDocumento.CPF);
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if(!DataNascimentoValidator.isValida(dataNascimento)) throw new DataNascimentoInvalidaException(dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String getDocumento() {
        return getCpf();
    }
}
