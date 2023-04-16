package sptech.school.voveaplication;

import info.movito.themoviedbapi.model.Genre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class  AudioVisual {

    private String nome;
    private String ondeAssistir;
    private Float nota;
    private String dataLanc;
//    private List<Elenco> personagens;
    private String diretor;
    private String genero;
    private Integer idadeIndicativa;
    private long orcamento;

    public AudioVisual(String nome, String ondeAssistir, Float nota, String dataLanc,
                       String diretor, String genero, Integer idadeIndicativa, long orcamento) {
        this.nome = nome;
        this.ondeAssistir = ondeAssistir;
        this.nota = nota;
        this.dataLanc = dataLanc;
//        this.personagens = personagens;
        this.diretor = diretor;
        this.genero = genero;
        this.idadeIndicativa = idadeIndicativa;
        this.orcamento = orcamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public String getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(String dataLanc) {
        this.dataLanc = dataLanc;
    }

//    public List<Elenco> getPersonagens() {
//        return personagens;
//    }

//    public void setPersonagens(List<Elenco> personagens) {
//        this.personagens = personagens;
//    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdadeIndicativa() {
        return idadeIndicativa;
    }

    public void setIdadeIndicativa(Integer idadeIndicativa) {
        this.idadeIndicativa = idadeIndicativa;
    }

    public long getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(long orcamento) {
        this.orcamento = orcamento;
    }
}
