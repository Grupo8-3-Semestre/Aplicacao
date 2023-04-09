package sptech.school.voveaplication.service.usuario.dto;

import sptech.school.voveaplication.domain.usuario.Usuario;

import java.time.LocalDate;

public class UsuarioDTO {
    private Integer idDTO;
    private String usernameDTO;
    private String emailDTO;
//    private LocalDate dataNascDTO;
    private boolean autenticado;

    public UsuarioDTO(Usuario usuario) {
        this.idDTO = usuario.getId();
        this.usernameDTO = usuario.getUsername();
        this.emailDTO = usuario.getEmail();
//        this.dataNascDTO = usuario.getDataNasc();
    }

    public String getUsernameDTO() {
        return usernameDTO;
    }

    public void setUsernameDTO(String usernameDTO) {
        this.usernameDTO = usernameDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

//    public LocalDate getDataNascDTO() {
//        return dataNascDTO;
//    }
//
//    public void setDataNascDTO(LocalDate dataNascDTO) {
//        this.dataNascDTO = dataNascDTO;
//    }


    public Integer getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(Integer idDTO) {
        this.idDTO = idDTO;
    }
}