package sptech.school.voveaplication.service.usuario.autenticacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.repository.UsuarioRepository;
import sptech.school.voveaplication.service.usuario.autenticacao.dto.UsuarioDetalhesDTO;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método da interface implementada
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if(usuarioOpt.isEmpty()){
            throw new UsernameNotFoundException(String.format("usuario: %s não encontrado", email));
        }
            return new UsuarioDetalhesDTO(usuarioOpt.get());
    }
}
