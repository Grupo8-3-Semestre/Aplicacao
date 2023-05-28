package sptech.school.voveaplication.domain.usuario;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3, max = 32)
  @Schema(example= "João Pedro Leka")
  private String nome;
  @NotBlank
  @Email
  @Schema(example= "email@dominio.com")
  private String email;
  @NotBlank
  @Size(min = 8, max = 255)
  @Schema(example= "Senha complicada")
  private String senha;
  @PastOrPresent
  @Schema(name= "data de nascimento", example = "2001-12-04")
  private LocalDate dataNasc;
  private Boolean aceitaEmail;

  private boolean logado;


  public Usuario() {
    this.logado = false;
  }

  public boolean isLogado() {
    return logado;
  }

  public void setLogado(boolean logado) {
    this.logado = logado;
  }

  public Boolean getAceitaEmail() {
    return aceitaEmail;
  }

  public void setAceitaEmail(Boolean aceitaEmail) {
    this.aceitaEmail = aceitaEmail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public LocalDate getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(LocalDate dataNasc) {
    this.dataNasc = dataNasc;
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
}