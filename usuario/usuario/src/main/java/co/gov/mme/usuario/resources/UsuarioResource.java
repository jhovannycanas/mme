package co.gov.mme.usuario.resources;

import co.gov.mme.usuario.exception.UserNotFoundException;
import co.gov.mme.usuario.exception.UsuarioException;
import co.gov.mme.usuario.model.request.LoginRequest;
import co.gov.mme.usuario.model.request.UsuarioRequest;
import co.gov.mme.usuario.model.response.UserLoginResponse;
import co.gov.mme.usuario.model.response.UsuarioResponse;
import co.gov.mme.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/usuarios-rest/api/v1.0")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearUsuario(@RequestBody UsuarioRequest usuarioRequest) throws UsuarioException {
        this.usuarioService.crearUsuario(usuarioRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody LoginRequest loginRequest) throws UserNotFoundException {
        UserLoginResponse usuarioResponse = this.usuarioService.login(loginRequest);
        return new ResponseEntity<>(usuarioResponse,HttpStatus.OK);
    }

    @GetMapping("/{documento}")
    public UsuarioResponse buscarUsurioByDocumento(@PathVariable("documento") String documento) throws UserNotFoundException {
        return this.usuarioService.buscarUusarioByDocumento(documento);
    }
}
