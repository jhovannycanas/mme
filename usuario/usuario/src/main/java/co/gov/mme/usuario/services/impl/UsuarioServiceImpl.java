package co.gov.mme.usuario.services.impl;

import co.gov.mme.usuario.exception.ResourceNotFound;
import co.gov.mme.usuario.exception.UserNotFoundException;
import co.gov.mme.usuario.exception.UsuarioException;
import co.gov.mme.usuario.model.entities.Rol;
import co.gov.mme.usuario.model.entities.Usuario;
import co.gov.mme.usuario.model.entities.UsuarioRol;
import co.gov.mme.usuario.model.request.LoginRequest;
import co.gov.mme.usuario.model.request.UsuarioRequest;
import co.gov.mme.usuario.model.response.UserLoginResponse;
import co.gov.mme.usuario.model.response.UsuarioResponse;
import co.gov.mme.usuario.repositories.RolRepository;
import co.gov.mme.usuario.repositories.UsuarioRepository;
import co.gov.mme.usuario.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void crearUsuario(UsuarioRequest usuarioRequest) throws UsuarioException {

        Usuario usuario = Usuario.builder().documento(usuarioRequest.getDocumento())
                .email(usuarioRequest.getEmail())
                .fechaNacimiento(usuarioRequest.getFechaNacimiento())
                .nombre(usuarioRequest.getNombre())
                .primerApellido(usuarioRequest.getPrimerApellido())
                .segundoApellido(usuarioRequest.getSegundoApellido())
                .username(usuarioRequest.getUser())
                .password(passwordEncoder.encode(usuarioRequest.getPassword()))
                .fechaCreacion(new Date())
                .usuarioCreacion("system")
                .estado(Boolean.TRUE)
                .build();
        Rol rol = this.rolRepository.findById(usuarioRequest.getRol()).orElseThrow(()-> new UsuarioException("No se encontro el rol", 404));
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setEstado(Boolean.TRUE);
        usuario.addRol(usuarioRol);
        this.usuarioRepository.save(usuario);
    }

    @Override
    public UserLoginResponse login(LoginRequest loginRequest) throws UserNotFoundException {
        Usuario usuario = this.usuarioRepository.findFirstByUsername(loginRequest.getUser())
                .orElseThrow(() -> new UserNotFoundException("El usuario no existe", 404));

        if (usuario == null || !passwordEncoder.matches(loginRequest.getPassword(), usuario.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return UserLoginResponse.builder().nombre(usuario.getNombre().concat(" ").concat(usuario.getPrimerApellido().concat(" ").concat(usuario.getSegundoApellido())))
                .documentoUsuario(usuario.getDocumento()).rol(usuario.getUsuarioRols().stream().map(usuarioRol ->
                        usuarioRol.getRol().getNombre()).collect(Collectors.toList())).build();
    }

    @Override
    public UsuarioResponse buscarUsuarioById(Integer id) throws ResourceNotFound {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFound("El usuario no existe", 404));

        return UsuarioResponse.builder().documento(usuario.getDocumento()).email(usuario.getEmail())
                .fechaNacimiento(usuario.getFechaNacimiento()).nombre(usuario.getNombre())
                .primerApellido(usuario.getPrimerApellido())
                .segundoApellido(usuario.getSegundoApellido()).build();
    }

    @Override
    public UsuarioResponse buscarUusarioByDocumento(String documento) throws ResourceNotFound {
        Usuario usuario = this.usuarioRepository.findByDocumento(documento).orElseThrow(() -> new ResourceNotFound("El usuario no existe", 404));

        return UsuarioResponse.builder().documento(usuario.getDocumento()).email(usuario.getEmail())
                .fechaNacimiento(usuario.getFechaNacimiento()).nombre(usuario.getNombre())
                .id(usuario.getId())
                .primerApellido(usuario.getPrimerApellido())
                .segundoApellido(usuario.getSegundoApellido()).build();
    }
}
