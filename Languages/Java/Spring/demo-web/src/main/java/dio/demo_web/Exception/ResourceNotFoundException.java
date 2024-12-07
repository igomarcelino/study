package handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus()
public class ResourceNotFoundException extends RuntimeException{

    private String message = "Nome nao localizado";
    public ResourceNotFoundException(){super("Nome nao localizado");}
    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
