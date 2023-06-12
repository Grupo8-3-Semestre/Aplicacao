package sptech.school.voveaplication.domain.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sptech.school.voveaplication.domain.votacao.Votacao;

import java.util.Optional;

public interface VotacaoRepository extends JpaRepository<Votacao, Long> {


//    Optional<Votacao> findByUsuarioIdAndtmdbIdFilme(Long idUsuario, Integer tmdbIdFilme);
    Optional<Votacao> findByUsuarioIdAndTmdbIdFilme(Long idUsuario, Integer tmdbIdFilme);
    Optional<Votacao> findByUsuarioId(Long id);


    @Query("SELECT AVG(e.avaliacao) FROM Votacao e WHERE e.tmdbIdFilme = :tmdbId")
    Double mediaDeVotos(Integer tmdbId);
}
