package sptech.school.voveaplication.domain.lista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sptech.school.voveaplication.domain.lista.ListaTabela;

import java.util.List;
import java.util.Optional;

public interface ListaTabelaRepository extends JpaRepository<ListaTabela, Long> {
    List<ListaTabela> findByUsuarioIdAndListaFilmeId(Long idUsuario, Long idLista);
    Optional<ListaTabela> findByTmdbIdFilmeAndListaFilmeId(Integer codigoFilme, Long idLista);



    Boolean existsByUsuarioIdAndListaFilmeIdAndTmdbIdFilme(Long idUsuario,Long idLista, Integer idFilme);

}
