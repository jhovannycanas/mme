package co.gov.mme.resources;

import co.gov.mme.model.request.EmprendimientoRequest;
import co.gov.mme.model.response.EmprendimientoResponse;
import co.gov.mme.model.response.EmprendimientoUsuarioResponse;
import co.gov.mme.services.EmprendimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/emprendimiento-rest/api/v1.0")
@RequiredArgsConstructor
public class EmprendimientoResource implements EmprendimientoServiceRest {
    private final EmprendimientoService emprendimientoService;

    public ResponseEntity<EmprendimientoResponse> crearEmprendimiento(@Validated @RequestBody EmprendimientoRequest emprendimientoRequest) {
        return new ResponseEntity<>(this.emprendimientoService.crearEmprendimiento(emprendimientoRequest), HttpStatus.CREATED);
    }

    public ResponseEntity<List<EmprendimientoUsuarioResponse>> obtenerEmprendimientoUsuario(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.emprendimientoService.buscarEmprendimientoByUsuario(id));
    }

    public ResponseEntity<EmprendimientoUsuarioResponse> actualizarEmprendimiento(@PathVariable("id") Integer id,
                                                                                  @Validated @RequestBody EmprendimientoRequest emprendimientoRequest) {
        return ResponseEntity.ok(this.emprendimientoService.actualizarEmprendimiento(id, emprendimientoRequest));
    }

    public ResponseEntity<Void> eliminarEmprendimiento(@PathVariable("id") Integer id) {
        this.emprendimientoService.desactivarEmprendimiento(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<List<EmprendimientoUsuarioResponse>> allEmprendimiento() {
        return ResponseEntity.ok(this.emprendimientoService.allEmprendimiento());
    }

    @Override
    public ResponseEntity<EmprendimientoUsuarioResponse> obtenerEmprendimientoById(Integer id) {
        return ResponseEntity.ok(this.emprendimientoService.getById(id));
    }
}
