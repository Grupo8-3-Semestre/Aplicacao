package sptech.school.voveaplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Entity
public class Usuario {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY) //auto increment

    private Integer id;
    @NotBlank
    @Size(min = 3, max = 32)
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 255)
    private String senha;
    @PastOrPresent
    private LocalDate dataNasc;
//    private List<AudioVisual> audioVisual;
    private boolean autenticado;

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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
