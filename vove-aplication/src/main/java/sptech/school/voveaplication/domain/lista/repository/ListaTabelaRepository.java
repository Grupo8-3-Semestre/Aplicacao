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

//    @Query("SELECT lt, l.nome FROM ListaTabela lt JOIN lt.lista l WHERE l.id = :id")

//    @Query( "SELECT l.nomeDaLista " +
//            "FROM Lista l " +
//            "JOIN ListaTabela lt ON l.id = lt.id " +
//            "JOIN Usuario u ON lt.usuario_id = u.id" +
//            "WHERE u.id = :idUsuario")
//    List<String> minhasListas(Long idUsuario);
@Query("SELECT l.nomeDaLista FROM Lista l JOIN ListaTabela lt ON lt.listaFilme.id = l.id JOIN Usuario u ON lt.usuario.id = u.id WHERE u.id = :idUsuario")
List<String> findListasByUsuarioId(@Param("idUsuario") Long idUsuario);

}
