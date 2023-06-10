package sptech.school.voveaplication.domain.arquivo;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;

    @Lob
    @Column(name = "dados", length = 31457280) // 30MB (30 * 1024 * 1024 bytes)
    private byte[] dados;

    private LocalDate dataUpload;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public byte[] getDados() {
        return dados;
    }

    public void setDados(byte[] dados) {
        if (dados.length > 31457280) {
            throw new IllegalArgumentException("Tamanho do arquivo excede o limite de 30MB.");
        }
        this.dados = dados;
    }

    public LocalDate getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDate dataUpload) {
        this.dataUpload = dataUpload;
    }
}
