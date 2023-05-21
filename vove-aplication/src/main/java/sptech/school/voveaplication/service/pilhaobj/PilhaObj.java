package sptech.school.voveaplication.service.pilhaobj;

import java.util.Arrays;

public class PilhaObj<T> {
    private int topo;
    private T[] elementos;

    public PilhaObj(int tamanho) {
        this.topo = -1;
        this.elementos = (T[]) new Object[tamanho];
    }

    public boolean vazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == elementos.length - 1;
    }

    public void empilhar(T elemento) {
        if (!cheia()) {
            topo++;
            elementos[topo] = elemento;
        } else {
            throw new RuntimeException("A pilha está cheia");
        }
    }

    public T desempilhar() {
        if (!vazia()) {
            T elemento = elementos[topo];
            topo--;
            return elemento;
        } else {
            throw new RuntimeException("A pilha está vazia");
        }
    }

    public T topo() {
        if (!vazia()) {
            return elementos[topo];
        } else {
            throw new RuntimeException("A pilha está vazia");
        }
    }

    public void limpar() {
        topo = -1;
    }

    public int tamanho() {
        return topo + 1;
    }

    @Override
    public String toString() {
        return "PilhaObj{" +
                "topo=" + topo +
                ", elementos=" + Arrays.toString(elementos) +
                '}';
    }
}
