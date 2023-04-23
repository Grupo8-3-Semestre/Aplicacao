package sptech.school.voveaplication.antigasClasses;

public class Filme extends AudioVisual {
    public Integer id;
    private Integer duracao;

    public Filme(String nome, String ondeAssistir, Float nota, String dataLanc, String diretor, String genero, String sinopse, String trailer, Number popularidade, String idadeIndicativa, long orcamento, Integer id, Integer duracao) {
        super(nome, ondeAssistir, nota, dataLanc, diretor, genero, sinopse, trailer, popularidade, idadeIndicativa, orcamento);
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

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", duracao=" + duracao +
                "} " + super.toString();
    }
}

