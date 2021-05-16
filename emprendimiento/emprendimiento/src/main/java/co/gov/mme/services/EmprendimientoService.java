package co.gov.mme.services;


import co.gov.mme.model.request.EmprendimientoRequest;
import co.gov.mme.model.response.EmprendimientoResponse;
import co.gov.mme.model.response.EmprendimientoUsuarioResponse;

import java.util.List;

public interface EmprendimientoService {

    EmprendimientoResponse crearEmprendimiento(EmprendimientoRequest emprendimientoRequest);

    List<EmprendimientoUsuarioResponse> buscarEmprendimientoByUsuario(String usuarioId);

    void desactivarEmprendimiento(Integer id);

    EmprendimientoUsuarioResponse actualizarEmprendimiento(Integer id, EmprendimientoRequest emprendimientoRequest);

    List<EmprendimientoUsuarioResponse> allEmprendimiento();

    EmprendimientoUsuarioResponse getById(Integer id);
}
