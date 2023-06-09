package maxmilhas.com.br.cpfrecorder.exception;

import lombok.Data;

@Data
public class MessageException {
    private String type;
    private String message;

    public MessageException() {
    }

    public MessageException(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
