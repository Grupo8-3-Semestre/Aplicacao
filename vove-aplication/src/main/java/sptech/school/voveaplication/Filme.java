package sptech.school.voveaplication;

import java.time.LocalDate;

public class Filme extends AudioVisual {
    private Integer duracao;

    public Filme(String nome, String ondeAssistir, Integer nota, LocalDate dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer orcamento, Integer duracao) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa, orcamento);
        this.duracao = duracao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
