package co.gov.mme.usuario.services.impl;

import co.gov.mme.usuario.model.entities.Rol;
import co.gov.mme.usuario.repositories.RolRepository;
import co.gov.mme.usuario.services.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Override
    public List<Rol> allRol() {
        return rolRepository.findAll();
    }
}
