package exceptions;

public class EmailInvalido extends RuntimeException {
  public EmailInvalido(String message) {
    super(message);
  }
}
