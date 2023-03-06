package school.sptech.voveaplication;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Filme extends AudioVisual{
    private Time duracao;

    public Filme(String nome, String capa, String ondeAssistir, Double nota, Date datLanc, String diretor, String genero, Integer idadeIndicada, List<Ator> atores, Time duracao) {
        super(nome, capa, ondeAssistir, nota, datLanc, diretor, genero, idadeIndicada, atores);
        this.duracao = duracao;
    }

    public Time getDuracao() {
        return duracao;
    }

    public void setDuracao(Time duracao) {
        this.duracao = duracao;
    }
}
