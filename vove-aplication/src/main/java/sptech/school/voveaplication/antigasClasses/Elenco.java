package sptech.school.voveaplication.antigasClasses;

public class Elenco {
    private String linkFoto;
    private String nomeAtor;
    private String nomePersonagem;

    public Elenco(String linkFoto, String nomeAtor, String nomePersonagem) {
        this.linkFoto = linkFoto;
        this.nomeAtor = nomeAtor;
        this.nomePersonagem = nomePersonagem;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }
}
