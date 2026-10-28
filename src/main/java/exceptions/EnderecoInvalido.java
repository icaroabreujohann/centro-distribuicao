package exceptions;
public class EnderecoInvalido extends RuntimeException {
    public EnderecoInvalido() {
        super("Endereço não informado");
    }
}