package co.gov.mme.services.impl;


import co.gov.mme.exceptions.ResourceNotFound;
import co.gov.mme.model.entities.Emprendimiento;
import co.gov.mme.model.request.EmprendimientoRequest;
import co.gov.mme.model.response.EmprendimientoResponse;
import co.gov.mme.model.response.EmprendimientoUsuarioResponse;
import co.gov.mme.model.response.UsuarioResponse;
import co.gov.mme.repositories.EmprendimientoRepository;
import co.gov.mme.rest.ClienteUsuario;
import co.gov.mme.services.EmprendimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmprendimientoServiceImpl implements EmprendimientoService {
    private final EmprendimientoRepository emprendimientoRepository;
    private final ClienteUsuario clienteUsuario;

    @Override
    public EmprendimientoResponse crearEmprendimiento(EmprendimientoRequest emprendimientoRequest) {

        UsuarioResponse usuarioResponse = this.clienteUsuario.obtenerUsuarioByDocumento(emprendimientoRequest.getDocumentoUsuario());

        Emprendimiento emprendimiento = Emprendimiento.builder().estado(Boolean.TRUE)
                .fechaCreacion(new Date())
                .usuarioCreacion(usuarioResponse.getDocumento())
                .usuario(usuarioResponse.getId())
                .titulo(emprendimientoRequest.getTitulo())
                .descripcion(emprendimientoRequest.getDescripcion()).build();
        emprendimiento = this.emprendimientoRepository.save(emprendimiento);
        return EmprendimientoResponse.builder().id(emprendimiento.getId()).build();
    }

    @Override
    public List<EmprendimientoUsuarioResponse> buscarEmprendimientoByUsuario(String usuarioId) {
        UsuarioResponse usuarioResponse = this.clienteUsuario.obtenerUsuarioByDocumento(usuarioId);
        List<Emprendimiento> emprendimientos = emprendimientoRepository.findByUsuario(usuarioResponse.getId());
        if (emprendimientos.isEmpty()) {
            throw new ResourceNotFound("No se encontraron emprendiemientos asociados al emprendedor", 404);
        }
        return emprendimientos.stream().filter(emprendimiento -> emprendimiento.getEstado()).map(emprendimiento -> EmprendimientoUsuarioResponse.builder()
        .id(emprendimiento.getId()).descripcion(emprendimiento.getDescripcion())
                .nombre(emprendimiento.getTitulo()).build()).collect(Collectors.toList());
    }

    @Override
    public void desactivarEmprendimiento(Integer id) {
        this.emprendimientoRepository.findById(id)
                .map(emprendimiento -> {
                    emprendimiento.setEstado(Boolean.FALSE);
                    emprendimiento.setFechaModificacion(new Date());
                    return this.emprendimientoRepository.save(emprendimiento);
                })
                .orElseThrow(() -> new ResourceNotFound("No se encontro emprendimiento con el id", 404));
    }

    @Override
    public EmprendimientoUsuarioResponse actualizarEmprendimiento(Integer id, EmprendimientoRequest emprendimientoRequest) {
        return this.emprendimientoRepository.findById(id)
                .map(emprendimiento -> {
                    emprendimiento.setDescripcion(emprendimientoRequest.getDescripcion());
                    emprendimiento.setTitulo(emprendimientoRequest.getTitulo());
                    emprendimiento.setFechaModificacion(new Date());
                    return this.emprendimientoRepository.save(emprendimiento);
                })
                .map(emprendimiento -> EmprendimientoUsuarioResponse.builder().id(emprendimiento.getId())
                .descripcion(emprendimiento.getDescripcion()).nombre(emprendimiento.getTitulo()).build())
                .orElseThrow(() -> new ResourceNotFound("No se encontro emprendimiento con el id", 404));
    }

    @Override
    public List<EmprendimientoUsuarioResponse> allEmprendimiento() {
        return this.emprendimientoRepository.findAll().stream().map(emprendimiento ->  EmprendimientoUsuarioResponse.builder().id(emprendimiento.getId())
                .descripcion(emprendimiento.getDescripcion()).nombre(emprendimiento.getTitulo()).build()).collect(Collectors.toList());
    }

    @Override
    public EmprendimientoUsuarioResponse getById(Integer id) {
        return this.emprendimientoRepository.findById(id).map(emprendimiento -> EmprendimientoUsuarioResponse.builder().id(emprendimiento.getId())
                .descripcion(emprendimiento.getDescripcion()).nombre(emprendimiento.getTitulo()).build())
                .orElseThrow(() -> new ResourceNotFound("No se encontro emprendimiento con el id", 404));
    }

}
