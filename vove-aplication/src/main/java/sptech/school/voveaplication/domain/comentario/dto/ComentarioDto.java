package sptech.school.voveaplication.domain.comentario.dto;



public class ComentarioDto {


    private String nome;
    private Integer avaliacao;
    private String descricao;
    private Boolean spoiler;


    public ComentarioDto(String nome, Integer avaliacao, String descricao, Boolean spoiler) {
        this.nome = nome;
        this.avaliacao = avaliacao;
        this.descricao = descricao;
        this.spoiler = spoiler;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
