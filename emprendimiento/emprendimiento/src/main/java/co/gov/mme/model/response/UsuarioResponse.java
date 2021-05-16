package co.gov.mme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Integer id;

    private String nombre;

    private String documento;

    private String email;

    private String primerApellido;

    private String segundoApellido;

    private Date fechaNacimiento;
}
