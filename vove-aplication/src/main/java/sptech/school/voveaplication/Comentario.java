package sptech.school.voveaplication;

import jakarta.persistence.*;
import sptech.school.voveaplication.domain.usuario.Usuario;

import java.time.Instant;


@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    private Instant momentoComentario;
    @ManyToOne
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        momentoComentario = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        momentoComentario = Instant.now();
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

    public Instant getMomentoComentario() {
        return momentoComentario;
    }

    public void setMomentoComentario(Instant momentoComentario) {
        this.momentoComentario = momentoComentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
