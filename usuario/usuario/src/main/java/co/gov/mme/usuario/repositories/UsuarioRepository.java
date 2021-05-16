package co.gov.mme.usuario.repositories;

import co.gov.mme.usuario.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findFirstByUsername(String username);

    Optional<Usuario> findById(Integer id);

    Optional<Usuario> findByDocumento(String documento);
}
