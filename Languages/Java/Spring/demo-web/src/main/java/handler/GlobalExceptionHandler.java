package handler;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.ExecutionException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> handleGeneral(Exception e, WebRequest request){
        e.getClass().isAssignableFrom(UndeclaredThrowableException.class);
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return resourceNotFoundException((ResourceNotFoundException) exception.getUndeclaredThrowable());


    }

    @ExceptionHandler({ResourceNotFoundException.class})
    private ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("exception.getMessage()");
    }
}
