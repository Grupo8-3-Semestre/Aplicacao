package school.sptech.voveaplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class AudioVisual {

    private String nome;
    private String capa;
    private String ondeAssistir;
    private Double nota;
    private Date datLanc;
    private String diretor;
    private String genero;
    private Integer idadeIndicada;
    private List<Ator> atores;
    private List<Filme> filmes;

    private List<Serie> series;
    public AudioVisual(String nome, String capa, String ondeAssistir, Double nota, Date datLanc, String diretor,
                       String genero, Integer idadeIndicada, List<Ator> atores) {
        this.nome = nome;
        this.capa = capa;
        this.ondeAssistir = ondeAssistir;
        this.nota = nota;
        this.datLanc = datLanc;
        this.diretor = diretor;
        this.genero = genero;
        this.idadeIndicada = idadeIndicada;
        this.atores = new ArrayList<>();
    }

    public List<Ator> listaAtores(){
        return atores;
    }

    public List<Filme> listaFilmesMaisPopulares(){
        return filmes;
    }
    public List<Serie> listaSeriesMaisPopulares(){
        return series;
    }
}
