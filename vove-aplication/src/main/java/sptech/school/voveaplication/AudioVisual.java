package sptech.school.voveaplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class  AudioVisual {

    private String nome;
    private String ondeAssistir;
    private Integer nota;
    private LocalDate dataLanc;
    private List<Elenco> personagens;
    private String diretor;
    private String genero;
    private Integer idadeIndicativa;
    private Integer orcamento;

    public AudioVisual(String nome, String ondeAssistir, Integer nota, LocalDate dataLanc, String diretor, String genero, Integer idadeIndicativa, Integer orcamento) {
        this.nome = nome;
        this.ondeAssistir = ondeAssistir;
        this.nota = nota;
        this.dataLanc = dataLanc;
        this.personagens = new ArrayList<>();
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

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public LocalDate getDataLanc() {
        return dataLanc;
    }

    public void setDataLanc(LocalDate dataLanc) {
        this.dataLanc = dataLanc;
    }

    public List<Elenco> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Elenco> personagens) {
        this.personagens = personagens;
    }

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

    public Integer getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Integer orcamento) {
        this.orcamento = orcamento;
    }
}
