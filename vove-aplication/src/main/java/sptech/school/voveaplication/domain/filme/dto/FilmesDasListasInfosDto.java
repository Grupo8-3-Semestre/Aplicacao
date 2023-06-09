package sptech.school.voveaplication.domain.filme.dto;

public class FilmesDasListasInfosDto {

    private Double avaliacao;
    private String ondeAssistir;
    private String nomeFilme;
    private String genero;
    private String lancamento;
    private Integer duracaoFilme;
    private String poster;

    public FilmesDasListasInfosDto(Double avaliacao, String ondeAssistir, String nomeFilme, String genero, String lancamento, Integer duracaoFilme, String poster) {
        this.avaliacao = avaliacao;
        this.ondeAssistir = ondeAssistir;
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.lancamento = lancamento;
        this.duracaoFilme = duracaoFilme;
        this.poster = poster;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public Integer getDuracaoFilme() {
        return duracaoFilme;
    }

    public void setDuracaoFilme(Integer duracaoFilme) {
        this.duracaoFilme = duracaoFilme;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
