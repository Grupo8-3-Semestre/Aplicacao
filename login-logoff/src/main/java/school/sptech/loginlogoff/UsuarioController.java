package school.sptech.loginlogoff;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody Usuario novoUsuario) {
        usuarioList.add(novoUsuario);
        UsuarioDTO userDTO = new UsuarioDTO(novoUsuario);
        usuarioDTOList.add(userDTO);

        return ResponseEntity.status(201).body(userDTO);
    }

    @PostMapping("/{email}/{senha}")
    public ResponseEntity<UsuarioDTO> autenticar(@PathVariable String email,
                                 @PathVariable String senha) {

        for (int i =0; i < usuarioList.size(); i++) {

            if (usuarioList.get(i).getEmail().equals(email) && usuarioList.get(i).getSenha().equals(senha)) {
                usuarioList.get(i).setAutenticado(true);
                usuarioDTOList.get(i).setAutenticado(true);

                return ResponseEntity.status(202).body(usuarioDTOList.get(i));
            }
        }
        return ResponseEntity.status(400).build();

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        if(usuarioDTOList.isEmpty()){
            return ResponseEntity.status(204).build();

        }


        return ResponseEntity.status(200).body(usuarioDTOList);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String>  logoff(@PathVariable String email){

        for(int i=0; i < usuarioList.size(); i++){

            if(usuarioList.get(i).getEmail().equals(email) && usuarioList.get(i).isAutenticado()){
                usuarioList.get(i).setAutenticado(false);
                usuarioDTOList.get(i).setAutenticado(false);


            return ResponseEntity.status(202).body(String.format("Logoff do usuário %s concluído", usuarioList.get(i).getNomeUsuario()));

            }
            else if(usuarioList.get(i).getEmail().equals(email) && !usuarioList.get(i).isAutenticado()){

                return ResponseEntity.status(400).body(String.format("Usuário %s NÃO está autenticado", usuarioList.get(i).getNomeUsuario()));

            }
        }
        return ResponseEntity.status(404).body(String.format("Usuário %s não encontrado", email));
    }

    @GetMapping("/nomes")
    public ResponseEntity<List<String>> mostrarNomes(){

        List<String> nomes = new ArrayList<>();

        for (Usuario u : usuarioList){
            nomes.add(u.getNomeUsuario());
        }
        if(nomes.isEmpty()){
            return ResponseEntity.status(204).build();

        }

        return ResponseEntity.status(200).body(nomes);
    }

}
