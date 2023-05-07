package sptech.school.voveaplication.domain.lista;

import jakarta.persistence.*;
import sptech.school.voveaplication.domain.usuario.Usuario;

@Entity
public class ListaTabela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Lista listaFilme;
    private Integer tmdbIdFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Lista getListaFilme() {
        return listaFilme;
    }

    public void setListaFilme(Lista listaFilme) {
        this.listaFilme = listaFilme;
    }

    public Integer getTmdbIdFilme() {
        return tmdbIdFilme;
    }

    public void setTmdbIdFilme(Integer tmdbIdFilme) {
        this.tmdbIdFilme = tmdbIdFilme;
    }
}
