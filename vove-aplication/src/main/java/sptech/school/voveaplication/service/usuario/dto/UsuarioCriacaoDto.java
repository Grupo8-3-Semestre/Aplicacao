package sptech.school.voveaplication.service.usuario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import sptech.school.voveaplication.antigasClasses.Filme;
import sptech.school.voveaplication.service.listaobj.ListaObj;

import java.time.LocalDate;

public class UsuarioCriacaoDto {


  private Long id;
  @Schema(example= "João Pedro Leka")
  private String nome;

  @Schema(example= "email@dominio.com")
  private String email;
  @Schema(example= "Senha complicada")
  private String senha;
  @Schema(name= "data de nascimento", example = "2001-12-04")
  private LocalDate dataNasc;

  private String sexo;
  private Integer cep;
  private String generoPreferido;
  private Boolean assinaStreaming;
  private Integer qtdFrequencia;
  private Boolean buscaAvaliacao;
  private String aparelhoUtilizado;


//  private ListaObj<Filme> filmeLista;


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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public ListaObj<Filme> getFilmeLista() {
//    return filmeLista;
//  }

//  public void setFilmeLista(ListaObj<Filme> filmeLista) {
//    this.filmeLista = filmeLista;
//  }
}
