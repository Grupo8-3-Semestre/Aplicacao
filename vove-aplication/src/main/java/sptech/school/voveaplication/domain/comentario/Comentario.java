package sptech.school.voveaplication.domain.comentario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import sptech.school.voveaplication.domain.usuario.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;


@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(example = "O que você achou do filme")
    private String descricao;

    private LocalDateTime momentoComentario;
    @ManyToOne
    private Usuario usuario;

    private Integer tmdbIdFilme;

    public Integer getTmdbIdFilme() {
        return tmdbIdFilme;
    }

    public void setTmdbIdFilme(Integer tmdbIdFilme) {
        this.tmdbIdFilme = tmdbIdFilme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getMomentoComentario() {
        return momentoComentario;
    }

    public void setMomentoComentario(LocalDateTime momentoComentario) {
        this.momentoComentario = momentoComentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
