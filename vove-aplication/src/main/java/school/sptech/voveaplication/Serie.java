package school.sptech.voveaplication;


import java.util.Date;

public class Serie extends AudioVisual{
    private Integer qtdEps;
    private Integer qtdTemp;

    public Serie(String nome, String ondeAssistir, Double nota, Date dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer qtdEps, Integer qtdTemp) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa);
        this.qtdEps = qtdEps;
        this.qtdTemp = qtdTemp;
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
