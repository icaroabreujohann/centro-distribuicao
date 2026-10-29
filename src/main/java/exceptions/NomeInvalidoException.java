package exceptions;

public class NomeInvalidoException extends RuntimeException {

    private final String nome;

    public NomeInvalidoException(String nome) {
        super("Nome inválido " + nome);
        this.nome = nome;
    }
}
