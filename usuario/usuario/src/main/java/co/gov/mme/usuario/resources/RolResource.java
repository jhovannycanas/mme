package co.gov.mme.usuario.resources;


import co.gov.mme.usuario.model.entities.Rol;
import co.gov.mme.usuario.services.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/usuarios-rest/api/v1.0")
@RequiredArgsConstructor
public class RolResource {

    private final RolService rolService;

    @GetMapping("/roles")
    public List<Rol> allRoles() {
        return this.rolService.allRol();
    }
}
