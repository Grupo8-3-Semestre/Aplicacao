package sptech.school.voveaplication.domain.comentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.comentario.dto.ComentarioDto;
import sptech.school.voveaplication.domain.lista.ListaDtoResposta;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {


//    @Query("SELECT c.descricao, u.nome, v.avaliacao, c.spoiler " +
//            "FROM Comentario c JOIN Usuario u ON c.usuario.id = u.id JOIN Votacao v ON c.usuario.id = v.usuario.id " +
//            "AND c.tmdbIdFilme = v.tmdbIdFilme WHERE c.tmdbIdFilme = :tmdbIdFilme")
//    List<ComentarioDto> informacoesFilmeComentario(Integer tmdbIdFilme);

    Optional<Comentario> findByUsuarioIdAndTmdbIdFilme(Long usuarioId, Integer tmdbIdFilme);



}
