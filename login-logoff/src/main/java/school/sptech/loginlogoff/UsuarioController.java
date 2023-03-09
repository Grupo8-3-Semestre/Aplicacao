package school.sptech.loginlogoff;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<UsuarioDTO> usuarioDTOList = new ArrayList<>();
    private List<Usuario> usuarioList = new ArrayList<>();

    @PostMapping
    public UsuarioDTO cadastrar(@RequestBody Usuario novoUsuario) {
        usuarioList.add(novoUsuario);
        UsuarioDTO userDTO = new UsuarioDTO(novoUsuario);
        usuarioDTOList.add(userDTO);
        return userDTO;
    }

    @PostMapping("/{email}/{senha}")
    public UsuarioDTO autenticar(@PathVariable String email,
                                 @PathVariable String senha) {

        for (int i =0; i < usuarioList.size(); i++) {

            if (usuarioList.get(i).getEmail().equals(email) && usuarioList.get(i).getSenha().equals(senha)) {
                usuarioList.get(i).setAutenticado(true);
                usuarioDTOList.get(i).setAutenticado(true);

                return usuarioDTOList.get(i);
            }
        }
        return null;
    }

    @GetMapping
    public List<UsuarioDTO> listar(){
        return usuarioDTOList;
    }

    @DeleteMapping("/{email}")
    public String logoff(@PathVariable String email){

        for(int i=0; i < usuarioList.size(); i++){

            if(usuarioList.get(i).getEmail().equals(email) && usuarioList.get(i).isAutenticado()){
                usuarioList.get(i).setAutenticado(false);
                usuarioDTOList.get(i).setAutenticado(false);
                return String.format("Logoff do usuário %s concluído", usuarioList.get(i).getNomeUsuario());
            }
            else if(usuarioList.get(i).getEmail().equals(email) && !usuarioList.get(i).isAutenticado()){
                return String.format("Usuário %s NÃO está autenticado", usuarioList.get(i).getNomeUsuario());
            }
        }
        return String.format("Usuário %s não encontrado", email);
    }

    @GetMapping("/nomes")
    public List<String> mostrarNomes(){

        List<String> nomes = new ArrayList<>();

        for (Usuario u : usuarioList){
            nomes.add(u.getNomeUsuario());
        }
        return nomes;
    }

}
