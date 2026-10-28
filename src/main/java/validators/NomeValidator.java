package validators;

public final class NomeValidator {
    private NomeValidator() { }

    public static boolean isValido(String nome) {
        return  nome != null && !nome.isBlank();
    }
}
