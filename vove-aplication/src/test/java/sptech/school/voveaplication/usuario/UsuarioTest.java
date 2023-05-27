package sptech.school.voveaplication.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import sptech.school.voveaplication.api.configuration.security.jwt.GerenciadorTokenJwt;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;
import sptech.school.voveaplication.service.usuario.UsuarioService;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioLoginDto;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioTokenDto;
import sptech.school.voveaplication.service.usuario.dto.UsuarioCriacaoDto;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Mock
    private AuthenticationManager authenticationManager;
    @InjectMocks
    private UsuarioService usuarioService;



    @Test
    @DisplayName("Verifica se o usuario ta cadastrando")
    void verificaSeUsuarioTaCadastrando(){
        UsuarioCriacaoDto usuarioCriacaoDto = new UsuarioCriacaoDto();
        usuarioCriacaoDto.setNome("John Doe");
        usuarioCriacaoDto.setEmail("johndoe@example.com");
        usuarioCriacaoDto.setSenha("password");

        Mockito.when(passwordEncoder.encode(ArgumentMatchers.any(CharSequence.class))).thenReturn("hashedPassword");

        usuarioService.criar(usuarioCriacaoDto);

       Mockito.verify(usuarioRepository, Mockito.times(1)).save(ArgumentMatchers.any(Usuario.class));
    }

    @Test
    @DisplayName("Verifica se o usuario existente ta logando")
    void verificaSeUsuarioTaLogando(){
        String email = "johndoe@example.com";
        String senha = "password";
        String token = "jwtToken";

        UsuarioLoginDto usuarioLoginDto = new UsuarioLoginDto();
        usuarioLoginDto.setEmail(email);
        usuarioLoginDto.setSenha(senha);

        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setEmail(email);
        usuarioExistente.setSenha(senha);

        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(authentication);

        Mockito.when(usuarioRepository.findByEmail(email)).thenReturn(Optional.of(usuarioExistente));

        Mockito.when(gerenciadorTokenJwt.generateToken(authentication)).thenReturn(token);

        UsuarioTokenDto usuarioTokenDto = usuarioService.autenticar(usuarioLoginDto);

        Mockito.verify(authenticationManager, Mockito.times(1)).authenticate(ArgumentMatchers.any(UsernamePasswordAuthenticationToken.class));

        Mockito.verify(usuarioRepository, Mockito.times(1)).findByEmail(email);

        Mockito.verify(gerenciadorTokenJwt, Mockito.times(1)).generateToken(authentication);

        assertEquals(usuarioExistente.getNome(), usuarioTokenDto.getNome());
        assertEquals(usuarioExistente.getEmail(), usuarioTokenDto.getEmail());
        assertEquals(token, usuarioTokenDto.getToken());

    }
    @Test
    @DisplayName("testa login caso usuario não exista")
    void testaLoginCasoUsuarioNãoExista(){
        // Dados de teste
        String email = "nonexistent@example.com";
        String senha = "password";

        UsuarioLoginDto usuarioLoginDto = new UsuarioLoginDto();
        usuarioLoginDto.setEmail(email);
        usuarioLoginDto.setSenha(senha);

        Mockito.when(usuarioRepository.findByEmail(email)).thenReturn(Optional.empty());

        // Executar o método a ser testado e verificar a exceção lançada
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            usuarioService.autenticar(usuarioLoginDto);
        });
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals("Email do usuário não cadastrado", exception.getReason());
    }
}
