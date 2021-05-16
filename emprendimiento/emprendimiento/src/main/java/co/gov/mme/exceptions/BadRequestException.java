package co.gov.mme.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private int code;
    public BadRequestException(String mensaje, int codigo) {
        super(mensaje);
        code = codigo;
    }
}
