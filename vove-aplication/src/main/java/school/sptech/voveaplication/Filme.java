package school.sptech.voveaplication;

import java.util.Date;

public class Filme extends AudioVisual{
    private Integer duracao;

    public Filme(String nome, String ondeAssistir, Double nota, Date dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer duracao) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa);
        this.duracao = duracao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
