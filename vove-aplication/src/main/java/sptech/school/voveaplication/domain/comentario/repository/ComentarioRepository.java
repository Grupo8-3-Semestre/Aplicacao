package sptech.school.voveaplication.domain.comentario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.voveaplication.domain.comentario.Comentario;
import sptech.school.voveaplication.domain.comentario.dto.ComentarioDto;
import sptech.school.voveaplication.domain.lista.ListaDtoResposta;
import sptech.school.voveaplication.domain.votacao.Votacao;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findByUsuarioId(Long usuarioId);


//    @Query("SELECT c.descricao, u.nome, v.avaliacao, c.spoiler " +
//            "FROM Comentario c JOIN Usuario u ON c.usuario.id = u.id JOIN Votacao v ON c.usuario.id = v.usuario.id " +
//            "AND c.tmdbIdFilme = v.tmdbIdFilme WHERE c.tmdbIdFilme = :tmdbIdFilme")
//    List<ComentarioDto> informacoesFilmeComentario(Integer tmdbIdFilme);

    Optional<Comentario> findByUsuarioIdAndTmdbIdFilme(Long usuarioId, Integer tmdbIdFilme);

    @Query("SELECT COUNT(v) FROM Comentario v WHERE v.usuario.id = :usuarioId")
    Long countFilmesAvaliadosPorUsuario(Long usuarioId);

    @Query("SELECT AVG(e.avaliacao) FROM Comentario e WHERE e.tmdbIdFilme = :tmdbId")
    Double mediaDeVotos(Integer tmdbId);

}
