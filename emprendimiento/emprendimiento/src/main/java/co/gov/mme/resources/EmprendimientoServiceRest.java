package co.gov.mme.resources;

import co.gov.mme.model.request.EmprendimientoRequest;
import co.gov.mme.model.response.EmprendimientoResponse;
import co.gov.mme.model.response.EmprendimientoUsuarioResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface EmprendimientoServiceRest {

    @ApiOperation(
            value = "Crear un emprendimiento o producto",
            notes = "Si el registro es exitoso, retorna el codigo <b>201<b> y la información del producto o emprendimiento",
            response = ResponseEntity.class
    )
    @PostMapping(value = "/", produces = "application/json")
    ResponseEntity<EmprendimientoResponse> crearEmprendimiento(@Validated @RequestBody EmprendimientoRequest emprendimientoRequest);

    @ApiOperation(
            value = "Buscar emprendimiento usuario",
            notes = "Permite obtener los emprendimientos asociados a un usuario"
    )
    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<List<EmprendimientoUsuarioResponse>> obtenerEmprendimientoUsuario(@PathVariable("id") String id);


    @ApiOperation(
            value = "Actualizar emprendimiento",
            notes = "Permite actualizar un emprendimiento",
            response = ResponseEntity.class
    )
    @PutMapping("/{id}")
    ResponseEntity<EmprendimientoUsuarioResponse> actualizarEmprendimiento(@PathVariable("id") Integer id,
                                                                           @Validated @RequestBody EmprendimientoRequest emprendimientoRequest);

    @ApiOperation(
            value = "Eliminar emprendimiento",
            notes = "Permite eliminar un emprendimiento",
            response = ResponseEntity.class
    )
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminarEmprendimiento(@PathVariable("id") Integer id);


    @ApiOperation(
            value = "All emprendimiento",
            notes = "Permite obtener todos los emprendimientos",
            response = ResponseEntity.class
    )
    @GetMapping(value = "/emprendimientos/", produces = "application/json")
    ResponseEntity<List<EmprendimientoUsuarioResponse>> allEmprendimiento();

    @ApiOperation(
            value = "Buscar emprendimiento segun id",
            notes = "Permite obtener un emprendimiento segun su identificador"
    )
    @GetMapping(value = "/emprendimientos/{id}", produces = "application/json")
    ResponseEntity<EmprendimientoUsuarioResponse> obtenerEmprendimientoById(@PathVariable("id") Integer id);
}
