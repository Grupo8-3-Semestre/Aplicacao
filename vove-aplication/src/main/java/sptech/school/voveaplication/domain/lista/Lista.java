package sptech.school.voveaplication.domain.lista;

import jakarta.persistence.*;
import sptech.school.voveaplication.domain.usuario.Usuario;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaLista;

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


}
