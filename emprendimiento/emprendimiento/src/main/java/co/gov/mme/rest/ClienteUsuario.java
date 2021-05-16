package co.gov.mme.rest;

import co.gov.mme.model.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClienteUsuario {

    @Value("${usuario.service:'NA'}")
    private String endPointUsuario;

    private final RestTemplate restTemplate;

    public UsuarioResponse obtenerUsuarioByDocumento(String documento) {
        return restTemplate.getForObject(endPointUsuario + "/" + documento, UsuarioResponse.class);
    }
}
