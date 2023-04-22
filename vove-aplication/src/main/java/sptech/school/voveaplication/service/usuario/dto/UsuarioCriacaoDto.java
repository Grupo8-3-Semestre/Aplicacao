package sptech.school.voveaplication.service.usuario.dto;

import sptech.school.voveaplication.Filme;
import sptech.school.voveaplication.ListaObj;

import java.time.LocalDate;

public class UsuarioCriacaoDto {


  private Long id;
  private String nome;

  private String email;

  private String senha;
  private LocalDate dataNasc;

  private ListaObj<Filme> filmeLista;


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

  public ListaObj<Filme> getFilmeLista() {
    return filmeLista;
  }

  public void setFilmeLista(ListaObj<Filme> filmeLista) {
    this.filmeLista = filmeLista;
  }
}
