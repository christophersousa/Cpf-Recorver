package maxmilhas.com.br.cpfrecorder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class AplicationExceptionHandle extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity handleExceptionInvalid(Exception e) {
        log.info("Logger: " + e.getMessage());
        MessageException message = new MessageException(
                e.getClass().getSimpleName(),
                e.getMessage());

        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsCpfException.class)
    public ResponseEntity handleExceptionExists(Exception e) {
        log.info("Logger: " + e.getMessage());
        MessageException message = new MessageException(
                e.getClass().getSimpleName(),
                e.getMessage());

        return new ResponseEntity(message, HttpStatus.FOUND);
    }

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity handleExceptionNotFound(Exception e) {
        log.info("Logger: " + e.getMessage());
        MessageException message = new MessageException(
                e.getClass().getSimpleName(),
                e.getMessage());

        return new ResponseEntity(message, HttpStatus.NOT_FOUND);
    }

}
