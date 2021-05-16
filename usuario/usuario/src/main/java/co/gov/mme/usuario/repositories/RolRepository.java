package co.gov.mme.usuario.repositories;

import co.gov.mme.usuario.model.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
