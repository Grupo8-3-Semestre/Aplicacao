package sptech.school.voveaplication.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sptech.school.voveaplication.domain.usuario.Usuario;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndSenha (String email, String senha);

    Optional<Usuario> findByEmail (String email);

//    Optional<Usuario> findBySenha (String senha);

    boolean existsByEmail (String email);
    boolean existsBySenha (String senha);
    Void deleteByEmail (String email);

}
