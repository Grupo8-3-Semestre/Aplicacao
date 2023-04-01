package sptech.school.voveaplication;

import java.time.LocalDate;

public class Serie extends AudioVisual{
    private Integer qtdTotalEps;
    private Integer qtdTemporada;

    public Serie(String nome, String ondeAssistir, Integer nota, LocalDate dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer orcamento, Integer qtdTotalEps, Integer qtdTemporada) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa, orcamento);
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
