package exceptions;

public class EnderecoInvalido extends RuntimeException {
  public EnderecoInvalido(String message) {
    super(message);
  }
}
