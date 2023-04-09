package sptech.school.voveaplication.service.usuario.autenticacao.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sptech.school.voveaplication.domain.usuario.Usuario;

import java.util.Collection;

public class UsuarioDetalhesDTO implements UserDetails {
    private final String username;
    private final String email;
    private final String senha;

    public UsuarioDetalhesDTO(Usuario usuario) {
        this.username = usuario.getUsername();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
