package sptech.school.voveaplication.service.usuario.dto;

import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDto;

public class UsuarioMapper {

  public static Usuario of(UsuarioCriacaoDto usuarioCriacaoDto) {
    Usuario usuario = new Usuario();

    usuario.setId(usuarioCriacaoDto.getId());
    usuario.setEmail(usuarioCriacaoDto.getEmail());
    usuario.setNome(usuarioCriacaoDto.getNome());
    usuario.setSenha(usuarioCriacaoDto.getSenha());
    usuario.setDataNasc(usuarioCriacaoDto.getDataNasc());

    return usuario;
  }

  public static UsuarioCriacaoDto atualizar(UsuarioCriacaoDto usuarioCriacaoDto) {

    usuarioCriacaoDto.setId(usuarioCriacaoDto.getId());
    usuarioCriacaoDto.setEmail(usuarioCriacaoDto.getEmail());
    usuarioCriacaoDto.setNome(usuarioCriacaoDto.getNome());
    usuarioCriacaoDto.setSenha(usuarioCriacaoDto.getSenha());
    usuarioCriacaoDto.setDataNasc(usuarioCriacaoDto.getDataNasc());

    return usuarioCriacaoDto;
  }



  public static UsuarioTokenDto of(Usuario usuario, String token) {
    UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();

    usuarioTokenDto.setUserId(usuario.getId());
    usuarioTokenDto.setEmail(usuario.getEmail());
    usuarioTokenDto.setNome(usuario.getNome());
    usuarioTokenDto.setToken(token);

    return usuarioTokenDto;
  }
}
