package co.gov.mme.usuario.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UsuarioResponse {

    private Integer id;

    private String nombre;

    private String documento;

    private String email;

    private String primerApellido;

    private String segundoApellido;

    private Date fechaNacimiento;
}
