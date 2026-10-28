package validators;

public final class TelefoneValidator {
    private TelefoneValidator() { }

        public static boolean isValido(String telefone) {
            return  telefone != null && !telefone.isBlank();
        }
}
