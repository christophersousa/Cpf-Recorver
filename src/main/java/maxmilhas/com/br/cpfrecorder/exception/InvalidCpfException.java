package maxmilhas.com.br.cpfrecorder.exception;

public class InvalidCpfException extends IllegalArgumentException {
    private static final String MESSAGE = "CPF is not valid";

    public InvalidCpfException() {
        super(MESSAGE);
    }
}
