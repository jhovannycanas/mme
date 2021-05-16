package co.gov.mme.usuario.controls;

import co.gov.mme.usuario.exception.BadRequestException;
import co.gov.mme.usuario.exception.ResourceNotFound;
import co.gov.mme.usuario.exception.UserNotFoundException;
import co.gov.mme.usuario.exception.UsuarioException;
import co.gov.mme.usuario.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<Object> handleProfesionalNotFound(UsuarioException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleProfesionalNotFound(UserNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleProfesionalNotFound(ResourceNotFound e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(e.getCode());
        errorResponse.setMensaje(e.getMessage());
        return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
