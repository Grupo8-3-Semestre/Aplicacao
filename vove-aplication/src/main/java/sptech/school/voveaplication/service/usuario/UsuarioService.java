package sptech.school.voveaplication.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import sptech.school.voveaplication.api.configuration.security.jwt.GerenciadorTokenJwt;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioLoginDto;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDto;
import sptech.school.voveaplication.service.usuario.dto.UsuarioCriacaoDto;
import sptech.school.voveaplication.service.usuario.dto.UsuarioMapper;

import java.util.Optional;

@Service
public class UsuarioService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private GerenciadorTokenJwt gerenciadorTokenJwt;

  @Autowired
  private AuthenticationManager authenticationManager;

  public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
    final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);

    String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
    novoUsuario.setSenha(senhaCriptografada);

    this.usuarioRepository.save(novoUsuario);
  }
  
  public void  atualizar(Long id, UsuarioCriacaoDto usuarioCriacaoDto){
    final UsuarioCriacaoDto novoUsuario = UsuarioMapper.atualizar(usuarioCriacaoDto);
    String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
    novoUsuario.setSenha(senhaCriptografada);


    Optional<Usuario> usuario = usuarioRepository.findById(id);
    if (usuario.isPresent()) {
      usuarioCriacaoDto.setId(id);
//      this.usuarioRepository.save(novoUsuario);
    } 

    
    
  }

  public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {

    final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
            usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

    final Authentication authentication = this.authenticationManager.authenticate(credentials);

    Usuario usuarioAutenticado =
            usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                    .orElseThrow(
                            () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    final String token = gerenciadorTokenJwt.generateToken(authentication);

    return UsuarioMapper.of(usuarioAutenticado, token);
  }
}