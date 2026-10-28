package exceptions;

public class DocumentoInvalido extends RuntimeException {

    private final String documento;

    public DocumentoInvalido(String documento) {
        super("Documento inválido: " + documento);
        this.documento = documento;
    }
}
