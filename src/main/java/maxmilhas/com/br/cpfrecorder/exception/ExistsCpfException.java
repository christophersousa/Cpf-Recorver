package maxmilhas.com.br.cpfrecorder.exception;

public class ExistsCpfException extends IllegalArgumentException {
    private static final String MESSAGE = "CPF already registered";

    public ExistsCpfException() {
        super(MESSAGE);
    }
}
