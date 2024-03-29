package sptech.school.voveaplication.service.csv;

import info.movito.themoviedbapi.model.MovieDb;
import sptech.school.voveaplication.domain.arquivo.repository.ArquivoRepository;
import sptech.school.voveaplication.service.listaobj.ListaObj;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GravarOuLerArquivoCSV {
    private ArquivoRepository arquivoRepository;

    public void gravaArquivoCsv(ListaObj<MovieDb> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {
            for (int i=0; i < lista.getTamanho(); i++) {

                MovieDb filme = lista.getElemento(i);
                saida.format("%d,%s;%s;%.2f;%s;%d;%s;%.2f;%d;%s\n",
                        filme.getId(),
                        filme.getTitle(),
                        filme.getReleaseDate(),
                        filme.getPopularity(),
                        filme.getOriginalLanguage(),
                        filme.getBudget(),
                        filme.getOriginalTitle(),
                        filme.getVoteAverage(),
                        filme.getVoteCount(),
                        filme.getOverview());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim= true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }




    }

    public void leArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo nao encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            System.out.printf("%4S %-25S %-9S %8S %8S\n","id","nome","diretor","idadeIndicativa","Orçamento");
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                String nome = entrada.next();
                String diretor = entrada.next();
                int idadeIndicativa = entrada.nextInt();
                long orcamento = entrada.nextLong();
                System.out.printf("%4d %-25s %-9s %15d %9d\n",id,nome,diretor,idadeIndicativa,orcamento);
            }
        }
        catch(NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch(IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
