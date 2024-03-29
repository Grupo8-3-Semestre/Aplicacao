package sptech.school.voveaplication.antigasClasses;

public class Serie extends AudioVisual {
    private Integer qtdTotalEps;
    private Integer qtdTemporada;

    public Serie(String nome, String ondeAssistir, Float nota, String dataLanc, String diretor, String genero, String sinopse, String trailer, Number popularidade, String idadeIndicativa, long orcamento, Integer qtdTotalEps, Integer qtdTemporada) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, sinopse, trailer, popularidade, idadeIndicativa, orcamento);
        this.qtdTotalEps = qtdTotalEps;
        this.qtdTemporada = qtdTemporada;
    }

    public Integer getQtdTotalEps() {
        return qtdTotalEps;
    }

    public void setQtdTotalEps(Integer qtdTotalEps) {
        this.qtdTotalEps = qtdTotalEps;
    }

    public Integer getQtdTemporada() {
        return qtdTemporada;
    }

    public void setQtdTemporada(Integer qtdTemporada) {
        this.qtdTemporada = qtdTemporada;
    }
}
