package sptech.school.voveaplication.domain.lista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sptech.school.voveaplication.domain.lista.Lista;

import java.util.List;

public interface ListaRepository extends JpaRepository<Lista, Long> {


    @Query("SELECT l.nomeDaLista FROM Lista l WHERE l.usuario.id = :idUsuario")
    List<String> findListasByUsuarioId(Long idUsuario);
}
