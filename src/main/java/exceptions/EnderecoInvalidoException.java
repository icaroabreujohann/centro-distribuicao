package exceptions;
public class EnderecoInvalidoException extends RuntimeException {
    public EnderecoInvalidoException() {
        super("Endereço não informado");
    }
}