package exceptions;

import enums.TipoDocumento;

public class DocumentoInvalidoException extends RuntimeException {

    private final String documento;
    private final TipoDocumento tipoDocumento;

    public DocumentoInvalidoException(String documento, TipoDocumento tipoDocumento) {
        super(tipoDocumento.name() + " inválido: " + documento);
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() { return documento; }
    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
}
