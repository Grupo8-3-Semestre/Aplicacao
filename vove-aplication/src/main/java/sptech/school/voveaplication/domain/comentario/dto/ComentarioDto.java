package sptech.school.voveaplication.domain.comentario.dto;



public class ComentarioDto {


    private String nomeUsuario;
    private Integer avaliacao;
    private String descricao;
    private Boolean spoiler;

    public ComentarioDto(String nomeUsuario, Integer avaliacao, String descricao, Boolean spoiler) {
        this.nomeUsuario = nomeUsuario;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.spoiler = spoiler;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getSpoiler() {
        return spoiler;
    }

    public void setSpoiler(Boolean spoiler) {
        this.spoiler = spoiler;
    }
}
