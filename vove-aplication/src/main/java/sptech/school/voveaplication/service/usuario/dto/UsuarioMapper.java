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
    usuario.setCep(usuarioCriacaoDto.getCep());
    usuario.setSexo(usuarioCriacaoDto.getSexo());
    usuario.setAparelhoUtilizado(usuarioCriacaoDto.getAparelhoUtilizado());
    usuario.setBuscaAvaliacao(usuarioCriacaoDto.getBuscaAvaliacao());
    usuario.setGeneroPreferido(usuarioCriacaoDto.getGeneroPreferido());
    usuario.setQtdFrequencia(usuarioCriacaoDto.getQtdFrequencia());
    usuario.setAssinaStreaming(usuarioCriacaoDto.getAssinaStreaming());
//    usuario.setFilmeLista(usuarioCriacaoDto.getFilmeLista());

    return usuario;
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
