package co.gov.mme.usuario.services;

import co.gov.mme.usuario.exception.ResourceNotFound;
import co.gov.mme.usuario.exception.UserNotFoundException;
import co.gov.mme.usuario.exception.UsuarioException;
import co.gov.mme.usuario.model.request.LoginRequest;
import co.gov.mme.usuario.model.request.UsuarioRequest;
import co.gov.mme.usuario.model.response.UserLoginResponse;
import co.gov.mme.usuario.model.response.UsuarioResponse;

public interface UsuarioService {

    void crearUsuario(UsuarioRequest usuarioRequest) throws UsuarioException;

    UserLoginResponse login(LoginRequest loginRequest) throws UserNotFoundException;

    UsuarioResponse buscarUsuarioById(Integer id) throws ResourceNotFound;

    UsuarioResponse buscarUusarioByDocumento(String documento) throws ResourceNotFound;
}
