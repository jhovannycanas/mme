package co.gov.mme.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmprendimientoUsuarioResponse {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Boolean estado;
}
