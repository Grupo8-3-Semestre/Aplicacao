package sptech.school.voveaplication.service.usuario.dto;

import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDTO;

public class UsuarioMapper {

    public static Usuario of(UsuarioCriacaoDTO usuarioCriacaoDTO) {
        Usuario usuario = new Usuario();

        usuario.setEmail(usuarioCriacaoDTO.getEmail());
        usuario.setUsername(usuarioCriacaoDTO.getUsername());
        usuario.setSenha(usuarioCriacaoDTO.getSenha());

        return usuario;
    }

    public static UsuarioTokenDTO of(Usuario usuario, String token){
        UsuarioTokenDTO usuarioTokenDTO = new UsuarioTokenDTO();

        usuarioTokenDTO.setUserId(usuario.getId());
        usuarioTokenDTO.setEmail(usuario.getEmail());
        usuarioTokenDTO.setUsername(usuario.getUsername());
        usuarioTokenDTO.setToken(token);

        return usuarioTokenDTO;
    }
}
