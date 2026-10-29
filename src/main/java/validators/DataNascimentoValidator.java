package validators;

import java.time.LocalDate;

public final class DataNascimentoValidator {
    private DataNascimentoValidator() { }

    private static final int IDADE_MAXIMA = 200;

    public static boolean isValida(LocalDate dataNascimento) {
        if (dataNascimento == null) return false;

        LocalDate hoje = LocalDate.now();

        return !dataNascimento.isAfter(hoje)
                && !dataNascimento.isBefore(hoje.minusYears(IDADE_MAXIMA));
    }
}