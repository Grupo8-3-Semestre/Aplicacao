package sptech.school.voveaplication.domain.lista;

import jakarta.persistence.*;
import sptech.school.voveaplication.domain.usuario.Usuario;

import java.util.List;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaLista;
    @ManyToOne
    private Usuario usuario;
    private List<Integer> listaFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaLista() {
        return nomeDaLista;
    }

    public void setNomeDaLista(String nomeDaLista) {
        this.nomeDaLista = nomeDaLista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Integer> getListaFilme() {
        return listaFilme;
    }

    public void setListaFilme(List<Integer> listaFilme) {
        this.listaFilme = listaFilme;
    }
}
