package co.gov.mme.usuario.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserLoginResponse {

    private String documentoUsuario;

    private String nombre;

    private List<String> rol;
}
