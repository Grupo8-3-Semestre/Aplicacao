package sptech.school.voveaplication.domain.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.voveaplication.domain.votacao.Votacao;

import java.util.List;
import java.util.Optional;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {


    //    Optional<Votacao> findByUsuarioIdAndtmdbIdFilme(Long idUsuario, Integer tmdbIdFilme);
    Optional<Votacao> findByUsuarioIdAndTmdbIdFilme(Long idUsuario, Integer tmdbIdFilme);

    List<Votacao> findByUsuarioId(Long usuarioId);
    @Query("SELECT AVG(e.avaliacao) FROM Votacao e WHERE e.tmdbIdFilme = :tmdbId")
    Double mediaDeVotos(Integer tmdbId);
    @Query("SELECT COUNT(v) FROM Votacao v WHERE v.usuario.id = :usuarioId")
    Long countFilmesAvaliadosPorUsuario(Long usuarioId);

}
