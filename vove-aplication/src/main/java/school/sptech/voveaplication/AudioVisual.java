package school.sptech.voveaplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract class AudioVisual {
    private String nome;
    private String ondeAssistir;
    private Double nota;
    private Date dataLanc;
    private String diretor;
    private List<Ator> atores;
    private String genero;
    private Integer idadeIndicativa;

    public AudioVisual(String nome, String ondeAssistir, Double nota, Date dataLanc, String diretor, String genero, Integer idadeIndicativa) {
        this.nome = nome;
        this.ondeAssistir = ondeAssistir;
        this.nota = nota;
        this.dataLanc = dataLanc;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
        this.genero = genero;
        this.idadeIndicativa = idadeIndicativa;
    }

    public abstract Double getTempoTotal();

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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Date getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(Date dataLanc) {
        this.dataLanc = dataLanc;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
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
}
