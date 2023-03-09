package school.sptech.loginlogoff;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class UsuarioDTO {
    private String nomeUsuarioDTO;
    private String emailDTO;
    private LocalDate dtNascimentoDTO;
    private boolean autenticado;

    public UsuarioDTO(Usuario usuario)  {
        this.nomeUsuarioDTO = usuario.getNomeUsuario();
        this.emailDTO = usuario.getEmail();
        this.dtNascimentoDTO = usuario.getDtNascimento();
        this.autenticado = usuario.isAutenticado();
    }

    public String getNomeUsuarioDTO() {
        return nomeUsuarioDTO;
    }

    public void setNomeUsuarioDTO(String nomeUsuarioDTO) {
        this.nomeUsuarioDTO = nomeUsuarioDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public LocalDate getDtNascimentoDTO() {
        return dtNascimentoDTO;
    }

    public void setDtNascimentoDTO(LocalDate dtNascimentoDTO) {
        this.dtNascimentoDTO = dtNascimentoDTO;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
