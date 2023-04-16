package sptech.school.voveaplication;

import info.movito.themoviedbapi.model.Genre;

import java.util.List;

public class Filme extends AudioVisual {
    public Integer id;
    private Integer duracao;

    public Filme(String nome, String ondeAssistir, Float nota, String dataLanc, String diretor, String genero, Integer idadeIndicativa, long orcamento, Integer id, Integer duracao) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, idadeIndicativa, orcamento);
        this.id = id;
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
}
