package sptech.school.voveaplication.api.controller.lista;

import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.voveaplication.domain.lista.Lista;
import sptech.school.voveaplication.domain.lista.repository.ListaRepository;
import sptech.school.voveaplication.domain.usuario.Usuario;
import sptech.school.voveaplication.domain.usuario.repository.UsuarioRepository;

@RestController
@RequestMapping("/listas")
public class listaController {
    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    private ResponseEntity<Lista> criar(@RequestBody Lista lista, @RequestParam Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new OpenApiResourceNotFoundException("Usuário não encontrado"));

    }

}
