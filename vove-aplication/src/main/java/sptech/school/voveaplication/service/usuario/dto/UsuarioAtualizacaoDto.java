package sptech.school.voveaplication.service.usuario.dto;

public class UsuarioAtualizacaoDto {
    private String sexo;
    private Integer cep;
    private String generoPreferido;
    private Boolean assinaStreaming;
    private Integer qtdFrequencia;
    private Boolean buscaAvaliacao;
    private String aparelhoUtilizado;


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getGeneroPreferido() {
        return generoPreferido;
    }

    public void setGeneroPreferido(String generoPreferido) {
        this.generoPreferido = generoPreferido;
    }

    public Boolean getAssinaStreaming() {
        return assinaStreaming;
    }

    public void setAssinaStreaming(Boolean assinaStreaming) {
        this.assinaStreaming = assinaStreaming;
    }

    public Integer getQtdFrequencia() {
        return qtdFrequencia;
    }

    public void setQtdFrequencia(Integer qtdFrequencia) {
        this.qtdFrequencia = qtdFrequencia;
    }

    public Boolean getBuscaAvaliacao() {
        return buscaAvaliacao;
    }

    public void setBuscaAvaliacao(Boolean buscaAvaliacao) {
        this.buscaAvaliacao = buscaAvaliacao;
    }

    public String getAparelhoUtilizado() {
        return aparelhoUtilizado;
    }

    public void setAparelhoUtilizado(String aparelhoUtilizado) {
        this.aparelhoUtilizado = aparelhoUtilizado;
    }
}
