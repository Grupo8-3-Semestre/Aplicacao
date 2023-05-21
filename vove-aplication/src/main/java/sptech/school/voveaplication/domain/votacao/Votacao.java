package sptech.school.voveaplication.domain.votacao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import sptech.school.voveaplication.domain.usuario.Usuario;


@Entity
public class Votacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @Max(5)
    private Integer avaliacao;

    @ManyToOne
    private Usuario usuario;

    private Integer tmdbIdFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getTmdbIdFilme() {
        return tmdbIdFilme;
    }

    public void setTmdbIdFilme(Integer tmdbIdFilme) {
        this.tmdbIdFilme = tmdbIdFilme;
    }
}
