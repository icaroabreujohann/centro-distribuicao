package exceptions.pessoa;

import java.time.LocalDate;

public class DataNascimentoInvalidaException extends RuntimeException {

    private final LocalDate dataNascimento;

    public DataNascimentoInvalidaException(LocalDate dataNascimento) {
        super("Data de nascimento inválida: " + dataNascimento);
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() { return dataNascimento; }
}