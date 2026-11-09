package exceptions.pessoa;

import entities.pessoa.Pessoa;

public class PessoaException extends RuntimeException {
    public PessoaException() {
        super("A Pessoa inserida é inválida");
    }
}
