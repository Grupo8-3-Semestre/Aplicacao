package school.sptech.voveaplication;

import java.util.Date;
import java.util.List;

public class Serie extends AudioVisual{
    private Integer qtdEps;
    private Integer qtdTemp;

    public Serie(String nome, String capa, String ondeAssistir, Double nota, Date datLanc, String diretor, String genero, Integer idadeIndicada, List<Ator> atores, Integer qtdEps, Integer qtdTemp) {
        super(nome, capa, ondeAssistir, nota, datLanc, diretor, genero, idadeIndicada, atores);
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
