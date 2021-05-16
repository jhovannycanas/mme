package co.gov.mme.repositories;

import co.gov.mme.model.entities.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Integer> {

    List<Emprendimiento> findByUsuario(Integer id);
}
