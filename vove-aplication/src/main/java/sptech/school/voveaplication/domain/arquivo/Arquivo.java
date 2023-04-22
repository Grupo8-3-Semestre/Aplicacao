package sptech.school.voveaplication.domain.arquivo;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;
    @Lob
    @Column(name = "dados")
    private byte[] dados;
    private LocalDate dataUpload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivoOriginal() {
        return nomeArquivoOriginal;
    }

    public void setNomeArquivoOriginal(String nomeArquivoOriginal) {
        this.nomeArquivoOriginal = nomeArquivoOriginal;
    }

    public String getNomeArquivoSalvo() {
        return nomeArquivoSalvo;
    }

    public void setNomeArquivoSalvo(String nomeArquivoSalvo) {
        this.nomeArquivoSalvo = nomeArquivoSalvo;
    }

    public LocalDate getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDate dataUpload) {
        this.dataUpload = dataUpload;
    }
}
