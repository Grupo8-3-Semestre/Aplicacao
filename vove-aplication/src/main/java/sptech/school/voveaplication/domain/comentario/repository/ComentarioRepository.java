package sptech.school.voveaplication.domain.comentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.voveaplication.domain.comentario.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
