package sptech.school.voveaplication.domain.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sptech.school.voveaplication.domain.usuario.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Optional<Usuario> findByEmail(String email);


  @Query("SELECT u FROM Usuario u WHERE u.id = :id AND u.logado = true")
  Optional<Usuario> findUsuarioLogadoById(Long id);



}
