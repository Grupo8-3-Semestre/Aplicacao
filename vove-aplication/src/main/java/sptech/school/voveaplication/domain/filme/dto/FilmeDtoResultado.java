package sptech.school.voveaplication.domain.filme.dto;

public class FilmeDtoResultado {
    private String nomeUsuario;
    private Integer idFilme;
    private String posterPath;
    private String nomeFilme;
    private String comentario;
    private float notaGeral;
    private Boolean spoiler;

    public FilmeDtoResultado(String nomeUsuario, Integer idFilme, String posterPath, String nomeFilme, String comentario, float notaGeral, Boolean spoiler) {
        this.nomeUsuario = nomeUsuario;
        this.idFilme = idFilme;
        this.posterPath = posterPath;
        this.nomeFilme = nomeFilme;
        this.comentario = comentario;
        this.notaGeral = notaGeral;
        this.spoiler = spoiler;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getNotaGeral() {
        return notaGeral;
    }

    public void setNotaGeral(float notaGeral) {
        this.notaGeral = notaGeral;
    }

    public Boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }
}
