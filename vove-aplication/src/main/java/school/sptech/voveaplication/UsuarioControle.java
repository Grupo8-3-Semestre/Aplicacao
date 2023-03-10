package school.sptech.voveaplication;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControle {
    List<Usuario> usuarios = new ArrayList<>();
    List<AudioVisual> listaFavoritos = new ArrayList<>();

    public String login(String username, String senha){
        for(Usuario usuario : usuarios){
            if(username.equalsIgnoreCase(usuario.getUsername()) && senha.equalsIgnoreCase(usuario.getSenha())){
                return "Usuario logado!";
            }
        }
        return "Usuario não existe!";
    }

    public String recuperarSenha(String email){
        for(Usuario usuario : usuarios){
            if(email.equalsIgnoreCase(usuario.getEmail())){
                return "Verifique sua caixa de email para recuperar sua senha!";
            }
        }
        return "Email não existe";
    }

    public String logoff(){
        return "Usuario fez o logoff";
    }

    public Usuario cadastar(Usuario e){
        usuarios.add(e);
        return e;
    }

    public String Deletar(String email, String senha){
        for(Usuario usuario : usuarios){
            if(email.equalsIgnoreCase(usuario.getEmail()) && senha.equalsIgnoreCase(usuario.getSenha())){
                usuarios.remove(usuario);
                return "Usuario deletado";
            }
        }
        return "Usuario não existe";
    }

    public String AdicionarNaListaDeFavorito (AudioVisual av){
    listaFavoritos.add(av);
    return av.getNome() + " foi adicionado a lista";
    }

    public String removerDaListaDeFavorito (AudioVisual av){
        listaFavoritos.remove(av);
        return av.getNome() + " foi removido da lista";
    }

    public String adicionarComentario(String comentario){
        return comentario;
    }

    public Integer avaliar(){
        Integer nota = 0;
        return nota;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
