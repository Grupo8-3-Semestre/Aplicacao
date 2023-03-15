package school.sptech.voveaplication;

import java.util.Date;

public class Filme extends AudioVisual{
    private Double duracao;

    public Filme(String nome, String ondeAssistir, Double nota, Date dataLanc, String diretor, String genero, Integer idadeIndicativa, Double duracao) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa);
        this.duracao = duracao;
    }

    @Override
    public Double getTempoTotal() {
        return duracao;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }
}
