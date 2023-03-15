package school.sptech.voveaplication;


import java.util.Date;

public class Serie extends AudioVisual{
    private Integer qtdEps;
    private Integer qtdTemp;
    private Double duracaoEp;

    public Serie(String nome, String ondeAssistir, Double nota, Date dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer qtdEps, Integer qtdTemp, Double duracaoEp) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa);
        this.qtdEps = qtdEps;
        this.qtdTemp = qtdTemp;
        this.duracaoEp = duracaoEp;
    }

    @Override
    public Double getTempoTotal() {
        return duracaoEp * qtdEps;
    }

    public Double getDuracaoEp() {
        return duracaoEp;
    }

    public void setDuracaoEp(Double duracaoEp) {
        this.duracaoEp = duracaoEp;
    }

    public Integer getQtdEps() {
        return qtdEps;
    }

    public void setQtdEps(Integer qtdEps) {
        this.qtdEps = qtdEps;
    }

    public Integer getQtdTemp() {
        return qtdTemp;
    }

    public void setQtdTemp(Integer qtdTemp) {
        this.qtdTemp = qtdTemp;
    }
}
