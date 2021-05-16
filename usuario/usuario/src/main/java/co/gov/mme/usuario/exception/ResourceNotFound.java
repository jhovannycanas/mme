package co.gov.mme.usuario.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

    private int code;
    public ResourceNotFound(String mensaje, int codigo) {
        super(mensaje);
        code = codigo;
    }
}
