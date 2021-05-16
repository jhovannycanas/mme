package co.gov.mme.usuario.model.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UsuarioRequest {

    private String nombre;

    private String documento;

    private String password;

    private String user;

    private String email;

    private String primerApellido;

    private String segundoApellido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;

    private Integer rol;
}
