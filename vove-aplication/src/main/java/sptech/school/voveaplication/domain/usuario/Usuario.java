package sptech.school.voveaplication.domain.usuario;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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


  @Size(min = 3, max = 32)
  @Schema(example= "João Pedro Leka")
  private String nome;

  @Email
  @Schema(example= "email@dominio.com")
  private String email;

  @Size(min = 8, max = 255)
  @Schema(example= "Senha complicada")
  private String senha;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @PastOrPresent
  @Schema(name= "data de nascimento")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataNasc;
  private Boolean aceitaEmail;
  private String fotoPerfil; // Caminho para a foto de perfil no servidor
  private String sexo;
  private Integer cep;
  private String generoPreferido;
  private Boolean assinaStreaming;
  private Integer qtdFrequencia;
  private Boolean buscaAvaliacao;
  private String aparelhoUtilizado;

  private boolean logado;


  public Usuario() {
    this.logado = false;
  }

  public boolean isLogado() {
    return logado;
  }

  public String getFotoPerfil() {
    return fotoPerfil;
  }

  public void setFotoPerfil(String fotoPerfil) {
    this.fotoPerfil = fotoPerfil;
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

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public Integer getCep() {
    return cep;
  }

  public void setCep(Integer cep) {
    this.cep = cep;
  }

  public String getGeneroPreferido() {
    return generoPreferido;
  }

  public void setGeneroPreferido(String generoPreferido) {
    this.generoPreferido = generoPreferido;
  }

  public Boolean getAssinaStreaming() {
    return assinaStreaming;
  }

  public void setAssinaStreaming(Boolean assinaStreaming) {
    this.assinaStreaming = assinaStreaming;
  }

  public Integer getQtdFrequencia() {
    return qtdFrequencia;
  }

  public void setQtdFrequencia(Integer qtdFrequencia) {
    this.qtdFrequencia = qtdFrequencia;
  }

  public Boolean getBuscaAvaliacao() {
    return buscaAvaliacao;
  }

  public void setBuscaAvaliacao(Boolean buscaAvaliacao) {
    this.buscaAvaliacao = buscaAvaliacao;
  }

  public String getAparelhoUtilizado() {
    return aparelhoUtilizado;
  }

  public void setAparelhoUtilizado(String aparelhoUtilizado) {
    this.aparelhoUtilizado = aparelhoUtilizado;
  }
}