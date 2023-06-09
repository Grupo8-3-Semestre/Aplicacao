package sptech.school.voveaplication.domain.lista;


public class ListaDtoResposta {


    private Long idLista;
    private String nomeLista;

    public ListaDtoResposta(Long idLista, String nomeLista) {
        this.idLista = idLista;
        this.nomeLista = nomeLista;
    }

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }
}
