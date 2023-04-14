package sptech.school.voveaplication.domain.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment

    private Integer id;
//    @NotBlank
//    @Size(min = 3, max = 32)
    private String username;
//    @NotBlank
//    @Email
    @Schema(name= "email@dominio.com")
    private String email;
//    @NotBlank
//    @Size(min = 8, max = 255)
    private String senha;
//    @PastOrPresent
//    private LocalDate dataNasc;

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

//    public LocalDate getDataNasc() {
//        return dataNasc;
//    }
//
//    public void setDataNasc(LocalDate dataNasc) {
//        this.dataNasc = dataNasc;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
