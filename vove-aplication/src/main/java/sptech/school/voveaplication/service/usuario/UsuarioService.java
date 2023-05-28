package sptech.school.voveaplication.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import java.util.List;
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
  
  public void  atualizar(Long id, Usuario usuarioAtualizar){
    String senhaCriptografada = passwordEncoder.encode(usuarioAtualizar.getSenha());
    usuarioAtualizar.setSenha(senhaCriptografada);


    Optional<Usuario> usuario = usuarioRepository.findById(id);
    if (usuario.isPresent()) {
      usuarioAtualizar.setId(id);
      Usuario usuarioSalvo = usuarioRepository.save(usuarioAtualizar);
    } 

    
    
  }


  public void  deletar(Long id){
    Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
    if (usuarioOpt.isPresent()) {
      usuarioRepository.delete(usuarioOpt.get());
    }




  }

  public List<Usuario> listar(){

    List<Usuario> usuarios=this.usuarioRepository.findAll();

    if (usuarios.isEmpty()) {
      return usuarios;
    }
return usuarios;


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
    usuarioAutenticado.setLogado(true);
    usuarioRepository.save(usuarioAutenticado);

    SecurityContextHolder.getContext().setAuthentication(authentication);

    final String token = gerenciadorTokenJwt.generateToken(authentication);

    return UsuarioMapper.of(usuarioAutenticado, token);
  }
  public void deslogar(long usuarioId) {
    Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioId);

    if (optionalUsuario.isPresent()) {
      Usuario usuario = optionalUsuario.get();
      usuario.setLogado(false);
      usuarioRepository.save(usuario);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }
  }
}