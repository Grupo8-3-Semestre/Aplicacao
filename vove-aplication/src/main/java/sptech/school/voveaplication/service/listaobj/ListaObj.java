package sptech.school.voveaplication.service.listaobj;

import info.movito.themoviedbapi.model.MovieDb;

public class ListaObj<T> {

    // Atributos
    private T[] vetor;
    private int nroElem;
    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }
    public void adiciona(T elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista estÃ¡ cheia");
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }
    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }
    public int busca(T elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }
    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nIndice invalido!");
            return false;
        }
        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;
        return true;
    }
    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        else {
            return vetor[indice];
        }
    }

    public void limpa() {
        nroElem = 0;
    }



    public  void set(int index, T value) {
        try {
            vetor[index] = value;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo.");
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Tipo inválido para o elemento da lista.");
        }
    }

    public T[] getVetor() {
        return vetor;
    }

    public void setVetor(T[] vetor) {
        this.vetor = vetor;
    }

    public int getNroElem() {
        return nroElem;
    }

    public void setNroElem(int nroElem) {
        this.nroElem = nroElem;
    }
}

