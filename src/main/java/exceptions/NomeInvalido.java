package exceptions;

public class NomeInvalido extends RuntimeException {

    private final String nome;

    public NomeInvalido(String nome) {
        super("Nome inválido " + nome);
        this.nome = nome;
    }
}
