package sptech.school.voveaplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndSenha (String email, String senha);

//    Optional<Usuario> findBySenha (String senha);

    boolean existsByEmail (String email);
    boolean existsBySenha (String senha);
    Void deleteByEmail (String email);

}
