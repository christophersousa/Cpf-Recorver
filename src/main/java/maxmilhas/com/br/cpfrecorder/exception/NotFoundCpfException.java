package maxmilhas.com.br.cpfrecorder.exception;

public class NotFoundCpfException extends IllegalArgumentException {
    private static final String MESSAGE = "CPF not found";

    public NotFoundCpfException() {
        super(MESSAGE);
    }
}
