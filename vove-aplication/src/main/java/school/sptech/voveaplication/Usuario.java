package school.sptech.voveaplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String username;
    private String email;
    private String senha;
    private Date dataNasc;
    private List<AudioVisual> favoritos;

    public Usuario(String username, String email, String senha, Date dataNasc) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.favoritos = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<AudioVisual> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<AudioVisual> favoritos) {
        this.favoritos = favoritos;
    }
}
